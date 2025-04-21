package Ergin.demo.service;

import Ergin.demo.model.Event;
import Ergin.demo.model.TDL;
import Ergin.demo.repositories.TDLRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TDLService {
    private final TDLRepo TDLRepo;


    public TDL createTDL(TDL TDL) {

        for (Event event : TDL.getEvents()) {
            event.setTDL(TDL);
        }

        TDLRepo.save(TDL);
        return TDL;
    }

    public TDL getTDL(String name) {
        return TDLRepo.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("List does not exist"));
    }

    public List<TDL> getAllList() {
        return TDLRepo.findAll();
    }
}
