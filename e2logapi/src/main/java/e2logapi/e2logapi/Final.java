package e2logapi.e2logapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

public class Final {
	/*public static String authKey = "X-AUTH-TOKEN";
 public static BufferedReader in;

	public static BufferedReader sendPostRequest(String requestUrl,  JSONObject body,String xauth) {
	    try {
	        URL url = new URL(requestUrl);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("POST");
			con.setRequestProperty(authKey, xauth);
			con.setRequestProperty("Content-Type", "application/json");
			// String data= "{\"email\":\"email@admin.com\",\"password\":\"123\"}";
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(body.toString());
			wr.flush();
			int responseCode = con.getResponseCode();
			System.out.println("Response Code :"+responseCode);
			 in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 JSONObject Object = new JSONObject(in.readLine());
			 String Status = Object.get("message").toString();
				System.out.println(Status.toString());
	    } catch (Exception e) {
   	     throw new RuntimeException(e.getMessage());
   }
	    return in;
	}
				
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("email", "sa4inath.p8abb3a231@thrymr.net");
			jsonObject.put("contactNumber", "+91-8121026766");
			jsonObject.put("firstName", "mamatha");
			jsonObject.put("designation", "rakam");
			jsonObject.put("companyName", "software developer");
			jsonObject.put("viewOnly", true);
			jsonObject.put("canSubmitQuote", true);
			System.out.println(jsonObject.toString());
			sendPostRequest("http://ci.thrymr.net/sub-user/registration", jsonObject ,PostLogin.login());
			
		}
	    */
	
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
	public static BufferedReader E2logPOST(String endpoint, JSONObject body,String Xauth) throws Exception{

		String url = "http://ci.thrymr.net:7070" + endpoint;
		System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("X-AUTH-TOKEN", Xauth);
		con.setRequestProperty("Content-Type", "application/json");
		// String data= "{\"email\":\"email@admin.com\",\"password\":\"123\"}";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body.toString());
		wr.flush();
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		/*Output.OutputConsole("Sending 'POST' request to : " + url);
		Output.OutputConsole("Post parameters : " + body);
		Output.OutputConsole("Response Code : " + responseCode);
*/
		/*String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}*/
		
		return in;
		
	}

	public static void OutputResponse_Post(String Endpoint, JSONObject body, String Role) {
		try {
			System.out.println("yuiyuiyuihuihsdi");
			BufferedReader Response = E2logPOST(Endpoint, body, Role);
			JSONObject Object = new JSONObject(Response.readLine());
				//Output.OutputConsole(">>>>> Service Status <<<<<>>>>>: " + Object.toString());
				
				System.out.println("Final Response >>>>> :  " + Object.toString());
			Response.close();
		} catch (Exception e) {
		}
	}
	public static String login_Xuath() throws Exception {
		String X_Authorization = "";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "mamatha@thrymr.net");
		jsonObject.put("password", "e2Log@123");
		//String logininput= jsonObject.toString();
		
		BufferedReader sb1 =E2logXauthorization("/login", jsonObject);
		JSONObject Object = new JSONObject(sb1.readLine());
		JSONObject payLoadResponse = Object.getJSONObject("payLoad");
		X_Authorization = payLoadResponse.get("xauthToken").toString();
		System.out.println("Xauth>>>>>"+X_Authorization);
		return X_Authorization;
	}
	public static void createUser() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "sa4inath.p8abb3a231@thrymr.net");
		jsonObject.put("contactNumber", "+91-8121026766");
		jsonObject.put("firstName", "mamatha");
		jsonObject.put("designation", "rakam");
		jsonObject.put("companyName", "software developer");
		jsonObject.put("viewOnly", true);
		jsonObject.put("canSubmitQuote", true);
		System.out.println("jsonObject>>>>>"+jsonObject);
		OutputResponse_Post("/sub-user/registration", jsonObject, login_Xuath());
		
		
	}
	public static void rfqstep1() throws Exception {
		JSONObject jsonObject = new JSONObject();
	Long tirerIds[] ={1l,2l,3l} ;
	
		jsonObject.put("companyName", "thrymr software");
		jsonObject.put("contactPersonEmail", "mamatha@thrymr.net");
		jsonObject.put("contactPersonMobile", "8121026766");
		jsonObject.put("contactPersonName", "mamatha");
		jsonObject.put("description", "nothing to say");
		jsonObject.put("entityId", 0);
		jsonObject.put("id", 0);
		jsonObject.put("notifyEmail", "mamatha21@thrymr.net");
		jsonObject.put("officeLandNumber", "8121026766");
		jsonObject.put("paymentOption", "DIRECT_PAYMENT");
		jsonObject.put("postedDate", "2018-03-15");
		jsonObject.put("quoteCurrency", "INR");
		jsonObject.put("responseDate", "2018-03-18");
		jsonObject.put("rfqId", "");
		jsonObject.put("rfqStatus", "");
		jsonObject.put("teirIds", tirerIds );
		jsonObject.put("title", "first one");
		String Rfqstep1= jsonObject.toString();
		System.out.println(Rfqstep1.toString());
		
		OutputResponse_Post("/rfq/step/basic-information/submit", jsonObject, login_Xuath());
	}
	public static void main(String[] args) throws Exception {
		
		createUser();
		rfqstep1();
	}
	}
