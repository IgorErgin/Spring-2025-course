package Ergin.demo.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("#{'${EXAMPLE_TEST:default}' != 'default'}")
@Log4j2
public class EnvironmentBean {
    @PostConstruct
    public void init() {
        log.info("EnvironmentBean created");
    }
}
