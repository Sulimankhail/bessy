package bessy.hzb.application.machine.quadrupole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadrupoleRepository extends JpaRepository<Quadrupole, Long> {

	/*
	 * Framework will create all the CRUD methods
	 * getAllMachines()
	 * getMachine()
	 * updateMachine()
	 * deleteMachine()
	 * */
}
