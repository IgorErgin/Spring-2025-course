package Ergin.demo;


import Ergin.demo.service.MessageProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		MessageProcessor processor = context.getBean(MessageProcessor.class);
		processor.processMessages();
		context.close();
	}
}