package apis;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

public class sample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStream ExcelFileToRead = new FileInputStream("/home/thrymr/Documents/e2logwebs.xlsx");
XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		int row1 = sheet.getLastRowNum();
		XSSFCell cell = sheet.getRow(2).getCell(2);
		String CellData2 =cell.getStringCellValue();
		System.out.println(CellData2);
		
		/*JSONObject x=new JSONObject();
		x.put("email", "mamatha@thrymr.net")
		x.put("password", "")*/
		URL obj = new URL("http://ci.thrymr.net:7070/customer/registration");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

			wr.writeBytes(CellData2);
		
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		System.out.println("Response Code=" + responseCode);
		InputStream is = con.getInputStream();
		
		int ch;
		StringBuffer sb = new StringBuffer();
		while ((ch = is.read()) != -1) {
		sb.append((char) ch);
		
		}
		System.out.println(" sb " + sb.toString());

	}

}
