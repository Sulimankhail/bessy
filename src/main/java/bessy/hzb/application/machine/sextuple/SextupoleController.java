package bessy.hzb.application.machine.sextuple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SextupoleController {
	@Autowired SextupoleService sextupoleService;
	// get all sextupole
	@RequestMapping("/sextupole")
	public List<Sextupole> getAllSextupole() {
		return sextupoleService.getAllSextupoles();
	}
	//get a specific sextupole
	@RequestMapping("/sextupole/{id}")
	public Sextupole getSextupole(@PathVariable Long id) {
		return sextupoleService.getSextupole(id);
	}
	
	// add a sextupole
	@RequestMapping(method=RequestMethod.POST, value="/sextupole")
	public void addsextupole(@RequestBody Sextupole sextupolePayload) {
		sextupoleService.addSextupole(sextupolePayload);
	}
}
