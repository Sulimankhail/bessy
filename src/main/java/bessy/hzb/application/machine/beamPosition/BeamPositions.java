package bessy.hzb.application.machine.beamPosition;

import bessy.hzb.application.machine.elementPosition.ElementPosition;

import javax.persistence.*;
import java.util.*;

@Entity
public class BeamPositions {
    @Id
    @Column(name = "id")
    private String BeamPositionId;

    @OneToMany
    private List<ElementPosition> elementPositions = new ArrayList<>();

    public String getId() {
        if(BeamPositionId == null){
            BeamPositionId=UUID.randomUUID().toString();
        }
        return BeamPositionId;
    }
    public void setId(String id){
        this.BeamPositionId = id;
    }

    public List<ElementPosition> getElementPositions() {
        return elementPositions;
    }
    public BeamPositions() {
        getId();
    }


    public void setElementPositions(List<ElementPosition> beamPositions) {
        this.elementPositions = beamPositions;
    }


}
