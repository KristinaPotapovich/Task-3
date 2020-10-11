package by.epam.thirdtask.main;

import by.epam.thirdtask.entity.Car;
import by.epam.thirdtask.entity.impl.FreightCar;
import by.epam.thirdtask.entity.impl.PassengerCar;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Car freightCar = new FreightCar();
            Car passengerCar = new PassengerCar();
            freightCar.start();
            passengerCar.start();
        }
    }
}




