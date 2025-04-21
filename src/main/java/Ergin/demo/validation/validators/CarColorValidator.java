package Ergin.demo.validation.validators;

import Ergin.demo.validation.constrains.CarColorConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CarColorValidator  implements ConstraintValidator<CarColorConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] colors = {"black", "white", "red"};
        return Arrays.asList(colors).contains(value);
    }

}
