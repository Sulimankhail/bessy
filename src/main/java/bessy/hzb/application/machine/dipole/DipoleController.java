package bessy.hzb.application.machine.dipole;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DipoleController {
	@Autowired DipoleService dipolService;
	// get all Dipole
	@RequestMapping("/dipoles")
	public List<Dipole> getAllDipole() {
		return dipolService.getAllDipoles();
	}
	//get a specific dipole
	@RequestMapping("/dipoles/{id}")
	public Dipole getDipole(@PathVariable Long id) {
		return dipolService.getDipole(id);
	}
	
	// add a dipole
	@RequestMapping(method=RequestMethod.POST, value="/dipoles")
	public void addDipole(@RequestBody Dipole dipolePayload) {
		dipolService.addDipole(dipolePayload);
	}
}
