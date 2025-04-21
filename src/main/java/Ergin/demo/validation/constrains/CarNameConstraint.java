package Ergin.demo.validation.constrains;

import Ergin.demo.validation.validators.CarNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarNameValidator.class)
@Documented
public @interface CarNameConstraint {
    String message() default "{validation.errors.car_name}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
