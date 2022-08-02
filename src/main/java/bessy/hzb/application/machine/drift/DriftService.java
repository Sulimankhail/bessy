package bessy.hzb.application.machine.drift;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriftService {
	@Autowired
	private DriftRepository driftRepository;
	public List<Drift> getAllDrifts(){
		List<Drift> drifts = new ArrayList<>();
		driftRepository.findAll()
		.forEach( drifts::add);
		return drifts;
	}

	public Drift getDrift(Long id) {
		return driftRepository.findById(id).get();
	}
	
	public void addDrift(Drift driftPayload) {
		driftRepository.save(driftPayload);
	}	
}
