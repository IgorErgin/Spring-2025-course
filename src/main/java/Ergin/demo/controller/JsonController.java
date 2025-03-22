package Ergin.demo.controller;

import Ergin.demo.model.RequestData;
import Ergin.demo.model.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @PostMapping(value = "/process", consumes = "application/json", produces = "application/json")
    public ResponseData processJson(@RequestBody RequestData requestData) {
        ResponseData response = new ResponseData();
        response.setPrice(requestData.getPrice());

        if (requestData.getInfo() != null) {
            response.getInfo().setDate(requestData.getInfo().getDate());
        }
        response.getInfo().setId(123);
        return response;
    }
}