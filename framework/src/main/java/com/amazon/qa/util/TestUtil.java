package com.amazon.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Dell\\eclipse-workspace\\framework\\src\\main\\java\\com\\amazon\\qa\\testdata\\Framework.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	
	
	//complete this later
	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		
		
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		
		
		return null;
		
	}
	
}
