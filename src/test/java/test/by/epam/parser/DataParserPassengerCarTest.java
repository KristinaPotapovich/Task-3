package test.by.epam.parser;

import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.parser.DataParser;
import by.epam.thirdtask.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserPassengerCarTest extends Assert {
    private List<Integer> dataForInit;
    private List<Integer> dataTest;
    private List<Integer> dataTestNegative;
    private int indexPassengerCarSquare;
    private int indexPassengerCarWeight;

    @BeforeTest
    private void init() throws CarException {
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
        indexPassengerCarSquare = 2;
        indexPassengerCarWeight = 3;
    }

    @Test
    public void parseDataForCarSquareTestPositive() {
        int expected = dataTest.get(indexPassengerCarSquare);
        int actual = dataForInit.get(indexPassengerCarSquare);
        assertEquals(actual, expected);
    }

    @Test
    public void parseDataForCarSquareTestNegative() {
        int expected = dataTestNegative.get(indexPassengerCarSquare);
        int actual = dataForInit.get(indexPassengerCarSquare);
        assertNotEquals(actual, expected);
    }

    @Test
    public void parseDataForCarWeightTestPositive() {
        int expected = dataTest.get(indexPassengerCarWeight);
        int actual = dataForInit.get(indexPassengerCarWeight);
        assertEquals(actual, expected);
    }

    @Test
    public void parseDataForCarWeightTestNegative() {
        int expected = dataTestNegative.get(indexPassengerCarWeight);
        int actual = dataForInit.get(indexPassengerCarWeight);
        assertNotEquals(actual, expected);
    }
}
