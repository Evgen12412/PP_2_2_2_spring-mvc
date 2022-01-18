package web.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImp implements CarService {
    private List<Car> cars;
    private static int COUNT;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++COUNT, "Gaz", "Volga"));
        cars.add(new Car(++COUNT, "Vaz", "Niva"));
        cars.add(new Car(++COUNT, "Vaz", "2107"));
    }
    @Override
    public List<Car> showAllCarsByCount(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }

    public List<Car> showAllCars() {
        return cars;
    }
}
