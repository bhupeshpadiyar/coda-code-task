package com.codapayment.csvparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codapayment.csvparser.utils.CsvUtils;


@SpringBootApplication
public class CsvParserApplication implements CommandLineRunner {

	@Value("${csv.input.file}")
	private String inputFile;

	@Value("${json.output.file}")
	private String outputFile;

	@Value("${csv.delimiter}")
	private String delimiter;
	
	private final Logger logger =  LoggerFactory.getLogger(CsvParserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CsvParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			// Read headers

			logger.debug("Reading CSV file headers : ");
			String[] headers=new CsvUtils().getCSVHeaders(inputFile,delimiter);

			logger.debug("CSV File Headers : ", headers.toString());
			
			logger.debug("Parsing CSV to JSON format : ");
	        //Read the csv data
			String jsonResp = new CsvUtils().parseCSVToJson(inputFile,headers,delimiter);
			
			logger.debug("JSON Response : ", jsonResp);
			
			logger.debug("Writing JSON String to JSON File : ");
			
			new CsvUtils().writeJSONToFile(outputFile, jsonResp);
			
			logger.debug("CSV to JSON conversion Successful!");
		} catch (Exception e) {
			logger.error("Exception!! ", e.getMessage());
		}
	}
}
