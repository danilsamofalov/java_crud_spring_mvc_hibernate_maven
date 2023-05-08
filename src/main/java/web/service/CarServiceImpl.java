package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private final static List<Car> cars = new ArrayList<>();

    static  {
        cars.add(new Car(1,"BMW", 6));
        cars.add(new Car(2,"Audi", 3));
        cars.add(new Car(3,"Volvo", 5));
        cars.add(new Car(4,"Opel", 8));
        cars.add(new Car(5,"Nissan", 2));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return cars;
        }

        return cars.stream().limit(count).collect(Collectors.toList());
    }

}
