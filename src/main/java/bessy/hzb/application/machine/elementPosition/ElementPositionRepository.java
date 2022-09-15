package bessy.hzb.application.machine.elementPosition;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementPositionRepository extends JpaRepository<ElementPosition, Long> {
}
