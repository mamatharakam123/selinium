package com.workfall.api.requests;

import java.io.BufferedReader;
import org.json.JSONObject;

import com.workfall.api.utils.Output;

public class Response {

	public static void OutputResponse_Get(String Endpoint, String Role ) {
		try {
			BufferedReader Response = GET.sendGet(Endpoint, Role);
			JSONObject Object = new JSONObject(Response.readLine());
			String Status = Object.get("status").toString();
			if (Status.equals("FAILURE")) {
				Output.OutputConsole(">>>>> Service Status <<<<<>>>>>: " + Status);
				Output.OutputConsole(">>>>> ErrorMessage <<<<<>>>> : " + Object.get("errorMessage").toString());
			} else {
				Output.OutputConsole(">>>>> Service Status <<<<<>>>>>: " + Status);
				Output.OutputConsole("Final Response >>>>> : " + Object.toString());
			}
			Response.close();
		} catch (Exception e) {
		}
	}
	public static void OutputResponse_Post(String Endpoint, JSONObject body, String Role){
		try {
			BufferedReader Response = POST.sendPost(Endpoint, body, Role);
			JSONObject Object = new JSONObject(Response.readLine());
			String Status = Object.get("status").toString();
			if (Status.equals("FAILURE")) {
				Output.OutputConsole(">>>>> Service Status <<<<<>>>>>: " + Status);
				Output.OutputConsole(">>>>> ErrorMessage <<<<<>>>> : " + Object.get("errorMessage").toString());
			} else {
				Output.OutputConsole(">>>>> Service Status <<<<<>>>>>: " + Status);
				Output.OutputConsole("Final Response >>>>> : " + Object.toString());
			}
			Response.close();
		} catch (Exception e) {
		}
	}
	public static String OutputResponse_Post_Login(String Endpoint, JSONObject body, String Persondata){
		String X_Authorization = "";
		try {
			BufferedReader Response = Login_POST.Xauthorization(Endpoint, body, Persondata);
			JSONObject Object = new JSONObject(Response.readLine());
			String Status = Object.get("status").toString();
			if (Status.equals("SUCCESS")) {
				JSONObject payLoadResponse = Object.getJSONObject("payLoad");
				X_Authorization = payLoadResponse.get("xAuth").toString();
			} else {
				Output.OutputConsole(">>>>>Login Failure ErrorMessage <<<<<>>>> : " + Object.get("errorMessage").toString());
			}
			Response.close();
		} catch (Exception e) {
		}
		return X_Authorization;
	}
}

