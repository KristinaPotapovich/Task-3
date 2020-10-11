package test.by.epam.parser;

import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.parser.DataParser;
import by.epam.thirdtask.parser.impl.DataParserFreightCar;
import by.epam.thirdtask.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserFreightCarTest extends Assert {
    private List<Integer> dataForInit;
    private List<Integer> dataTest;
    private List<Integer> dataTestNegative;
    private int indexFreightCarSquare;
    private int indexFreightCarWeight;

    @BeforeTest
    private void init() throws CarException {
        DataParserFreightCar dataParserForFreightCar = new DataParserFreightCar();
        DataReader dataReader = new DataReader();
        String filePath = "init/data.txt";
        List<String> dataForInitObjects = dataReader.readData(filePath);
        dataForInit = DataParser.parseToInteger(dataForInitObjects);
        dataTest = new ArrayList<>();
        dataTest.add(2);
        dataTest.add(3400);
        dataTest.add(3);
        dataTest.add(5600);
        dataTestNegative = new ArrayList<>();
        dataTestNegative.add(15);
        dataTestNegative.add(2444);
        dataTestNegative.add(67);
        dataTestNegative.add(7688);
        indexFreightCarSquare = 0;
        indexFreightCarWeight = 1;
    }

    @Test
    public void parseDataForCarSquareTestPositive() {
        int expected = dataTest.get(indexFreightCarSquare);
        int actual = dataForInit.get(indexFreightCarSquare);
        assertEquals(actual, expected);
    }

    @Test
    public void parseDataForCarSquareTestNegative() {
        int expected = dataTestNegative.get(indexFreightCarSquare);
        int actual = dataForInit.get(indexFreightCarSquare);
        assertNotEquals(actual, expected);
    }

    @Test
    public void parseDataForCarWeightTestPositive() {
        int expected = dataTest.get(indexFreightCarWeight);
        int actual = dataForInit.get(indexFreightCarWeight);
        assertEquals(actual, expected);
    }

    @Test
    public void parseDataForCarWeightTestNegative() {
        int expected = dataTestNegative.get(indexFreightCarWeight);
        int actual = dataForInit.get(indexFreightCarWeight);
        assertNotEquals(actual, expected);
    }

}
