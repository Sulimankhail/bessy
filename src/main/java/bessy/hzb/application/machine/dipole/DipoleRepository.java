package bessy.hzb.application.machine.dipole;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DipoleRepository extends JpaRepository<Dipole, Long> {

	/*
	 * Framework will create all the CRUD methods
	 * getAllMachines()
	 * getMachine()
	 * updateMachine()
	 * deleteMachine()
	 * */
}
