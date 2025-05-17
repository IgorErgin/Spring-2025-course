package Ergin.demo.actuator;

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

