package bessy.hzb.application.machine.elementPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ElementPositionService {
    @Autowired
    ElementPositionRepository elementPositionRepository;
    public List<ElementPosition> getAllElementPosition(){
        List<ElementPosition> elementPosition = new ArrayList<>();
        elementPositionRepository.findAll()
                .forEach( elementPosition::add);
        return elementPosition;
    }

    public ElementPosition getElementPosition(Long id) {
        return elementPositionRepository.findById(id).get();
    }


    public void addElementPosition(ElementPosition elementPositionPayload) {
        elementPositionRepository.save(elementPositionPayload);
    }
    public void addElementPositionSet(List<ElementPosition> elementPositionPayload) {
        elementPositionRepository.saveAll(elementPositionPayload);
//        elementPositionPayload.forEach((ElementPosition e) -> {
//            elementPositionRepository.save(e);
//        });
    }
}
