package com.workfall.api.services;

import org.json.JSONObject;

import com.workfall.api.requests.Response;
import com.workfall.api.utils.Global;
import com.workfall.api.utils.ReadPropertyFileAPI;
import com.workfall.api.utils.Utils;

public class General_Services extends Global {
	public static String fileName;
	public static String LoginEndpoint = "/login";
	public static String Admin_Login() throws Exception {
		String PersonData = "\nService Access with the Role : ADMIN & " + "Email : " + Global.Admin_Email;
		return Response.OutputResponse_Post_Login(LoginEndpoint, Admin_Loginbody(), PersonData);	
	}

	public static String PO1_Login() throws Exception {
		String PersonData = "\nService Access with the Role : Product Owner & " + "Email : " + Global.PO1_Email;
		return Response.OutputResponse_Post_Login(LoginEndpoint, PO1_Loginbody(), PersonData);
	}

	public static String PO2_Login() throws Exception {
		String PersonData = "Service Access with the Role : Product Owner & " + "Email : " + Global.PO2_Email;
		return Response.OutputResponse_Post_Login(LoginEndpoint, PO2_Loginbody(), PersonData);
	}

	public static String PM1_Login() throws Exception {
		String PersonData = "\nService Access with the Role : Project Manager & " + "Email : " + Global.getPM1_EmailID();
		return Response.OutputResponse_Post_Login(LoginEndpoint, PM1_Loginbody(), PersonData);
	}

	public static String PM2_Login() throws Exception {
		String PersonData = "Service Access with the Role : Project Manager & " + "Email : " + Global.getPM2_EmailID();
		return Response.OutputResponse_Post_Login(LoginEndpoint, PM2_Loginbody(), PersonData);
	}

	public static String Dev1_Login() throws Exception {
		String PersonData = "\nService Access with the Role : DEVELOPER & " + "Email : " + Global.getDev1_EmailID();
		return Response.OutputResponse_Post_Login(LoginEndpoint, Dev1_Loginbody(), PersonData);
	}

	public static String Dev2_Login() throws Exception {
		String PersonData = "Service Access with the Role : DEVELOPER & " + "Email : " + Global.getDev2_EmailID();
		return Response.OutputResponse_Post_Login(LoginEndpoint, Dev2_Loginbody(), PersonData);
	}
	
	public static void changePassword() throws Exception {
		String Endpoint = "/change-password";
		
		String oldPassword = "123";
		String password = Change_password;
		String confirmPassword = Change_password;
		
		body = new JSONObject();
		body.put("oldPassword", oldPassword);
		body.put("password", password);
		body.put("confirmPassword", confirmPassword);
		
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
	}
	public static void getAllCountries() throws Exception{
		String Endpoint = "/get-all-countries";
		
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
	}
	public static void verifyEmailConfirmationKeyForLoggedInUser() throws Exception{
		String Dev1Endpoint = "/verify-email-confirmation-key-with-app-user-id?appUserId="
				+ getappUserIdbyEmail(getDev1_EmailID()) + "&key=" + getEmailConfirmationKey(getDev1_EmailID());
		Response.OutputResponse_Get(Dev1Endpoint, General_Services.Dev1_Login());
		Response.OutputResponse_Get(Dev1Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Dev1Endpoint, General_Services.PM1_Login());
		String PO1Endpoint = "/verify-email-confirmation-key-with-app-user-id?appUserId="
				+ getappUserIdbyEmail(PO1_Email) + "&key=" + getEmailConfirmationKey(PO1_Email);
		Response.OutputResponse_Get(PO1Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(PO1Endpoint, General_Services.Dev1_Login());
		Response.OutputResponse_Get(PO1Endpoint, General_Services.PM1_Login());
		String PM1Endpoint = "/verify-email-confirmation-key-with-app-user-id?appUserId="
				+ getappUserIdbyEmail(getPM1_EmailID()) + "&key=" + getEmailConfirmationKey(getPM1_EmailID());
		Response.OutputResponse_Get(PM1Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(PM1Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(PM1Endpoint, General_Services.Dev1_Login());
	}
	public static void saveFeedback() throws Exception {
		String Endpoint = "/save-feedback";
		
		String feedbackTitle = Utils.RandomStringLong();
		String feedbackDescription =Utils.RandomStringLong() ;
		
		body = new JSONObject();
		body.put("feedbackTitle", feedbackTitle);
		body.put("feedbackDescription", feedbackDescription);
		
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
	}
	public static void getUserFeedbacks() throws Exception {
		String Endpoint = "/get-user-feedbacks";
		
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
	}
	public static void UpdateUserProfile() throws Exception {
		String Endpoint = "/updateUserProfile";
		
		String firstName = Utils.RandomString();
		String lastName =Utils.RandomString() ;
		String email = ReadPropertyFileAPI.ReadFile("PO1_Email");
		String companyName = Utils.RandomString();
		String mobileNumber =Utils.generatePhonenumber() ;
		String internationalCallingCode =Global.Global_IntCallingCode;
		String countryName = Global.countryName;
		String countryId = Global.countryId;
		String city = Utils.RandomStringLong();
		String line1Address =Utils.RandomString() ;
		String postalCode =Utils.generatePhonenumber() ;
		String iso2 =Global.Global_iso2 ;
		
		body = new JSONObject();
		body.put("firstName", firstName);
		body.put("lastName", lastName);
		body.put("email", email);
		body.put("companyName", companyName);
		body.put("mobileNumber", mobileNumber);
		body.put("internationalCallingCode", internationalCallingCode);
		body.put("countryName", countryName);
		body.put("countryId", countryId);
		body.put("city", city);
		body.put("line1Address", line1Address);
		body.put("postalCode", postalCode);
		body.put("iso2", iso2);
		
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
		
		Global.makeAllVerificationsTrue();
	}
	public static void main(String[] args) throws Exception {
		getAllCountries();
	}
}
