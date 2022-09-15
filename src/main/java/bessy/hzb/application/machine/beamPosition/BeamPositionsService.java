package bessy.hzb.application.machine.beamPosition;

import bessy.hzb.application.machine.elementPosition.ElementPosition;
import bessy.hzb.application.machine.sequencer.Sequencer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeamPositionsService {
    @Autowired
    private BeamPositionsRepository beamPositionsRepository;

    public List<BeamPositions> getAllBeamPositions(){
        List<BeamPositions> beamPositions = new ArrayList<>();
        beamPositionsRepository.findAll()
                .forEach( beamPositions::add);
        return beamPositions;
    }

    public BeamPositions getBeamPositions(String id) {
        return beamPositionsRepository.findById(id).get();
    }


    public void addBeamPositions(List<BeamPositions> beamPositionsPayload) {
        beamPositionsRepository.saveAll(beamPositionsPayload);
    }


}
