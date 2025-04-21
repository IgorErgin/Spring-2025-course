package Ergin.demo.validation.validators;

import Ergin.demo.validation.constrains.CarNameConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CarNameValidator  implements ConstraintValidator<CarNameConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        var regexRu = "^[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+$";
        var regexEn = "^[A-Z][a-z]+\\s[A-Z][a-z]+$";
        return value.matches(regexEn) || value.matches(regexRu);
    }
}
