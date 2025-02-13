package com.qa.amexassesement.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
//	C:\Users\moham\eclipse-workspace\AmexAssignmentPlaywright\src\test\resources\testdata\TestData.xlsx	
//	static Path path = Paths.get(new File(System.getProperty("user.dir")).toPath().toString());
	public static String TESTDATA_SHEET_PATH =  "./src/test/resources/testdata/TestData.xlsx";
	
	

	static Workbook book;
	static Sheet sheet;
	
	

	public static List<Map<String, String>> readTestData(String filePath, String sheetName) {
		List<Map<String, String>> testData = new ArrayList<>();

		try (FileInputStream file = new FileInputStream(new File(filePath));
				Workbook workbook = new XSSFWorkbook(file)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet '" + sheetName + "' not found in the Excel file.");
			}

			// Get the header row
			Row headerRow = sheet.getRow(0);
			List<String> headers = new ArrayList<>();
			for (Cell cell : headerRow) {
				headers.add(cell.getStringCellValue());
			}

			// Iterate through rows (skip header row)
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Map<String, String> rowData = new HashMap<>();

				for (int j = 0; j < headers.size(); j++) {
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					rowData.put(headers.get(j), cell.toString());
				}

				testData.add(rowData);
			}

		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file: " + filePath, e);
		}

		return testData;
	}
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}