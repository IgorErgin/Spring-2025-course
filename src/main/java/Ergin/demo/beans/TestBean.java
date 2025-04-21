package Ergin.demo.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
@Log4j2
public class TestBean {

    @PostConstruct
    public void init(){
        log.info("TestBean created");
    }

}
