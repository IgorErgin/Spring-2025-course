package Ergin.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Scope("prototype")
public class EmailService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @PostConstruct
    public void init() {
        logger.info("EmailService bean created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("EmailService bean destroyed");
    }

    @Override
    public String getMessage() {
        return "Email message";
    }
}