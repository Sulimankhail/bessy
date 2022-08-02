package bessy.hzb.application.machine.quadrupole;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuadrupoleService {
	@Autowired
	private QuadrupoleRepository quadrupoleRepository;
	public List<Quadrupole> getAllQuadrupoles(){
		List<Quadrupole> quadrupoles = new ArrayList<>();
		quadrupoleRepository.findAll()
		.forEach( quadrupoles::add);
		return quadrupoles;
	}

	public Quadrupole getQuadrupole(Long id) {
		return quadrupoleRepository.findById(id).get();
	}

	public void addQuadrupole(Quadrupole quadrupolePayload) {
		quadrupoleRepository.save(quadrupolePayload);
	}	
}
