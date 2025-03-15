package Ergin.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MessageProcessor processor = context.getBean(MessageProcessor.class);
        processor.processMessages();

        // Явное закрытие контекста для демонстрации @PreDestroy
        context.close();
    }
}
