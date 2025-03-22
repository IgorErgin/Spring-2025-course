package Ergin.demo;

import Ergin.demo.controller.HeadersController;
import Ergin.demo.controller.JsonController;
import Ergin.demo.model.RequestData;
import Ergin.demo.model.ResponseData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.ui.ConcurrentModel;

@SpringBootApplication
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainTest.class, args);
        testHeadersController(context);
        testJsonController(context);
    }

    private static void testHeadersController(ApplicationContext context) {
        HeadersController headersController = context.getBean(HeadersController.class);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("User-Agent", "Test-Agent");
        request.addHeader("Accept", "text/html");
        Model model = new ConcurrentModel();

        String viewName = headersController.getHeaders(request, model);
        System.out.println("HeadersController result: View = " + viewName);
        System.out.println("Headers in model: " + model.asMap().get("headers"));
    }

    private static void testJsonController(ApplicationContext context) {
        JsonController jsonController = context.getBean(JsonController.class);

        RequestData requestData = new RequestData();
        requestData.setPrice(99.99);
        RequestData.Info info = new RequestData.Info();
        info.setDate("2025-03-22"); // Теперь сеттер доступен
        requestData.setInfo(info);

        ResponseData response = jsonController.processJson(requestData);
        System.out.println("JsonController result: Price = " + response.getPrice() +
                ", Info = {id=" + response.getInfo().getId() + ", date=" + response.getInfo().getDate() + "}");
    }
}