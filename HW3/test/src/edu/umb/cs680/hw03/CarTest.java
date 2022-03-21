package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    private String[] carToStringArray(Car car) {
        return new String[]{car.getMake(), car.getModel(), Integer.toString(car.getYear())};
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = new String[]{"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 1000, 2018, 1200);
        assertArrayEquals(expected, carToStringArray(actual));
    }

}
