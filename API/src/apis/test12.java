package apis;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test12 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExcelTypes.sheet();
		if (ExcelTypes.input()!=null) {
			URL obj = new URL(ExcelTypes.url());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			if (ExcelTypes.method().equals("Post")) {
				
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			/*if (xauth!=null) {
				
			}*/
			if (ExcelTypes.input()!=null) {
				wr.writeBytes(ExcelTypes.input());
			}
			wr.flush();
			wr.close();
			
			int responseCode = con.getResponseCode();
			System.out.println("Response Code=" + responseCode);
			InputStream is = con.getInputStream();
			
			int ch;
			 ExcelTypes.sb = new StringBuffer();
			while ((ch = is.read()) != -1) {
			ExcelTypes.sb.append((char) ch);
			
			}
			System.out.println(" sb " + ExcelTypes.sb.toString());
		}
	}

	}}
