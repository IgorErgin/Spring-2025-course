package Ergin.demo.validation.constrains;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;
@Min(value = 1886, message = "Year should be from 1886 to 2025")
@Max(value = 2025, message = "Year should be from 1886 to 2025")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Year {
    String message() default "Year should be from 1886 to 2025";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
