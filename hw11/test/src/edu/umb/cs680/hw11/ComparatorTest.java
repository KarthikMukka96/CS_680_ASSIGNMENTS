package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparatorTest {

    static Car cars[];
    static Car car1, car2, car3 ,car4;

    @BeforeAll
    public static void init() {
        car1 = new Car("BMW", "Series X", 90000, 2010, 23450);
        car2 = new Car("Jaguar", "M2", 120000, 2016, 19000);
        car3 = new Car("Tesla", "Model X", 45000, 2019, 20000);
        car4 = new Car("Ferrari", "GTX 4", 20000, 2020, 33450);
        cars = new Car[]{car1, car2, car3, car4};
        for (int i = 0; i < cars.length; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[i].isDominatedBy(cars[j])) {
                    cars[i].setDominationCount(cars[i].getDominationCount() + 1);
                } else {
                    cars[j].setDominationCount(cars[j].getDominationCount() + 1);
                }
            }
        }
    }

    @Test
    public void testPriceComparatorForCarArray() {

        Arrays.sort(cars, new PriceComparator());

        Car[] expected = {car2, car3, car1, car4};

        assertArrayEquals(expected, cars);
    }

    @Test
    public void testYearComparatorForCarArray() {

        Arrays.sort(cars, new YearComparator());

        Car[] expected = {car4, car3, car2, car1};
        assertArrayEquals(expected, cars);
    }

    @Test
    public void testMileageComparatorForCarArray() {
        Arrays.sort(cars, new MileageComparator());

        Car[] expected = {car4, car3, car1, car2};
        assertArrayEquals(expected, cars);
    }

    @Test
    public void testParetoComparatorForCarArray() {
        Car[] cars = {car1, car2, car3, car4};

        Arrays.sort(cars, new ParetoComparator());

        Car[] expected = {car1, car2, car3, car4};

        assertArrayEquals(expected, cars);
    }
}
