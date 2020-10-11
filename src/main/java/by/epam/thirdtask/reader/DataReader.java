package by.epam.thirdtask.reader;

import by.epam.thirdtask.exception.CarException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static final Logger LOGGER = LogManager.getLogger();

    public List<String> readData(String filePath) throws CarException {
        List<String> dataForInitObjects = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                dataForInitObjects.add(data);
            }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "file is missing", e);
            throw new CarException("file is missing", e);
        }
        return dataForInitObjects;
    }
}
