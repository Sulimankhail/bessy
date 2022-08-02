package bessy.hzb.application.machine.sextuple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SextupoleService {
	
	@Autowired
	private SextupoleRepository sextupoleRepository;
	public List<Sextupole> getAllSextupoles(){
		List<Sextupole> sextupoles = new ArrayList<>();
		sextupoleRepository.findAll()
		.forEach( sextupoles::add);
		return sextupoles;
	}

	public Sextupole getSextupole(Long id) {
		return sextupoleRepository.findById(id).get();
	}

	public void addSextupole(Sextupole sextupolePayload) {
		sextupoleRepository.save(sextupolePayload);
	}	
	
}
