package Ergin.demo.model;

import Ergin.demo.validation.constrains.CarColorConstraint;
import Ergin.demo.validation.constrains.CarNameConstraint;
import Ergin.demo.validation.constrains.CarOwnerNumber;
import Ergin.demo.validation.constrains.Year;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Car {
    private final long id;

    @CarNameConstraint
    private final String mark;

    @Year
    private final int year;

    @CarColorConstraint
    private final String color;

    @CarOwnerNumber
    private final int number;

}
