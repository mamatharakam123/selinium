package apis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTypes {
	public static String method;
	public static String url;
	public static String input;
	public static String xauth;
	public static int row1;
	public static StringBuffer sb = null;
	
	
	//calling excel sheet
	public static XSSFSheet sheet() throws Exception {

		InputStream ExcelFileToRead = new FileInputStream("/home/thrymr/Documents/e2logwebs.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		List<String> list = new ArrayList<>();
		row1 = sheet.getLastRowNum();
		//System.out.println(row1);
		return sheet;
		
	}
	
	// calling method types 
	public static String method() throws Exception {
		
		System.out.println("method");
		
		
		StringBuffer sb = null;
		XSSFRow row;
		row1 = sheet().getLastRowNum();
		System.out.println(row1);
		for (int i = 1; i <= row1; i++) {
			System.out.println(row1);
			XSSFCell cell = sheet().getRow(i).getCell(0);
			 method =cell.getStringCellValue();
			
			System.out.println(method);
		
	}
		return method;


	}
	
	//calling url 
	public static String url() throws Exception {
		
		
		int row1 = sheet().getLastRowNum();
		System.out.println(row1);
		StringBuffer sb = null;
		for (int i = 1; i <= row1; i++) {
		
		XSSFCell cell2 = sheet().getRow(i).getCell(1);
		url =cell2.getStringCellValue();
		System.out.println(url);
		}
		
		
		return url;
		
		
	}
	
	//calling input data
	public static String input() throws Exception {
		

		int row1 = sheet().getLastRowNum();
		System.out.println(row1);
		StringBuffer sb = null;
		for (int i = 1; i <= row1; i++) {
			XSSFCell cell1 = sheet().getRow(i).getCell(2);
			input =cell1.getStringCellValue();
		System.out.println(input);
		
	}
		return input;
	}
	
	//calling xauth 
	public static String xauth() throws Exception {
		
		
		int row1 = sheet().getLastRowNum();
		System.out.println(row1);
		StringBuffer sb = null;
		for (int i = 1; i <= row1; i++) {
			XSSFCell cell3 = sheet().getRow(i).getCell(3);
			xauth = cell3.getStringCellValue();
			System.out.println(xauth);
			
		}
		return xauth;
	}
	
	
	
	/*public static void main(String[] args) throws Exception {
		System.out.println("testvfvhsfghsfgs");
		method();
		url();
		input();
		xauth();
		
	}*/
}



