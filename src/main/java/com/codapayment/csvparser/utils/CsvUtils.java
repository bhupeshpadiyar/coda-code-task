package com.codapayment.csvparser.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvUtils {
	
    private static final String DECIMAL_REG_EXPRESSION = "-?\\d+(\\.\\d+)?";

    private static final String NUMBER_REG_EXPRESSION = "-?\\d+(\\d+)?";

    /**
     * Read first row (Header) of the CSV file with the given delimiter
     * */

    public  String[] getCSVHeaders(String CSVPath, String delimiter) throws IOException {

        Path myPath = Paths.get(CSVPath);
        return Files.lines(myPath)
                .map(s -> s.split(delimiter))
                .findFirst()
                .get();

    }

    /**
     * 1: Parse all the rows of the CSV File (Skip first row i.e Header)
     * 2: Convert each row to list of String separated by the given delimiter
     * 3: Create a key-value pair with the header labels
     * 4: Add the key-value pair to the List
     * */
    public String parseCSVToJson(String CSVPath,String[] headers,String delimiter) throws IOException {
        List<Map<String, Object>> result=null;
        try (Stream<String> stream = Files.lines(Paths.get(CSVPath))) {
            result = stream.skip(1) // skip headers
                    .map(line -> line.split(delimiter))
                    .map(data -> {
                        Map<String, Object> map = new LinkedHashMap<>();
                        for (int i = 0; i < data.length; i++) {
                            map.put(headers[i], convertObjectDataType(data[i]));
                        }
                        return map;
                    })
                    .collect(Collectors.toList());
        }
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(result);
    }

    /**
     * Write the JSON String to the JSON file
     * */

    public void writeJSONToFile(String jsonPath, String jsonString) throws IOException {
         Path path = Paths.get(jsonPath);
         Files.write(path, jsonString.getBytes());
    }

     /**
      * Method to check if the given String is a Number &
      * convert String to specific Object
      * */
	private Object convertObjectDataType(String value) throws NumberFormatException{
		String trimmedValue = value.trim();
		Object returnObject = null;

		if(trimmedValue.matches(NUMBER_REG_EXPRESSION)) {
            returnObject = Integer.parseInt(trimmedValue);
        } else if(trimmedValue.matches(DECIMAL_REG_EXPRESSION)) {
            returnObject = Double.parseDouble(trimmedValue);
        } else {
            returnObject = trimmedValue;
        }
		return returnObject;
	}
}
