package by.epam.thirdtask.entity.impl;

import by.epam.thirdtask.entity.Car;
import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.parser.DataParser;
import by.epam.thirdtask.parser.impl.DataParserPassengerCar;
import by.epam.thirdtask.reader.DataReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PassengerCar extends Car {
    public static final Logger LOGGER = LogManager.getLogger();

    public PassengerCar() {
        DataParserPassengerCar dataParserPassengerCar = new DataParserPassengerCar();
        DataReader dataReader = new DataReader();
        String filePath = "init/data.txt";
        List<Integer> dataForInit;
        try {
            dataForInit = DataParser.parseToInteger(dataReader.readData(filePath));
            square = dataParserPassengerCar.parseDataForCarSquare(dataForInit);
            weight = dataParserPassengerCar.parseDataForCarWeight(dataForInit);
        } catch (CarException e) {
            LOGGER.log(Level.ERROR, "file is missing", e);
        }
    }
}