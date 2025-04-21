package Ergin.demo.validation.constrains;


import Ergin.demo.validation.validators.CarColorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarColorValidator.class)
@Documented
public @interface CarColorConstraint {
    String message() default "Car color should be \"black, \"white\" or red";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
