package Ergin.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private Double price;
    private Info info = new Info();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Info {
        private Integer id;
        private String date;
    }
}