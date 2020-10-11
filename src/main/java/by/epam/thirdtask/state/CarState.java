package by.epam.thirdtask.state;

import by.epam.thirdtask.entity.Car;
import by.epam.thirdtask.exception.CarException;

public interface CarState {
    public void arrive(Car car);

    public void load(Car car) throws CarException;

    public void unload(Car car) throws CarException;
}
