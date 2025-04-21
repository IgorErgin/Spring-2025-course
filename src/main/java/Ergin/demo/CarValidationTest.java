package Ergin.demo;

import Ergin.demo.model.Car;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class CarValidationTest {
    public static void main(String[] args) {
        // Создаем Validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Создаем объект Car с потенциально некорректными данными
        Car car = new Car(
                1L,              // id
                "InvalidMark",   // Mark (может нарушать @CarNameConstraint)
                1800,            // year (может нарушать @Year)
                "Pink",          // color (может нарушать @CarColorConstraint)
                -1               // number (может нарушать @CarOwnerNumber)
        );

        // Проверяем валидацию
        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        // Выводим ошибки валидации
        if (violations.isEmpty()) {
            System.out.println("Объект валиден!");
        } else {
            System.out.println("Найдены ошибки валидации:");
            for (ConstraintViolation<Car> violation : violations) {
                System.out.println("Поле: " + violation.getPropertyPath() +
                        ", Ошибка: " + violation.getMessage() +
                        ", Значение: " + violation.getInvalidValue());
            }
        }
    }
}