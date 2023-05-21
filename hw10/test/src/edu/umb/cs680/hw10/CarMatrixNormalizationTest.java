package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarMatrixNormalizationTest {

    private static Car[] cars;
    private static List<List<Double>> normalized;

    @BeforeAll
    static void init() {
        List<String> makes = Arrays.asList("Toyota", "Honda", "Ford", "Chevrolet", "BMW");
        List<String> models = Arrays.asList("Camry", "Civic", "Mustang", "Corvette", "X5");
        Random random = new Random();

        cars = new Car[5];
        cars[0] = new Car("Toyota", "Camry", 50000, 2018, 25000f);
        cars[1] = new Car("Honda", "Civic", 35000, 2017, 20000f);
        cars[2] = new Car("Ford", "Mustang", 8000, 2020, 40000f);
        cars[3] = new Car("Chevrolet", "Corvette", 20000, 2019, 60000f);
        cars[4] = new Car("BMW", "X5", 10000, 2021, 80000f);


        normalized = normalizeArray(cars);
    }


    @Test
    void EuclideanMatrixTest() {
        List<List<Double>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0.0, 0.44384171194979954, 1.14564392536481, 0.9555008527953114, 1.5198050044932392));
        expected.add(Arrays.asList(0.44384171194979954, 0.0, 1.0425336559825293, 0.906639670069406, 1.5343755700683832));
        expected.add(Arrays.asList(1.14564392536481, 1.0425336559825293, 0.0, 0.5052165583144261, 0.7135909226546489));
        expected.add(Arrays.asList(0.9555008527953114, 0.906639670069406, 0.5052165583144261, 0.0, 0.6463748450158492));
        expected.add(Arrays.asList(1.5198050044932392, 1.5343755700683832, 0.7135909226546489, 0.6463748450158492, 0.0));
        assertIterableEquals(expected, Distance.matrix(normalized, new Euclidean()));
    }

    @Test
    void ManhattanMatrixTest() {
        List<List<Double>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0.0, 0.6904761929597173, 1.7500000074505806, 1.5476190650037358, 2.6190476165640924));
        expected.add(Arrays.asList(0.6904761929597173, 0.0, 1.7261904861245836, 1.5238095436777388, 2.5952380952380953));
        expected.add(Arrays.asList(1.7500000074505806, 1.7261904861245836, 0.0, 0.8690476289817265, 0.9642857043516069));
        expected.add(Arrays.asList(1.5476190650037358, 1.5238095436777388, 0.8690476289817265, 0.0, 1.0714285515603565));
        expected.add(Arrays.asList(2.6190476165640924, 2.5952380952380953, 0.9642857043516069, 1.0714285515603565, 0.0));

        assertIterableEquals(expected, Distance.matrix(normalized, new Manhattan()));
    }



    private static List<List<Double>> normalizeArray(Car[] cars) {
        List<List<Double>> normalizedArray = new ArrayList<>();

        double minMileage = getMinMileage(cars);
        double maxMileage = getMaxMileage(cars);
        float minPrice = getMinPrice(cars);
        float maxPrice = getMaxPrice(cars);
        int minYear = getMinYear(cars);
        int maxYear = getMaxYear(cars);

        for (Car car : cars) {
            double normalizedMileage = (car.getMileage() - minMileage) / (maxMileage - minMileage);
            double normalizedPrice = (car.getPrice() - minPrice) / (maxPrice - minPrice);
            double normalizedYear = (car.getYear() - minYear) / (double) (maxYear - minYear);

            List<Double> normalizedValues = Arrays.asList(normalizedMileage, normalizedPrice, normalizedYear);
            normalizedArray.add(normalizedValues);
        }

        return normalizedArray;
    }

    private static double getMinMileage(Car[] cars) {
        double minMileage = Double.MAX_VALUE;
        for (Car car : cars) {
            minMileage = Math.min(minMileage, car.getMileage());
        }
        return minMileage;
    }

    private static float getMinPrice(Car[] cars) {
        float minPrice = Float.MAX_VALUE;
        for (Car car : cars) {
            minPrice = Math.min(minPrice, car.getPrice());
        }
        return minPrice;
    }

    private static double getMaxMileage(Car[] cars) {
        double maxMileage = Double.MIN_VALUE;
        for (Car car : cars) {
            maxMileage = Math.max(maxMileage, car.getMileage());
        }
        return maxMileage;
    }

    private static float getMaxPrice(Car[] cars) {
        float maxPrice = Float.MIN_VALUE;
        for (Car car : cars) {
            maxPrice = Math.max(maxPrice, car.getPrice());
        }
        return maxPrice;
    }

    private static int getMinYear(Car[] cars) {
        int minYear = Integer.MAX_VALUE;
        for (Car car : cars) {
            minYear = Math.min(minYear, car.getYear());
        }
        return minYear;
    }

    private static int getMaxYear(Car[] cars) {
        int maxYear = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxYear = Math.max(maxYear, car.getYear());
        }
        return maxYear;
    }


}
