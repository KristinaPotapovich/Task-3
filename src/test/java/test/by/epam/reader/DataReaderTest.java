package test.by.epam.reader;

import by.epam.thirdtask.exception.CarException;
import by.epam.thirdtask.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest extends Assert {
    private DataReader dataReader;
    private List<String>data;
    @BeforeTest
    private void init(){
        dataReader = new DataReader();
        data = new ArrayList<>();
        data.add("2");
        data.add("3400");
        data.add("3");
        data.add("5600");
    }
    @Test
    public void readTextTestTrue() throws CarException {
        List<String>expected = data;
       List<String> actual = dataReader.readData("init/data.txt");
        assertEquals(actual, expected);
    }
    @Test(expectedExceptions = CarException.class)
    public void trowShapeException() throws CarException {
        dataReader.readData("/testfile/data.txt");
    }
}
