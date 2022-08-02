package bessy.hzb.application.machine.sequencer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SequencerRepository extends JpaRepository<Sequencer, Long> {

	/*
	 * Framework will create all the CRUD methods
	 * getAllMachines()
	 * getMachine()
	 * updateMachine()
	 * deleteMachine()
	 * */
	Sequencer findByDeviceId(Long id);
}
