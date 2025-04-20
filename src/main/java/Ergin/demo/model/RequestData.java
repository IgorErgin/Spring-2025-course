package Ergin.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestData {
    private Double price;
    private Info info;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Info {
        private String date;

        public String getDate() { // Добавлен геттер
            return date;
        }
    }
}