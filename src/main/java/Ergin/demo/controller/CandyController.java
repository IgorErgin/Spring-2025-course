package Ergin.demo.controller;

import Ergin.demo.service.CandyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CandyController {
    private CandyService service;

    @PostMapping("/api/orders/{itemId}")
    public ResponseEntity<String> createOrder(@PathVariable String itemId) {
        String result = service.createOrder(itemId);
        return ResponseEntity.ok(result);
    }
}
