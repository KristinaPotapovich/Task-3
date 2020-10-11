package by.epam.thirdtask.entity;


import by.epam.thirdtask.exception.CarException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RiverFerry {
    private static final int MAX_SQUARE_OF_RIVER_FERRY = 60;
    private static final int MAX_WEIGHT_OF_RIVER_FERRY = 12000;
    private static final int MIN_WEIGHT_CARS = 0;
    private static final int MIN_SQUARE_CARS = 0;
    private static final int TIME_FOR_TRANSPORTATION_CARS = 10;
    public static final Logger LOGGER = LogManager.getLogger();
    private static RiverFerry instance;
    private static final AtomicBoolean INSTANCE_WAS_CREATED = new AtomicBoolean();
    private static final Lock lock = new ReentrantLock();

    private AtomicInteger currentWeightCars = new AtomicInteger(MIN_WEIGHT_CARS);
    private AtomicInteger busySquareRiverFerry = new AtomicInteger(MIN_SQUARE_CARS);

    private RiverFerry() {
    }

    public static RiverFerry getInstance() {
        if (!INSTANCE_WAS_CREATED.get()) {
            lock.lock();
            if (instance == null) {
                instance = new RiverFerry();
                INSTANCE_WAS_CREATED.set(true);
            }
            lock.unlock();
        }
        return instance;
    }

    public int getCurrentWeightCars() {
        return currentWeightCars.intValue();
    }

    public void setCurrentWeightCars(int currentWeightCars) {
        this.currentWeightCars = new AtomicInteger(currentWeightCars);
    }

    public int getBusySquareRiverFerry() {
        return busySquareRiverFerry.intValue();
    }

    public void setBusySquareRiverFerry(int busySquareRiverFerry) {
        this.busySquareRiverFerry = new AtomicInteger(busySquareRiverFerry);
    }

    public void loadCar(Car car) throws CarException {
        lock.lock();
        if (isFreePlaceForCar(car)) {
            busySquareRiverFerry.addAndGet(car.getSquare());
            currentWeightCars.addAndGet(car.getWeight());
            LOGGER.log(Level.INFO, car.getClass().getSimpleName()
                    + " was loaded on the river ferry. " +
                    "Square: " + busySquareRiverFerry.intValue() + "/" + MAX_SQUARE_OF_RIVER_FERRY
                    + " Weight: " + currentWeightCars.intValue() + "/" + MAX_WEIGHT_OF_RIVER_FERRY);
        } else {
            LOGGER.log(Level.INFO, " River ferry is full and move to the unloading." +
                    " Possible overload: " +
                    "Square: " + (car.getSquare() + getBusySquareRiverFerry()) + "/" + MAX_SQUARE_OF_RIVER_FERRY +
                    " Weight: " + (car.getWeight() + getCurrentWeightCars()) + "/" + MAX_WEIGHT_OF_RIVER_FERRY);
            transportOfCars();
            LOGGER.log(Level.INFO, "River ferry returns from unloading and starts to load cars");
            loadCar(car);
        }
        lock.unlock();
    }

    public void transportOfCars() throws CarException {
        try {
            TimeUnit.SECONDS.sleep(TIME_FOR_TRANSPORTATION_CARS);
            setCurrentWeightCars(MIN_WEIGHT_CARS);
            setBusySquareRiverFerry(MIN_SQUARE_CARS);
            TimeUnit.SECONDS.sleep(TIME_FOR_TRANSPORTATION_CARS);
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "Trying to call a method when the thread is sleeping", e);
            throw new CarException("Trying to call a method when the thread is sleeping", e);
        }
    }

    private Boolean isFreePlaceForCar(Car car) {
        return car.getSquare() + getBusySquareRiverFerry() <= MAX_SQUARE_OF_RIVER_FERRY &&
                car.getWeight() + getCurrentWeightCars() <= MAX_WEIGHT_OF_RIVER_FERRY;
    }
}
