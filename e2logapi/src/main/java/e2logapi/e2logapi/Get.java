package e2logapi.e2logapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Get {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
sendGet("/customer/sub-users", Services.login());
	}
	public static BufferedReader sendGet(String Endpoint, String Xauth) throws Exception {
		
		String url = Global.url()+Endpoint;

		URL obj = new URL(url);
		HttpURLConnection con =  (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("X-AUTH-TOKEN", Xauth);
		con.setRequestProperty("Content-Type", "application/json");

		int responseCode = con.getResponseCode();
		Output.OutputConsole("Sending 'GET' request to : " + url);
		Output.OutputConsole("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		System.out.println("result"+ in.toString());
		System.out.println("result1"+"  "+responseCode);
		JSONObject Object = new JSONObject(in.readLine());
		System.out.println(Object);
		/*String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();*/
		
		return in;
	}
	
}
