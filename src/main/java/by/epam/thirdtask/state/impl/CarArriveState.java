package by.epam.thirdtask.state.impl;

import by.epam.thirdtask.entity.Car;
import by.epam.thirdtask.state.CarState;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarArriveState implements CarState {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void arrive(Car car) {
        LOGGER.log(Level.INFO, "Car arrive", car.getName());
        car.setState(new CarLoadingState());
    }

    @Override
    public void load(Car car) {
        LOGGER.log(Level.ERROR, "Unsupported operation (load car into river ferry)");
        throw new UnsupportedOperationException("This operation unsupported with current state");
    }

    @Override
    public void unload(Car car) {
        LOGGER.log(Level.ERROR, "Unsupported operation (unload cars from the river ferry)");
        throw new UnsupportedOperationException("This operation unsupported with current state");
    }
}
