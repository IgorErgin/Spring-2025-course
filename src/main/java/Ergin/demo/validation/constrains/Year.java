package Ergin.demo.validation.constrains;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;
@Min(value = 1886, message = "{validation.errors.car_year}")
@Max(value = 2025, message = "{validation.errors.car_year}")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Year {
    String message() default "{validation.errors.car_year}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
