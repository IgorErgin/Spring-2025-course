package Ergin.demo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Endpoint(id = "logtime")
public class TimeLogEndpoint {

    @ReadOperation
    public ResponseEntity<Void> logTime() {
        String message = "Вызов актуатора: " + LocalDateTime.now();
        System.out.println(message);
        return ResponseEntity.ok().build();
    }
}

