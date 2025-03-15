package Ergin.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		try {
			logger.info("Starting application...");
			AnnotationConfigApplicationContext context =
					new AnnotationConfigApplicationContext(AppConfig.class);
			logger.info("Context created successfully");
			MessageProcessor processor = context.getBean(MessageProcessor.class);
			logger.info("MessageProcessor bean retrieved");
			processor.processMessages();
			logger.info("Messages processed");
			context.close();
			logger.info("Context closed");
		} catch (Exception e) {
			logger.error("Application failed", e);
			throw e;
		}
	}
}