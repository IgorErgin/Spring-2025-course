package Ergin.demo.validation.constrains;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Min(value = 0, message = "{validation.errors.car_owner_number}")
@Max(value = 5, message = "{validation.errors.car_owner_number}")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CarOwnerNumber {
    String message() default "{validation.errors.car_owner_number}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
