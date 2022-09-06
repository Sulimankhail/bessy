package bessy.hzb.application.machine;

import java.util.*;

import bessy.hzb.application.machine.beamPosition.BeamPositions;
import bessy.hzb.application.machine.beamPosition.BeamPositionsService;
import bessy.hzb.application.machine.elementPosition.ElementPosition;
import bessy.hzb.application.machine.dipole.Dipole;
import bessy.hzb.application.machine.dipole.DipoleService;
import bessy.hzb.application.machine.drift.Drift;
import bessy.hzb.application.machine.drift.DriftService;
import bessy.hzb.application.machine.elementPosition.ElementPositionService;
import bessy.hzb.application.machine.quadrupole.Quadrupole;
import bessy.hzb.application.machine.quadrupole.QuadrupoleService;
import bessy.hzb.application.machine.sequencer.Sequencer;
import bessy.hzb.application.machine.sequencer.SequencerService;
import bessy.hzb.application.machine.sextuple.Sextupole;
import bessy.hzb.application.machine.sextuple.SextupoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MachineService {
	@Autowired
	private MachineRepository machineRepository;
	@Autowired
	SequencerService sequencerService;
	@Autowired
	ElementPositionService elementPositionService;
	@Autowired
	BeamPositionsService beamPositionsService;
	@Autowired
	DipoleService dipoleService;
	@Autowired
	DriftService driftService;
	@Autowired
	SextupoleService sextupoleService;
	@Autowired
	QuadrupoleService quadrupoleService;

	List<Machine> machines = new ArrayList<>( Arrays.asList(
	));
	public List<Machine> getAllMachines(){
//		return machines;
		List<Machine> machines = new ArrayList<>();
		machineRepository.findAll()
		.forEach( machines::add);
		return machines;
	}

	public Machine getMachine(Long id) {
		return machineRepository.findById(id).get();		
	}

	public void addMachine(Machine machinePayload) {
		machineRepository.save(machinePayload);
	}

	public void updateMachine(Machine machine) {
		// TODO Auto-generated method stub
		machineRepository.save(machine);		
	}

    public void addDipoleToMachine(Long machineId, Long dipoleId) {
		Machine machine = getMachine(machineId);
		Dipole dipole = dipoleService.getDipole(dipoleId);
		machine.addDipole(dipole);
		Sequencer sequence = new Sequencer(dipoleId,machine.getLength(), machine.getLength() + dipole.getLength(), dipole.getType(), dipole.getName(),dipole.getLength(), dipole.getN());
		addSequencer(machine,sequence,dipoleId);
		machine.updateMachineLenght(dipole.getLength());
		updateMachine(machine);
    }
	public void addDriftToMachine(Long machineId, Long driftId) {
		Machine machine = getMachine(machineId);
		Drift drift = driftService.getDrift(driftId);
		machine.addDrift(drift);
		Sequencer sequence = new Sequencer(driftId,machine.getLength(), machine.getLength() + drift.getLength(), drift.getType(), drift.getName(), drift.getLength(), drift.getN());
		addSequencer(machine,sequence,driftId);
		machine.updateMachineLenght(drift.getLength());
		updateMachine(machine);
	}

	public void addSextupoleToMachine(Long machineId, Long sextupoleId) {
		Machine machine = getMachine(machineId);
		Sextupole sextupole = sextupoleService.getSextupole(sextupoleId);
		machine.addSextupole(sextupole);
		Sequencer sequence = new Sequencer(sextupoleId,machine.getLength(), machine.getLength() + sextupole.getLength(), sextupole.getType(), sextupole.getName(),sextupole.getLength(), sextupole.getN());
		addSequencer(machine,sequence,sextupoleId);
		machine.updateMachineLenght(sextupole.getLength());
		updateMachine(machine);
	}

	public void addQuadrupoleToMachine(Long machineId, Long quadrupoleId) {
		Machine machine = getMachine(machineId);
		Quadrupole quadrupole = quadrupoleService.getQuadrupole(quadrupoleId);
		machine.addQuadrupole(quadrupole);
		Sequencer sequence = new Sequencer(quadrupoleId,machine.getLength(), machine.getLength() + quadrupole.getLength(), quadrupole.getType(), quadrupole.getName(), quadrupole.getLength(), quadrupole.getN());
		addSequencer(machine,sequence,quadrupoleId);
		machine.updateMachineLenght(quadrupole.getLength());
		updateMachine(machine);
	}
	private void addSequencer(Machine machine, Sequencer sequence, Long deviceId){
		sequencerService.addSequencer(sequence);
		machine.addSequence(sequencerService.getSequencerByDeviceId(deviceId));
	}


    public void calculateBeamPosition(Long machineId) throws JsonProcessingException {
		// call the controller from python to compute beam position
		Machine machine  = getMachine(machineId);
		RestTemplate restTemplate = new RestTemplate();
		List<ElementPosition> elementPositionList =new ArrayList<>();
		// initialize with null/zero values
		ElementPosition elementPosition = new ElementPosition("",0.0,"",0, 45,-13,0.0,0.0,0.0,0.0);
		List<BeamPositions> beamPositionsSet = new ArrayList<>();
//		List<BeamPositions> beamPositionsSet = new ArrayList<>();
		int y =0;
		for ( int x =0; x<200; x++) {
			List<ElementPosition> elementPositionSet =new ArrayList<>();
			y =0;
			for( Sequencer s :  machine.getSequences()){

				//get the element info from the sequencer
				elementPosition.setName(s.getName());
				elementPosition.setL(s.getL());
				elementPosition.setType(s.getType());
				elementPosition.setN(s.getN());
				if(elementPositionSet.size()>0){
					// add ps values (the current position should be returned)
					// @INFO: the current position can be entered manually or through some input in the future
					// the current position variables are: x, px , y , px, delta, charlieTango CT
					elementPosition.setX(elementPositionSet.stream().reduce((prev, next) -> next).orElse(null).getX());
					elementPosition.setPx(elementPositionSet.stream().reduce((prev, next) -> next).orElse(null).getPx());
					elementPosition.setY(elementPositionSet.stream().reduce((prev, next) -> next).orElse(null).getY());
					elementPosition.setPy(elementPositionSet.stream().reduce((prev, next) -> next).orElse(null).getPy());
					elementPosition.setDt(elementPositionSet.stream().reduce((prev, next) -> next).orElse(null).getDt());
					elementPosition.setCt(elementPositionSet.stream().reduce((prev, next) -> next).orElse(null).getCt());
				}
				elementPosition= restTemplate.postForObject("http://127.0.0.1:5000/propagate", elementPosition, elementPosition.getClass());
				elementPositionSet.add(y,elementPosition);
				y++;
			}
	//		Store the result in DB
			elementPositionList.addAll(elementPositionSet);
//			elementPositionService.addElementPositionSet( elementPositionSet);
			BeamPositions beamPositions = new BeamPositions();
			beamPositions.setElementPositions(elementPositionSet);
			beamPositionsSet.add(x,beamPositions);
//			beamPositionsService.addBeamPositions(beamPositions);
		}
		elementPositionService.addElementPositionSet( elementPositionList);
		beamPositionsService.addBeamPositions(beamPositionsSet);

		machine.setBeamPositions(beamPositionsSet);
		updateMachine(machine);
	}
}
 