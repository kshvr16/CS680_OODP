package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    public int compare(Car car1, Car car2) {
        if((car1.getPrice() <= car2.getPrice() && car1.getYear() >= car2.getYear() && car1.getMileage() <= car2.getMileage())
                && (car1.getPrice() < car2.getPrice() || car1.getYear() > car2.getYear() || car1.getMileage() < car2.getMileage())) {
            return -1;
        }
        return 0;
    }

}
