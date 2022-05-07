package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarTest {

    @Test
    public void priceAscendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carTwo, carOne, carFour, carThree);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getPrice));

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void priceDescendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carThree, carFour, carOne, carTwo);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getPrice).reversed());

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void mileageAscendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carThree, carOne, carFour, carTwo);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getMileage));

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void mileageDescendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carTwo, carFour, carOne, carThree);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getMileage).reversed());

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void yearAscendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carTwo, carOne, carFour, carThree);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getYear));

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void yearDescendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carThree, carOne, carFour, carTwo);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getYear).reversed());

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void paretoAscendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carTwo, carOne, carFour, carThree);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getPrice));

        assertEquals(expectedCarsList, actualCarsList);

    }

    @Test
    public void paretoDescendingOrderSortTest() {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);

        ArrayList<Car> actualCarsList = new ArrayList<>();
        Collections.addAll(actualCarsList, carOne, carTwo, carThree, carFour);
        for(Car car : actualCarsList) {
            car.setDominationCount(actualCarsList);
        }

        ArrayList<Car> expectedCarsList = new ArrayList<>();
        Collections.addAll(expectedCarsList, carThree, carFour, carOne, carTwo);
        for(Car car : expectedCarsList) {
            car.setDominationCount(actualCarsList);
        }

        Collections.sort(actualCarsList, Comparator.comparing(Car::getPrice).reversed());

        assertEquals(expectedCarsList, actualCarsList);

    }

}
