package Ergin.demo.controller;

import Ergin.demo.dto.UserDTO;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/public/api")
    public String all() {
        return "public";
    }

    @RolesAllowed("admin")
    @GetMapping("/admin/api")
    public UserDTO admin(@AuthenticationPrincipal UserDetails userDetails) {
        return new UserDTO(userDetails.getUsername(), userDetails.getAuthorities().toString());
    }

    @RolesAllowed("admin")
    @GetMapping("/support/api")
    public UserDTO support(@AuthenticationPrincipal UserDetails userDetails) {
        return new UserDTO(userDetails.getUsername(), userDetails.getAuthorities().toString());
    }
}
