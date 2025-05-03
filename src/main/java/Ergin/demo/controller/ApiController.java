package Ergin.demo.controller;

import Ergin.demo.limiter.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ApiController {
    @RateLimit
    @GetMapping("/run")
    public String run() {
        return "Hello!";
    }

}
