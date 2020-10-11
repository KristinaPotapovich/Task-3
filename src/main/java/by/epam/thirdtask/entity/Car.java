package by.epam.thirdtask.entity;

import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.state.CarState;
import by.epam.thirdtask.state.impl.CarArriveState;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Car extends Thread {
    protected int weight;
    protected int square;
    private CarState state = new CarArriveState();
    public static final Logger LOGGER = LogManager.getLogger();
    private static final String MESSAGE_FOR_CAR_EXCEPTION = "Car not found";

    @Override
    public void run() {
        state.arrive(this);
        try {
            state.load(this);
            state.unload(this);
        } catch (CarException e) {
            LOGGER.log(Level.ERROR, MESSAGE_FOR_CAR_EXCEPTION, e);
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public CarState getCurrentState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getWeight() != car.getWeight()) return false;
        return getSquare() == car.getSquare();
    }

    @Override
    public int hashCode() {
        int result = getWeight();
        result = 31 * result + getSquare();
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.append("Car{").append("weight=").append(weight).append(", square=")
                .append(square).append('}').toString();
    }
}
