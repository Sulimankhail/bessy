package bessy.hzb.application.machine.sequencer;

import bessy.hzb.application.machine.sequencer.Sequencer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SequencerController {
	@Autowired
    SequencerService sequencerService;
	// get all sequencer
	@RequestMapping("/sequencer")
	public List<Sequencer> getAllSequencer() {
		return sequencerService.getAllSequencers();
	}
	//get a specific sequencer
	@RequestMapping("/sequencer/{id}")
	public Sequencer getSequencer(@PathVariable Long id) {
		return sequencerService.getSequencer(id);
	}
	
	// add a sequencer
	@RequestMapping(method=RequestMethod.POST, value="/sequencer")
	public void addsequencer(@RequestBody Sequencer sequencerPayload) {
		sequencerService.addSequencer(sequencerPayload);
	}
}
