package apis;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class InputBody {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
login();
rfqstep1();
	}
	
	
	public static String login() {
		
		JSONObject jsonObject = new JSONObject();
				jsonObject.put("email", "mamatha@thrymr.net");
				jsonObject.put("password", "e2Log@123");
				String logininput= jsonObject.toString();
		
		/*String jsonString =  new JSONObject().put("", "")
                .put("email", "mamatha@thrymr.net")
                .put("password", "e2Log@123")
                .toString();*/

System.out.println(logininput);
return logininput;
	}
	
	
	
	public static String rfqstep1() {
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
		System.out.println(Rfqstep1);
		return Rfqstep1;
	}
	

}
