package Ergin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MessageProcessor {
    private static final Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

    // 1. DI через конструктор
    private final MessageService constructorInjectedService;

    // 2. DI через поле
    @Autowired
    @Qualifier("emailService")
    private MessageService fieldInjectedService;

    // 3. DI через сеттер
    private MessageService setterInjectedService;

    @Autowired
    public MessageProcessor(@Qualifier("smsService") MessageService constructorInjectedService) {
        this.constructorInjectedService = constructorInjectedService;
    }

    @Autowired
    public void setSetterInjectedService(@Qualifier("smsService") MessageService setterInjectedService) {
        this.setterInjectedService = setterInjectedService;
    }

    public void processMessages() {
        logger.info("Constructor injected: " + constructorInjectedService.getMessage());
        logger.info("Field injected: " + fieldInjectedService.getMessage());
        logger.info("Setter injected: " + setterInjectedService.getMessage());
    }
}
