package edu.umb.cs680.hw10;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    public void testDistanceValueForPointsWithDifferentDimensions() {
        List<Double> point1 = List.of(2d, 3d);
        List<Double> point2 = List.of(5d);

        assertEquals(-1, Distance.get(point1, point2));
    }

    @Test
    public void testEuclideanDistanceValueBetweenPoints() {
        List<Double> point1 = List.of(2d, 3d);
        List<Double> point2 = List.of(5d, 7d);

        assertEquals(5d, Distance.get(point1, point2, new Euclidean()));
    }

    @Test
    public void testManhattanDistanceValueBetweenPoints() {
        List<Double> point1 = List.of(2d, 3d);
        List<Double> point2 = List.of(5d, 7d);

        assertEquals(7d, Distance.get(point1, point2, new Manhattan()));
    }

    @Test
    public void testEuclideanDistanceMatrixForPoints() {
        List<Double> point1 = List.of(2d, 3d);
        List<Double> point2 = List.of(5d, 7d);
        List<List<Double>> points = List.of(point1, point2);

        List<List<Double>> expected = List.of(
                List.of(0d, 5d),
                List.of(5d, 0d)
        );

        assertArrayEquals(expected.toArray(), Distance.matrix(points, new Euclidean()).toArray());
    }

    @Test
    public void testManhattanDistanceMatrixForPoints() {
        List<Double> point1 = List.of(2d, 3d);
        List<Double> point2 = List.of(5d, 7d);
        List<List<Double>> points = List.of(point1, point2);

        List<List<Double>> expected = List.of(
                List.of(0d, 7d),
                List.of(7d, 0d)
        );

        assertArrayEquals(expected.toArray(), Distance.matrix(points, new Manhattan()).toArray());
    }

    @Test
    public void testManhattanDistanceMatrixForFiveThreeDimensionalPoints() {
        List<Double> point1 = List.of(2d, 3d, 5d);
        List<Double> point2 = List.of(4d, 9d, 10d);
        List<Double> point3 = List.of(0d, 2d, 4d);
        List<Double> point4 = List.of(9d, 9d, 9d);
        List<Double> point5 = List.of(3d, 9d, 5d);
        List<List<Double>> points = List.of(point1, point2, point3, point4, point5);

        List<List<Double>> expected = List.of(
                List.of(0d, 13d, 4d, 17d, 7d),
                List.of(13d, 0d, 17d, 6d, 6d),
                List.of(4d, 17d, 0d, 21d, 11d),
                List.of(17d, 6d, 21d, 0d, 10d),
                List.of(7d, 6d, 11d, 10d, 0d)
        );

        assertArrayEquals(expected.toArray(), Distance.matrix(points, new Manhattan()).toArray());
    }

    @Test
    public void testEuclideanDistanceMatrixForFiveThreeDimensionalPoints() {
        List<Double> point1 = List.of(2d, 3d, 5d);
        List<Double> point2 = List.of(4d, 9d, 10d);
        List<Double> point3 = List.of(0d, 2d, 4d);
        List<Double> point4 = List.of(9d, 9d, 9d);
        List<Double> point5 = List.of(3d, 9d, 5d);
        List<List<Double>> points = List.of(point1, point2, point3, point4, point5);

        List<List<Double>> expected = List.of(
                List.of(0d, 8.06225774829855d, 2.449489742783178d, 10.04987562112089d, 6.082762530298219d),
                List.of(8.06225774829855d, 0d, 10.04987562112089d, 5.0990195135927845d, 5.0990195135927845d),
                List.of(2.449489742783178d, 10.04987562112089d, 0d, 12.449899597988733d, 7.681145747868608d),
                List.of(10.04987562112089d, 5.0990195135927845d, 12.449899597988733d, 0d, 7.211102550927978d),
                List.of(6.082762530298219d, 5.0990195135927845d, 7.681145747868608d, 7.211102550927978d, 0d)
        );

        assertArrayEquals(expected.toArray(), Distance.matrix(points, new Euclidean()).toArray());
    }
}
