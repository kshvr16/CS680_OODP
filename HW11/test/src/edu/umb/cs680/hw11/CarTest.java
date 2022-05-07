package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

public class CarTest {

    @Test
    public void priceComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X3", 1000, 2021, 25000));
        cars.add(new Car("Audi", "A8", 4000, 2018, 20000));
        cars.add(new Car("Volvo", "XC60", 2000, 2021, 30000));
        cars.add(new Car("Tesla", "Y", 500, 2022, 50000));

        for(Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new PriceComparator());

        assertEquals(20000, cars.get(0).getPrice());
        assertEquals(25000, cars.get(1).getPrice());
        assertEquals(30000, cars.get(2).getPrice());
        assertEquals(50000, cars.get(3).getPrice());
    }

    @Test
    public void mileageComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X3", 1000, 2021, 25000));
        cars.add(new Car("Audi", "A8", 4000, 2018, 20000));
        cars.add(new Car("Volvo", "XC60", 2000, 2021, 30000));
        cars.add(new Car("Tesla", "Y", 500, 2022, 50000));

        for(Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new MileageComparator());

        assertEquals(500, cars.get(0).getMileage());
        assertEquals(1000, cars.get(1).getMileage());
        assertEquals(2000, cars.get(2).getMileage());
        assertEquals(4000, cars.get(3).getMileage());
    }

    @Test
    public void yearComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X3", 1000, 2021, 25000));
        cars.add(new Car("Audi", "A8", 4000, 2018, 20000));
        cars.add(new Car("Volvo", "XC60", 2000, 2021, 30000));
        cars.add(new Car("Tesla", "Y", 500, 2022, 50000));

        for(Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new YearComparator());

        assertEquals(2018, cars.get(0).getYear());
        assertEquals(2021, cars.get(1).getYear());
        assertEquals(2021, cars.get(2).getYear());
        assertEquals(2022, cars.get(3).getYear());
    }

    @Test
    public void paretoComparatorTest() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X3", 1000, 2021, 25000));
        cars.add(new Car("Audi", "A8", 4000, 2018, 20000));
        cars.add(new Car("Volvo", "XC60", 2000, 2021, 30000));
        cars.add(new Car("Tesla", "Y", 500, 2022, 50000));

        for(Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());

        assertEquals(25000, cars.get(0).getPrice());
        assertEquals(4000, cars.get(1).getMileage());
        assertEquals(2021, cars.get(2).getYear());
        assertEquals("XC60", cars.get(2).getMake());
        assertEquals("Tesla", cars.get(3).getModel());
    }
}
