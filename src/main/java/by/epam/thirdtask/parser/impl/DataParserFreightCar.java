package by.epam.thirdtask.parser.impl;

import by.epam.thirdtask.parser.DataParserForCar;

import java.util.List;

public class DataParserFreightCar implements DataParserForCar {

    private static final int INDEX_FREIGHT_CAR_SQUARE = 0;
    private static final int INDEX_FREIGHT_CAR_WEIGHT = 1;

    public int parseDataForCarSquare(List<Integer> dataForInit) {
        return dataForInit.get(INDEX_FREIGHT_CAR_SQUARE);
    }

    public int parseDataForCarWeight(List<Integer> dataForInit) {
        return dataForInit.get(INDEX_FREIGHT_CAR_WEIGHT);
    }
}
