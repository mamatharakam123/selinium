package com.workfall.api.requests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import org.json.JSONObject;

import com.workfall.api.utils.Output;
import com.workfall.api.utils.ReadPropertyFileAPI;


public class POST {
	static String X_Authorization;
	public static Logger logger = Logger.getLogger("POST");

	public static BufferedReader sendPost(String Endpoint, JSONObject body, String Xauth)
			throws Exception {

		String url = ReadPropertyFileAPI.ReadFile("API_URL") + Endpoint;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("X-Authorization", Xauth);
		con.setRequestProperty("Content-Type", "application/json");
		// String data= "{\"email\":\"email@admin.com\",\"password\":\"123\"}";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body.toString());
		wr.flush();
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		Output.OutputConsole("Sending 'POST' request to : " + url);
		Output.OutputConsole("Post parameters : " + body);
		Output.OutputConsole("Response Code : " + responseCode);

		/*String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}*/
		
		return in;
	}	
}
