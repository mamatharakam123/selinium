package apis;


import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Post {
	
	public static String  url,input,method,xauth ;
		
	
	public static void main(String[] args) throws Exception {
		//String CellData,CellData1;
		InputStream ExcelFileToRead = new FileInputStream("/home/thrymr/Documents/e2logwebs.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		List<String> list = new ArrayList<>();
		int row1 = sheet.getLastRowNum();
		System.out.println(row1);
		StringBuffer sb = null;
		for (int i = 1; i <= row1; i++) {
			XSSFCell cell = sheet.getRow(i).getCell(0);
			 method =cell.getStringCellValue();
			
			System.out.println(method);
					
					XSSFCell cell2 = sheet.getRow(i).getCell(1);
					url =cell2.getStringCellValue();
					System.out.println(url);
					
				
					XSSFCell cell1 = sheet.getRow(i).getCell(2);
					XSSFCell cell3 = sheet.getRow(i).getCell(3);
					xauth = cell3.getStringCellValue();
					if (cell1!=null) {
						input =cell1.getStringCellValue();
					System.out.println(input);
					URL obj = new URL(url);
					// System.out.println("done");
					// URL obj = POstreqRes.url();zzz
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					if (method.equals("Post")) {
						
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json");
					con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

					// Send post request
					con.setDoOutput(true);
					DataOutputStream wr = new DataOutputStream(con.getOutputStream());
					/*if (xauth!=null) {
						
					}*/
					if (input!=null) {
						wr.writeBytes(input);
					}
					wr.flush();
					wr.close();
					
					int responseCode = con.getResponseCode();
					System.out.println("Response Code=" + responseCode);
					InputStream is = con.getInputStream();
					
					int ch;
					 sb = new StringBuffer();
					while ((ch = is.read()) != -1) {
					sb.append((char) ch);
					
					}
					System.out.println(" sb " + sb.toString());
					}
					

					
					else{
						JSONParser parser = new JSONParser(); 
						JSONObject json = (JSONObject) parser.parse(sb.toString());
						Object xauth = json.get("payLoad");
						System.out.println("----"+xauth.toString());
						JSONObject json1 = (JSONObject) parser.parse(xauth.toString());
						Object xauth1= json1.get("xauthToken");
						System.out.println("/////////////"+ xauth1);
					con.setRequestMethod("GET");
					con.setRequestProperty("Content-Type", "application/json");
					/*con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
					           con.setRequestProperty("APP-USER-ID", "3");*/
					           con.setRequestProperty("X-AUTH-TOKEN", xauth1.toString());
					    int responseCode = con.getResponseCode();
					System.out.println("Response Code="+responseCode);
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
					System.out.println(inputLine);
					}
					in.close();
					}
		}
		
		
	}
	}}
	

