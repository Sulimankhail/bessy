package bessy.hzb.application.machine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bessy.hzb.application.machine.dipole.Dipole;
import bessy.hzb.application.machine.dipole.DipoleService;
import bessy.hzb.application.machine.drift.Drift;
import bessy.hzb.application.machine.drift.DriftService;
import bessy.hzb.application.machine.quadrupole.Quadrupole;
import bessy.hzb.application.machine.quadrupole.QuadrupoleService;
import bessy.hzb.application.machine.sextuple.Sextupole;
import bessy.hzb.application.machine.sextuple.SextupoleService;

@RestController
public class MachineController {

	@Autowired private MachineService machineService;
	@Autowired DriftService driftService;
	@Autowired SextupoleService sextupoleService;
	@Autowired QuadrupoleService quadrupoleService;
	// get all machines
	@RequestMapping("/machines")
	public List<Machine> getAllMachines() {
		return machineService.getAllMachines();
	}
	
	// get all dipoles from a machine
	@RequestMapping("/machine/{id}/dipoles")
	public Set<Dipole> getMachineAllDipoles(@PathVariable Long id) {
		return machineService.getMachine(id).getDipoles();
	}
	
	//get a specific dipole from a specific machine
	@RequestMapping("/machine/{id}")
	public Machine getMachine(@PathVariable Long id) {
		return machineService.getMachine(id);
	}
	
	//get a specific machine
	@RequestMapping("/machine/{machineId}/dipoles/{dipoleId}")
	public Machine getMachineDipoles(@PathVariable Long machineId,@PathVariable Long dipoleId) {
		return machineService.getMachine(machineId);
	}
	
	// add a machine
	@RequestMapping(method=RequestMethod.POST, value="/machines")
	public void addMachine(@RequestBody Machine machinePayload) {
		machineService.addMachine(machinePayload);
	}

	// add a machine
	@RequestMapping(method=RequestMethod.POST
			, value="/machines/{machineId}/calculate")
	public void calculateBeamPosition(@PathVariable Long machineId) throws JsonProcessingException {
		machineService.calculateBeamPosition(machineId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/machine/{id}")
	public void updateMachine(@RequestBody Machine machine, @PathVariable Long id) {
		machineService.updateMachine(machine);
	}
	
	// add a dipole to a specific machine
	@PutMapping("/machine/{machineId}/dipoles/{dipoleId}")
	public void addDipoleToMachine(@PathVariable Long machineId,@PathVariable Long dipoleId) {
		machineService.addDipoleToMachine(machineId,dipoleId);
	}

	// add a sextupole to a specific machine
	@PutMapping("/machine/{machineId}/sextupoles/{sextupoleId}")
	public void addSextupoleToMachine(@PathVariable Long machineId,@PathVariable Long sextupoleId) {
		machineService.addSextupoleToMachine(machineId,sextupoleId);
	}

	// add a dipole to a specific machine
	@PutMapping("/machine/{machineId}/drifts/{driftId}")
	public void addDriftToMachine(@PathVariable Long machineId,@PathVariable Long driftId) {
		machineService.addDriftToMachine(machineId,driftId);
	}
	// add a quadrupole to a specific machine
	@PutMapping("/machine/{machineId}/quadrupoles/{quadrupoleId}")
	public void addQuadrupoleToMachine(@PathVariable Long machineId,@PathVariable Long quadrupoleId) {
		machineService.addQuadrupoleToMachine(machineId,quadrupoleId);
	}
}
