package Ergin.demo.broker_producer.controller;


import Ergin.demo.broker_producer.dto.MessageDTO;
import Ergin.demo.broker_producer.service.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageController {

    final MessageService messageService;

    @PostMapping("/publish")
    public String publish(@RequestBody MessageDTO message){
        messageService.publish(message);
        return "Message published";
    }
}