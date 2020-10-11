package by.epam.thirdtask.parser.impl;

import by.epam.thirdtask.parser.DataParserForCar;

import java.util.List;

public class DataParserPassengerCar implements DataParserForCar {

    private static final int INDEX_PASSENGER_CAR_SQUARE = 2;
    private static final int INDEX_PASSENGER_CAR_WEIGHT = 3;

    @Override
    public int parseDataForCarSquare(List<Integer> dataForInit) {
        return dataForInit.get(INDEX_PASSENGER_CAR_SQUARE);
    }

    @Override
    public int parseDataForCarWeight(List<Integer> dataForInit) {
        return dataForInit.get(INDEX_PASSENGER_CAR_WEIGHT);
    }
}
