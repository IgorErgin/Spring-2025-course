package Ergin.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("smsService")
@Scope("prototype")
public class SMSService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(SMSService.class);

    @PostConstruct
    public void init() {
        logger.info("SMSService bean created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("SMSService bean destroyed");
    }

    @Override
    public String getMessage() {
        return "SMS message";
    }
}
