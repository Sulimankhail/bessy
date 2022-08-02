package bessy.hzb.application.machine.quadrupole;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuadrupoleController {
	@Autowired QuadrupoleService quadrupoleService;
	// get all Quadrupole
	@RequestMapping("/quadrupole")
	public List<Quadrupole> getAllQuadrupole() {
		return quadrupoleService.getAllQuadrupoles();
	}
	//get a specific Quadrupole
	@RequestMapping("/quadrupole/{id}")
	public Quadrupole getQuadrupole(@PathVariable Long id) {
		return quadrupoleService.getQuadrupole(id);
	}
	
	// add a Quadrupole
	@RequestMapping(method=RequestMethod.POST, value="/quadrupole")
	public void addQuadrupole(@RequestBody Quadrupole quadrupolePayload) {
		quadrupoleService.addQuadrupole(quadrupolePayload);
	}
}
