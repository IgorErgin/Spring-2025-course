package Ergin.demo.model;

import lombok.Data;

@Data
public class ResponseData {
    private Double price;
    private Info info = new Info();

    @Data
    public static class Info {
        private Integer id;
        private String date;
    }

    public void setPrice(Double price) { // Исправленный сеттер
        this.price = price;
    }
}