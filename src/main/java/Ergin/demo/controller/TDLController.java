package Ergin.demo.controller;


import Ergin.demo.model.TDL;
import Ergin.demo.service.TDLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TDLController {

    private final TDLService TDLService;

    @PostMapping("/createTDL")
    public ResponseEntity<TDL> createTDL(@RequestBody TDL TDL) {
        return ResponseEntity.ok(TDLService.createTDL(TDL));
    }

    @GetMapping("/TDLs")
    public ResponseEntity<List<TDL>> getAllLists() {
        return ResponseEntity.ok(TDLService.getAllList());
    }

    @GetMapping("/TDL/{name}")
    public ResponseEntity<TDL> getList(@PathVariable String name) {
        return ResponseEntity.ok(TDLService.getTDL(name));
    }
}
