package com.codapayment.csvparser.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CsvUtilsTest {
    CsvUtils csvUtils = new CsvUtils();

    @Test
    void testGetCSVHeaders() throws IOException {
        String[] result = csvUtils.getCSVHeaders("CSVPath", "delimiter");
        Assertions.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    void testParseCSVToJson() throws IOException {
        String result = csvUtils.parseCSVToJson("CSVPath", new String[]{"headers"}, "delimiter");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testWriteJSONToFile() throws IOException {
        csvUtils.writeJSONToFile("jsonPath", "jsonString");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme