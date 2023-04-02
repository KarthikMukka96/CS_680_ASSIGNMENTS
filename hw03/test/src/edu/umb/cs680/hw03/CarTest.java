package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private List<String> carToStringArray(Car car) {

        List<String> carStringList = List.of(car.getMake(), car.getModel(), Integer.toString(car.getYear()));
        return carStringList;
    }

    @Test
    public void checkingForEqualityUsingCarToStringMethod() {
        Car dodge = new Car("Dodge", "model", 2010, 20000, 70000f);
        List<String> expected = List.of("Dodge", "model", "2010");
        assertIterableEquals(expected,carToStringArray(dodge));
    }

    @Test
    public void isTheValueOfMileageEqual() {
        Car dodge = new Car("Dodge", "model", 2010, 20000, 70000f);
        assertEquals(20000, dodge.getMileage());
    }

    @Test
    public void isTheValueOfPriceEqual() {
        Car dodge = new Car("Dodge", "model", 2010, 20000, 70000f);
        assertEquals(70000f, dodge.getPrice());
    }

}