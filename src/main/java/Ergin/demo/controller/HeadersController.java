package Ergin.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HeadersController {

    @GetMapping("/headers")
    public String getHeaders(HttpServletRequest request, Model model) {
        Map<String, String> headers = new HashMap<>();
        Collections.list(request.getHeaderNames())
                .forEach(name -> headers.put(name, request.getHeader(name)));
        model.addAttribute("headers", headers);
        return "headers";
    }
}