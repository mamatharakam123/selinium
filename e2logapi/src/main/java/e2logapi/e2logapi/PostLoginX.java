package e2logapi.e2logapi;

import java.io.BufferedReader;


import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class PostLoginX {
	public static String authKey = "X-AUTH-TOKEN";
	public static JSONObject E2logPOST(String endpoint, JSONObject body,String Xauth) throws Exception{

		String url = "http://ci.thrymr.net:7070" + endpoint;
		System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty(authKey, Xauth);
		con.setRequestProperty("Content-Type", "application/json");
		// String data= "{\"email\":\"email@admin.com\",\"password\":\"123\"}";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body.toString());
		wr.flush();
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		//BufferedReader Response = PostLoginX.E2logPOST(Endpoint, body, Xauth);
		JSONObject Object = new JSONObject(in.readLine());
		System.out.println("Final Response >>>>> :  " + Object.toString());
		
		/*Output.OutputConsole("Sending 'POST' request to : " + url);
		Output.OutputConsole("Post parameters : " + body);
		Output.OutputConsole("Response Code : " + responseCode);
*/
		/*String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}*/
		
		return Object;
		
	}

/*public static String authKey = "X-AUTH-TOKEN";
	public static Logger logger = Logger.getLogger("POST");
	public static StringBuffer sendPost(String endpoint, JSONObject body, String Xauth)
			throws Exception {

		String url = Global.url() + endpoint;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		
		con.setRequestMethod("POST");
		con.setRequestProperty(authKey, Xauth);
		
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		System.out.println("fffffffffff"+con.toString());
		String loginPassword = login+ ":" + password;
		 
		String encoded = new sun.misc.BASE64Encoder().encode (loginPassword.getBytes());
		URLConnection conn = url.openConnection();
		conn.setRequestProperty ("Authorization", "Basic " + encoded);
		// String data= "{\"email\":\"email@admin.com\",\"password\":\"123\"}";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body.toString());
		wr.flush();
		int responseCode = con.getResponseCode();
		
		System.out.println("Response Code=" + responseCode);
		InputStream is = con.getInputStream();
		
		int ch;
		StringBuffer sb = new StringBuffer();
		while ((ch = is.read()) != -1) {
		sb.append((char) ch);
		
		}
		System.out.println(" sb " + sb.toString());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		Output.OutputConsole("Sending 'POST' request to : " + url);
		Output.OutputConsole("Post parameters : " + body);
		Output.OutputConsole("Response Code : " + responseCode);

		String inputLine;
		response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		return sb;
	}	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "mama@thrymr.net");
		jsonObject.put("contactNumber", "+91-8121026766");
		jsonObject.put("firstName", "mamatha");
		jsonObject.put("lastName", "rakam");
		jsonObject.put("companyName", "thrymr software");
		jsonObject.put("role", "CUSTOMER");
		jsonObject.put("phoneCountryId", "91");
		jsonObject.put("countryId", 1);
		//String logininput= jsonObject.toString();
		Xauthorization("/customer/registration", jsonObject);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "sa4inath.p8abb3a231@thrymr.net");
		jsonObject.put("contactNumber", "+91-8121026766");
		jsonObject.put("firstName", "mamatha");
		jsonObject.put("designation", "rakam");
		jsonObject.put("companyName", "software developer");
		jsonObject.put("viewOnly", true);
		jsonObject.put("canSubmitQuote", true);
		System.out.println("jsonObject>>>>>"+jsonObject);
		sendPost("/sub-user/registration", jsonObject ,PostLogin.login());
		
	}
*/
}
