package Ergin.demo.broker_consumer.service;


import Ergin.demo.broker_consumer.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecipService {

    @KafkaListener(topics = "${spring.kafka.topic}")

    public void receive(MessageDTO message) {
        log.info("Сообщение '{}' от {}", message.getText(), message.getFrom());
    }
}
