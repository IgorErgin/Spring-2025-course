package Ergin.demo.controller;

import Ergin.demo.model.RequestData;
import Ergin.demo.model.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class JsonController {

    @PostMapping(value = "/process", consumes = "application/json", produces = "application/json")
    public ResponseData processJson(@RequestBody RequestData requestData) {
        log.info("Received request: {}", requestData);

        if (requestData == null || requestData.getPrice() == null) {
            log.error("Invalid request: price is required");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price is required");
        }

        ResponseData response = new ResponseData();
        response.setPrice(requestData.getPrice());

        if (requestData.getInfo() != null && requestData.getInfo().getDate() != null) {
            response.getInfo().setDate(requestData.getInfo().getDate());
        } else {
            log.warn("No valid info or date provided in request");
            // Установка значения по умолчанию или пропуск, в зависимости от требований
            response.getInfo().setDate("N/A"); // Пример: установка значения по умолчанию
        }
        response.getInfo().setId(123);

        log.info("Returning response: {}", response);
        return response;
    }
}