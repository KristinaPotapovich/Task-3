package by.epam.thirdtask.entity.impl;

import by.epam.thirdtask.entity.Car;
import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.parser.DataParser;
import by.epam.thirdtask.parser.impl.DataParserFreightCar;
import by.epam.thirdtask.reader.DataReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FreightCar extends Car {
    public static final Logger LOGGER = LogManager.getLogger();

    public FreightCar() {
        DataParserFreightCar dataParserFreightCar = new DataParserFreightCar();
        DataReader dataReader = new DataReader();
        String filePath = "init/data.txt";
        List<Integer> dataForInit;
        try {
            dataForInit = DataParser.parseToInteger(dataReader.readData(filePath));
            square = dataParserFreightCar.parseDataForCarSquare(dataForInit);
            weight = dataParserFreightCar.parseDataForCarWeight(dataForInit);
        } catch (CarException e) {
            LOGGER.log(Level.ERROR, "file is missing", e);
        }
    }
}



