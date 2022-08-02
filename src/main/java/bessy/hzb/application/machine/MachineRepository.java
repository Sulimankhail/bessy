package bessy.hzb.application.machine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {

	/*
	 * Framework will create all the CRUD methods
	 * getAllMachines()
	 * getMachine()
	 * updateMachine()
	 * deleteMachine()
	 * */
}
