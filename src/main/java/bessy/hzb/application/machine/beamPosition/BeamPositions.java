package bessy.hzb.application.machine.beamPosition;

import bessy.hzb.application.machine.elementPosition.ElementPosition;

import javax.persistence.*;
import java.util.*;

@Entity
public class BeamPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long BeamPositionId;

    @OneToMany
    private List<ElementPosition> elementPositions = new ArrayList<>();

    public Long getId() {
        return BeamPositionId;
    }
    public void setId(Long id){
        this.BeamPositionId = id;
    }

    public List<ElementPosition> getElementPositions() {
        return elementPositions;
    }
    public BeamPositions() {
    }


    public void setElementPositions(List<ElementPosition> beamPositions) {
        this.elementPositions = beamPositions;
    }


}
