package by.epam.thirdtask.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static final String DATA_DELIMITER = "\\s+";

    private DataParser() {
    }

    public static List<Integer> parseToInteger(List<String> dataForInitObjects) {
        List<Integer> dataForInit = new ArrayList<>();
        String[] strings;
        for (String data : dataForInitObjects) {
            if (data != null) {
                strings = data.split(DATA_DELIMITER);
                for (String string : strings) {
                    dataForInit.add(Integer.parseInt(string));
                }
            }
        }
        return dataForInit;
    }

}
