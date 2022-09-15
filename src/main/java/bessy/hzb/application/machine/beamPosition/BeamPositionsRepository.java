package bessy.hzb.application.machine.beamPosition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeamPositionsRepository extends JpaRepository<BeamPositions, String> {
}
