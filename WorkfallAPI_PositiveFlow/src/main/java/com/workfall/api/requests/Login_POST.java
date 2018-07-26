package com.workfall.api.requests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

import com.workfall.api.utils.Global;
import com.workfall.api.utils.Output;

public class Login_POST {

	public static BufferedReader Xauthorization(String endpoint, JSONObject body,String Persondata) throws Exception{

		String url = Global.API_URL + endpoint;
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
		Output.OutputConsole(Persondata);
			
	/*	String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}*/
		//in.close();
		
		return in;
		
	}
	}
