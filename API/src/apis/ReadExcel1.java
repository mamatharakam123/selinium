package apis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static List<String> apiCalling(String CellData, String CellData1) throws Exception {
		
		// TODO Auto-generated method stub
		InputStream ExcelFileToRead = new FileInputStream("/home/thrymr/Documents/e2logwebs.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		List<String> list = new ArrayList<>();
		int row1 = sheet.getLastRowNum();
		System.out.println(row1);
		for (int i = 1; i <= row1; i++) {
			XSSFCell cell = sheet.getRow(i).getCell(0);
			CellData =cell.getStringCellValue();
			System.out.println(CellData);
			
		
			XSSFCell cell1 = sheet.getRow(i).getCell(1);
			CellData1 =cell1.getStringCellValue();
			System.out.println(CellData1);
		
		}
		list.add(CellData);
		list.add(CellData1);
		return list;

	/*	Iterator rows = sheet.rowIterator();

		   
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();}
		
		int firstRow = sheet.getFirstRowNum();
		   int lastRow = sheet.getLastRowNum();
		   System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR+++++++++++++++++"+firstRow);
		   System.out.println("R>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lastRow);
	}*/
		

}
}
