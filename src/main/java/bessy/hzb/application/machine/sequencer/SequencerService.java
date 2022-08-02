package bessy.hzb.application.machine.sequencer;

import bessy.hzb.application.machine.sequencer.Sequencer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SequencerService {
	
	@Autowired
	private SequencerRepository sequencerRepository;
	public List<Sequencer> getAllSequencers(){
		List<Sequencer> sequencers = new ArrayList<>();
		sequencerRepository.findAll()
		.forEach( sequencers::add);
		return sequencers;
	}

	public Sequencer getSequencer(Long id) {
		return sequencerRepository.findById(id).get();
	}
	public Sequencer getSequencerByDeviceId(Long dipoleId) {
		return sequencerRepository.findByDeviceId(dipoleId);
	}

	public void addSequencer(Sequencer sequencerPayload) {
		sequencerRepository.save(sequencerPayload);
	}
}
