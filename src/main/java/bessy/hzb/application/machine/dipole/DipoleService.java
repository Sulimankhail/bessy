package bessy.hzb.application.machine.dipole;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DipoleService  {
	@Autowired
	private DipoleRepository dipoleRepository;
	public List<Dipole> getAllDipoles(){
		List<Dipole> dipoles = new ArrayList<>();
		dipoleRepository.findAll()
		.forEach( dipoles::add);
		return dipoles;
	}

	public Dipole getDipole(Long id) {
		return dipoleRepository.findById(id).get();
	}

	public void addDipole(Dipole dipolePayload) {
		dipoleRepository.save(dipolePayload);
	}
}


