package by.epam.thirdtask.state.impl;

import by.epam.thirdtask.entity.Car;
import by.epam.thirdtask.entity.RiverFerry;
import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.state.CarState;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarStateUnloading implements CarState {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void arrive(Car car) {
        LOGGER.log(Level.ERROR, "Unsupported operation (arrive car into river ferry)");
        throw new UnsupportedOperationException("This operation unsupported with current state");
    }

    @Override
    public void load(Car car) {
        LOGGER.log(Level.ERROR, "Unsupported operation (load car into river ferry)");
        throw new UnsupportedOperationException("This operation unsupported with current state");
    }

    @Override
    public void unload(Car car) throws CarException {
        RiverFerry riverFerry = RiverFerry.getInstance();
        riverFerry.transportOfCars();
        LOGGER.log(Level.INFO, "car unload from river ferry", car.getName());
        car.setState(new CarArriveState());
    }
}
