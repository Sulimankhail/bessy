package bessy.hzb.application.machine.drift;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DriftRepository extends JpaRepository<Drift, Long> {

	/*
	 * Framework will create all the CRUD methods
	 * getAllMachines()
	 * getMachine()
	 * updateMachine()
	 * deleteMachine()
	 * */
}
