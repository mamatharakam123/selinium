package e2logapi.e2logapi;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class PostLogin {

	public static BufferedReader E2logXauthorization(String endpoint, JSONObject body) throws Exception{

		String url = "http://ci.thrymr.net:7070" + endpoint;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body.toString());
		wr.flush();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
	/*	String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}*/
		//in.close();
		
		return in;
		
	}
	
	
	
	
	
	
	
	
	
	/*public class Output {
		public static void OutputConsole(String console) throws Exception{
			File file = new File(Utils.fileNameForOutput());
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(console);
			bw.newLine();
			bw.close();
		}
		// TODO Auto-generated method stub
		public static StringBuffer Xauthorization(String endpoint, JSONObject body) throws Exception{

			String url = Global.url() + endpoint;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
//			con.setRequestProperty("X-AUTH-TOKEN", Xauth);x
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(body.toString());
			wr.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			Output.OutputConsole(Persondata);
			int responseCode = con.getResponseCode();
			System.out.println("Response Code=" + responseCode);
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer sb = new StringBuffer();
			while ((ch = is.read()) != -1) {
			sb.append((char) ch);
			
			}
			System.out.println(" sb " + sb.toString());
			
				
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			//in.close();
			
			return sb;
	}
	
		public static String login() throws Exception {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("email", "mamatha@thrymr.net");
			jsonObject.put("password", "e2Log@123");
			//String logininput= jsonObject.toString();
			
			StringBuffer sb1 =Xauthorization("/login", jsonObject);
			System.out.println("-"+sb1.toString());
			JSONParser parser = new JSONParser(); 
			JSONObject json = (JSONObject) parser.parse(sb1.toString());
			Object xauth = json.get("payLoad");
			System.out.println("----"+xauth.toString());
			JSONObject json1 = (JSONObject) parser.parse(xauth.toString());
			Object xauth1= json1.get("xauthToken");
			System.out.println("/////////////"+ xauth1);
			String xauthr = xauth1.toString();
			return xauthr;
		}
		
		*/
}
