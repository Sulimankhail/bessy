package bessy.hzb.application.machine.sextuple;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SextupoleRepository extends JpaRepository<Sextupole, Long> {

	/*
	 * Framework will create all the CRUD methods
	 * getAllMachines()
	 * getMachine()
	 * updateMachine()
	 * deleteMachine()
	 * */
}
