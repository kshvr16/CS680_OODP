package edu.umb.cs680.hw10;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void testGetWithEuclidean() {
        List<Double> p1 = new ArrayList<>();
        Collections.addAll(p1, 2.0, 3.0, 4.0);

        List<Double> p2 = new ArrayList<>();
        Collections.addAll(p2, 5.0, 6.0, 7.0);

        double actual = Distance.get(p1, p2, new Euclidean());
        double expected = Math.sqrt(27.0);

        assertEquals(expected, actual);

    }

    @Test
    public void testGetWithManhattan() {
        List<Double> p1 = new ArrayList<>();
        Collections.addAll(p1, 2.0, 3.0, 4.0);

        List<Double> p2 = new ArrayList<>();
        Collections.addAll(p2, 5.0, 6.0, 7.0);

        double actual = Distance.get(p1, p2, new Manhattan());
        double expected = 9.0;

        assertEquals(expected, actual);

    }

    @Test
    public void testGetWithChebyshev() {
        List<Double> p1 = new ArrayList<>();
        Collections.addAll(p1, 2.0, 3.0, 4.0);

        List<Double> p2 = new ArrayList<>();
        Collections.addAll(p2, 5.0, 7.0, 10.0);

        double actual = Distance.get(p1, p2, new Chebyshev());
        double expected = 6.0;

        assertEquals(expected, actual);

    }

    @Test
    public void testMatrixWithEuclidean() {
        List<List<Double>> points = new ArrayList<>();
        Collections.addAll(points, Arrays.asList(2.0, 3.0, 4.0), Arrays.asList(5.0, 6.0, 7.0),
                Arrays.asList(8.0, 9.0, 10.0), Arrays.asList(11.0, 12.0, 13.0), Arrays.asList(14.0, 15.0, 16.0));

        List<List<Double>> actual = Distance.matrix(points, new Euclidean());
        List<List<Double>> expected = new ArrayList<>();
        Collections.addAll(expected, Arrays.asList(0.0, Math.sqrt(27.0), Math.sqrt(108.0), Math.sqrt(243.0), Math.sqrt(432.0)),
                Arrays.asList(Math.sqrt(27.0), 0.0, Math.sqrt(27.0), Math.sqrt(108.0), Math.sqrt(243.0)),
                Arrays.asList(Math.sqrt(108.0), Math.sqrt(27.0), 0.0, Math.sqrt(27.0), Math.sqrt(108.0)),
                Arrays.asList(Math.sqrt(243.0), Math.sqrt(108.0), Math.sqrt(27.0), 0.0, Math.sqrt(27.0)),
                Arrays.asList(Math.sqrt(432.0), Math.sqrt(243.0), Math.sqrt(108.0), Math.sqrt(27.0), 0.0));

        assertEquals(expected, actual);

    }

    @Test
    public void testMatrixWithManhattan() {
        List<List<Double>> points = new ArrayList<>();
        Collections.addAll(points, Arrays.asList(2.0, 3.0, 4.0), Arrays.asList(5.0, 6.0, 7.0),
                Arrays.asList(8.0, 9.0, 10.0), Arrays.asList(11.0, 12.0, 13.0), Arrays.asList(14.0, 15.0, 16.0));

        List<List<Double>> actual = Distance.matrix(points, new Manhattan());
        List<List<Double>> expected = new ArrayList<>();
        Collections.addAll(expected, Arrays.asList(0.0, 9.0, 18.0, 27.0, 36.0), Arrays.asList(9.0, 0.0, 9.0, 18.0, 27.0),
                Arrays.asList(18.0, 9.0, 0.0, 9.0, 18.0), Arrays.asList(27.0, 18.0, 9.0, 0.0, 9.0),
                Arrays.asList(36.0, 27.0, 18.0, 9.0, 0.0));

        assertEquals(expected, actual);

    }

    @Test
    public void testMatrixWithChebyshev() {
        List<List<Double>> points = new ArrayList<>();
        Collections.addAll(points, Arrays.asList(2.0, 3.0, 4.0), Arrays.asList(5.0, 6.0, 7.0),
                Arrays.asList(8.0, 9.0, 10.0), Arrays.asList(11.0, 12.0, 13.0), Arrays.asList(14.0, 15.0, 16.0));

        List<List<Double>> actual = Distance.matrix(points, new Chebyshev());
        List<List<Double>> expected = new ArrayList<>();
        Collections.addAll(expected, Arrays.asList(0.0, 3.0, 6.0, 9.0, 12.0), Arrays.asList(3.0, 0.0, 3.0, 6.0, 9.0),
                Arrays.asList(6.0, 3.0, 0.0, 3.0, 6.0), Arrays.asList(9.0, 6.0, 3.0, 0.0, 3.0),
                Arrays.asList(12.0, 9.0, 6.0, 3.0, 0.0));

        assertEquals(expected, actual);

    }

}
