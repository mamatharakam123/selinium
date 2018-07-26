package e2logapi.e2logapi;


import java.io.BufferedReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Services {
	
	///Login service
	public static String login() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "customer1@test.com");
		jsonObject.put("password", "e2Log@123");
		jsonObject.put("role", "CUSTOMER");
		//String logininput= jsonObject.toString();
		
		BufferedReader sb1 =PostLogin.E2logXauthorization("/login", jsonObject);
		//PostLogin.E2logXauthorization("/login", jsonObject);
		JSONObject Object = new JSONObject(sb1.readLine());
		System.out.println("login result"+" "+Object.toString());
		JSONObject payLoadResponse = Object.getJSONObject("payLoad");
	String	X_Authorization = payLoadResponse.get("xauthToken").toString();
		System.out.println("Xauth>>>>>"+X_Authorization);
		
		/*System.out.println("-"+sb1.toString());
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(sb1.toString());
		Object xauth = json.get("payLoad");
		System.out.println("----"+xauth.toString());
		JSONObject json1 = (JSONObject) parser.parse(xauth.toString());
		Object xauth1= json1.get("xauthToken");
		System.out.println("/////////////"+ xauth1);
		String xauthr = xauth1.toString();
		return xauthr;*/
		return X_Authorization;
	}
	
	/// creating subusers
	public static JSONObject create_cus_sub() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "sa4inath.p8abb3a231@thrymr.net");
		jsonObject.put("contactNumber", "+91-8121026766");
		jsonObject.put("firstName", "mamatha");
		jsonObject.put("designation", "rakam");
		jsonObject.put("companyName", "software developer");
		jsonObject.put("viewOnly", true);
		jsonObject.put("canSubmitQuote", true);
		System.out.println("jsonObject>>>>>"+jsonObject);
		//OutputResponsePost.OutputResponse_Post("/sub-user/registration", jsonObject ,login());
		return jsonObject;
		
	}
	
	////Rfq Service
	
	
	public static Long rfqstep1() throws Exception {
		JSONObject jsonObject = new JSONObject();
	Long tierIds[] ={1l,2l,3l} ;
	
		jsonObject.put("companyName", "thrymr software");
		jsonObject.put("contactPersonEmail", "mamatha@thrymr.net");
		jsonObject.put("contactPersonMobile", "8121026766");
		jsonObject.put("contactPersonName", "mamatha");
		jsonObject.put("description", "nothing to say");
		jsonObject.put("contactPersonMobileCountry", 91);
		jsonObject.put("notifyEmail", "mamatha21@thrymr.net");
		jsonObject.put("officeLandNumber", "8121026766");
		jsonObject.put("paymentOption", "DIRECT_PAYMENT");
		jsonObject.put("postedDate", "2018-03-15");
		jsonObject.put("quoteCurrency", "INR");
		jsonObject.put("responseDate", "2018-03-18");
		jsonObject.put("rfqStatus", "");
		jsonObject.put("teirIds", tierIds );
		jsonObject.put("title", "first one");
		JSONObject test = new PostLoginX().E2logPOST("/rfq/step/basic-information/submit",jsonObject,login());
		System.out.println("login result"+" "+test.toString());
		JSONObject payLoadResponse = test.getJSONObject("payLoad");
		Long rfq_id = Long.parseLong(payLoadResponse.get("requestForQuoteId").toString());
		System.out.println("rfq_id>>>>>"+rfq_id);
		
		return rfq_id;
		
		
		//OutputResponsePost.OutputResponse_Post("/rfq/step/basic-information/submit",jsonObject,login());
	}
	public static JSONObject rfqstep2() throws Exception {
		JSONObject jsonObject = new JSONObject();
		JSONObject deliveryaddress = new JSONObject();
		deliveryaddress.put("addressLine1", "kapil towers");
		//db connection
		deliveryaddress.put("cityId", 4466);
		deliveryaddress.put("date", "2018-03-18");
		deliveryaddress.put("countryId", 101 );
		deliveryaddress.put("emailAddress", "mamatha@thrymr.net");
		deliveryaddress.put("landLineNumber", "8121026766");
		deliveryaddress.put("location", "WAREHOUSE");
		deliveryaddress.put("mobileNumber", "8121026766");
		deliveryaddress.put("name", "mamatha");
		deliveryaddress.put("postalCode", "505001");
		deliveryaddress.put("stateId", 36);
		jsonObject.put("deliveryAddress", deliveryaddress.toString());
		
		JSONObject pickupaddress = new JSONObject();
		pickupaddress.put("addressLine1", "gachibowli");
		pickupaddress.put("cityId",707);
		
		pickupaddress.put("countryId", 101 );
		
		pickupaddress.put("date", "2018-03-16");
		pickupaddress.put("emailAddress", "mamatha1@thrymr.net");
		pickupaddress.put("landLineNumber", "8121026766");
		pickupaddress.put("location", "QUAY_SIDE");
		pickupaddress.put("mobileNumber", "8121026766");
		pickupaddress.put("name", "surya");
		pickupaddress.put("postalCode", "505001");
		pickupaddress.put("stateId", 10);
		jsonObject.put("pickupAddress", pickupaddress.toString());
		jsonObject.put("isPartialQuoteAllowed", true);
		jsonObject.put("requestForQuoteId", rfqstep1());
		
		return jsonObject;
	}
	
	public static void main(String[] args) throws Exception {
		//Get.sendGet("/customer/sub-users",login());
		/*create_cus_sub();
		rfqstep1();*/
		/*PostLoginX.E2logPOST("/sub-user/registration", create_cus_sub(),login());
		PostLoginX.E2logPOST("/rfq/step/basic-information/submit",rfqstep1(),login());*/
		login();
		rfqstep1();
		PostLoginX.E2logPOST("/rfq/step/item-details/submit", rfqstep2(), login());
		
		
	}
	
	
	}


