package test.by.epam.parser;

import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.parser.DataParser;
import by.epam.thirdtask.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest extends Assert {
    private List<Integer> dataForInit;
    private List<Integer> dataTest;
    private List<Integer> dataTestNegative;
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
    }

    @Test
    public void parseToIntegerTestPositive() {
        List<Integer> actual = dataForInit;
        List<Integer> expected = dataTest;
        assertEquals(actual, expected);
    }

    @Test
    public void parseToIntegerTestNegative() {
        List<Integer> actual = dataForInit;
        List<Integer> expected = dataTestNegative;
        assertNotEquals(actual, expected);
    }
}
