package bessy.hzb.application.machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bessy.hzb.application.machine.dipole.Dipole;
import bessy.hzb.application.machine.dipole.DipoleService;
import bessy.hzb.application.machine.drift.Drift;
import bessy.hzb.application.machine.drift.DriftService;
import bessy.hzb.application.machine.quadrupole.Quadrupole;
import bessy.hzb.application.machine.quadrupole.QuadrupoleService;
import bessy.hzb.application.machine.sequencer.Sequencer;
import bessy.hzb.application.machine.sequencer.SequencerService;
import bessy.hzb.application.machine.sextuple.Sextupole;
import bessy.hzb.application.machine.sextuple.SextupoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MachineService {
	@Autowired
	private MachineRepository machineRepository;
	@Autowired
	SequencerService sequencerService;
	@Autowired
	DipoleService dipoleService;
	@Autowired
	DriftService driftService;
	@Autowired
	SextupoleService sextupoleService;
	@Autowired
	QuadrupoleService quadrupoleService;

	List<Machine> machines = new ArrayList<>( Arrays.asList(
//			new Machine("12", "machine 1", "bessy 2 machine developed in year xxx", 
//					SextupoleService.getAllSextupoles(),DipoleService.getAllDipoles(),
//					DriftService.getAllDrifts(), QuadrupoleService.getAllQuadrupoles())
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
		Sequencer sequence = new Sequencer(dipoleId,machine.getLength(), machine.getLength() + dipole.getLength(), dipole.getType());
		addSequencer(machine,sequence,dipoleId);
		machine.updateMachineLenght(dipole.getLength());
		updateMachine(machine);
    }
	public void addDriftToMachine(Long machineId, Long driftId) {
		Machine machine = getMachine(machineId);
		Drift drift = driftService.getDrift(driftId);
		machine.addDrift(drift);
		Sequencer sequence = new Sequencer(driftId,machine.getLength(), machine.getLength() + drift.getLength(), drift.getType());
		addSequencer(machine,sequence,driftId);
		machine.updateMachineLenght(drift.getLength());
		updateMachine(machine);
	}

	public void addSextupoleToMachine(Long machineId, Long sextupoleId) {
		Machine machine = getMachine(machineId);
		Sextupole sextupole = sextupoleService.getSextupole(sextupoleId);
		machine.addSextupole(sextupole);
		Sequencer sequence = new Sequencer(sextupoleId,machine.getLength(), machine.getLength() + sextupole.getLength(), sextupole.getType());
		addSequencer(machine,sequence,sextupoleId);
		machine.updateMachineLenght(sextupole.getLength());
		updateMachine(machine);
	}

	public void addQuadrupoleToMachine(Long machineId, Long quadrupoleId) {
		Machine machine = getMachine(machineId);
		Quadrupole quadrupole = quadrupoleService.getQuadrupole(quadrupoleId);
		machine.addQuadrupole(quadrupole);
		Sequencer sequence = new Sequencer(quadrupoleId,machine.getLength(), machine.getLength() + quadrupole.getLength(), quadrupole.getType());
		addSequencer(machine,sequence,quadrupoleId);
		machine.updateMachineLenght(quadrupole.getLength());
		updateMachine(machine);
	}
	private void addSequencer(Machine machine, Sequencer sequence, Long deviceId){
		sequencerService.addSequencer(sequence);
		machine.addSequence(sequencerService.getSequencerByDeviceId(deviceId));
	}
}
 