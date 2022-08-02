package bessy.hzb.application.machine.drift;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DriftController {
	@Autowired DriftService driftService;
	// get all Drift
	@RequestMapping("/drift")
	public List<Drift> getAllDrift() {
		return driftService.getAllDrifts();
	}
	//get a specific Drift
	@RequestMapping("/drift/{id}")
	public Drift getDrift(@PathVariable Long id) {
		return driftService.getDrift(id);
	}
	
	// add a Drift
	@RequestMapping(method=RequestMethod.POST, value="/drift")
	public void addDrift(@RequestBody Drift driftPayload) {
		driftService.addDrift(driftPayload);
	}
}
