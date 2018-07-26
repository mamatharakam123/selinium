package com.workfall.api.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import com.workfall.api.requests.Response;
import com.workfall.api.utils.Global;
import com.workfall.api.utils.ReadPropertyFileAPI;
import com.workfall.api.utils.Utils;
import com.workfall.data.XMLObjects;

public class Leave_Services extends Global {

	public static String LeaveServicesMap = ReadPropertyFileAPI.ReadFile("LeaveServicesMap");

	public static void saveLeaveApplication() throws Exception {
		String Endpoint = LeaveServicesMap + "/save-leave-application";

		String fromDate = Utils.getDate("dd-MM-yyyy",1);
		String toDate = Utils.getDate("dd-MM-yyyy",0);
		String reason = Utils.RandomStringLong();
		String durationTypeList[] = { "FULL_DAY", "HALF_DAY" };
		int durationType = new Random().nextInt(durationTypeList.length);

		body = new JSONObject();
		body.put("fromDate", fromDate);
		body.put("toDate", toDate);
		body.put("reason", reason);
		body.put("duration", durationTypeList[durationType]);
		if (durationTypeList[durationType].equals("HALF_DAY")) {
			String partialDayTypeList[] = { "START_DAY", "END_DAY" };
			int partialDayType = new Random().nextInt(partialDayTypeList.length);

			body.put("partialDay", partialDayTypeList[partialDayType]);
		}

		Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
	}

	public static void saveLeaveApplicationAdmin() throws Exception {
		String Endpoint = LeaveServicesMap + "/admin/save-leave-application";
		final int appUserId = getappUserIdbyEmail(getDev1_EmailID());
		int appliedLeaveAppId = getAppliedLeaveApplicationId(appUserId);
		String LeaveActionList[] = { "APPROVED", "REJECTED" };
		int LeaveAction = new Random().nextInt(LeaveActionList.length);
		String days = getLeaveApplicationDays(appUserId);
		int leaveTypeId = getLeaveTypeId(appUserId);
		int userLeaveInfoId = getUserLeaveInfoId(appUserId);
		String rejectedReason = Utils.RandomStringLong();

		body = new JSONObject();
		body.put("leaveAppId", appliedLeaveAppId);
		if (LeaveActionList[LeaveAction].equals("APPROVED")) {
			body.put("status", "APPROVED");

			JSONArray obj = new JSONArray();
			HashMap objMap = new HashMap();
			objMap.put("leaveTypeId", leaveTypeId);
			objMap.put("userLeaveInfoId", userLeaveInfoId);
			objMap.put("days", days);
			obj.put(objMap);

			body.put("userleaves", obj);
		} else if (LeaveActionList[LeaveAction].equals("REJECTED")) {
			body.put("status", "REJECTED");
			body.put("rejectedReason", rejectedReason);
		}

		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
	}

	public static void rejectingApprovedLeave() throws Exception {
		String Endpoint = LeaveServicesMap + "/admin/save-leave-application";
		final int appUserId = getappUserIdbyEmail(getDev1_EmailID());
		int approvedLeaveAppId = getApprovedLeaveApplicationId(appUserId);
		String rejectedReason = Utils.RandomStringLong();
		if (approvedLeaveAppId != 0) {
			body = new JSONObject();
			body.put("leaveAppId", approvedLeaveAppId);
			body.put("status", "REJECTED");
			body.put("rejectedReason", rejectedReason);

			Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		}
	}

	public static void cancelLeave() throws Exception {
		saveLeaveApplicationAdmin();
		String Endpoint = LeaveServicesMap + "/save-leave-application";
		final int appUserId = getappUserIdbyEmail(getDev1_EmailID());
		int appliedLeaveAppId = getAppliedLeaveApplicationId(appUserId);
		String rejectedReason = Utils.RandomStringLong();
		if (appliedLeaveAppId != 0) {
			body = new JSONObject();
			body.put("leaveAppId", appliedLeaveAppId);
			body.put("status", "CANCELLED");
			body.put("rejectedReason", rejectedReason);

			Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
		}
	}

	public static void getAllLeaveApplicationsByPageSearchString() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/get-all-leave-applications/0?searchStr";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
	}
	
	public static void getAllLeaveApplicationsByLeaveStatus() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/get-leave-applications";
		String LeaveStatusList[] = { "APPROVED", "REJECTED","CANCELLED","PENDING_APPROVAL"};
		int LeaveStatus = new Random().nextInt(LeaveStatusList.length);
		int page = 0;
		String search = "";
		
		body = new JSONObject();
		body.put("page", page);
		body.put("status", LeaveStatusList[LeaveStatus]);
		body.put("search", search);
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
	}
	
	public static void getAllLeaveApplication() throws Exception {
		String Endpoint = LeaveServicesMap+"/get-leave-applications";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
	}
	
	public static void getLeaveInfo() throws Exception {
		String Endpoint = LeaveServicesMap+"/get-user-leave-info";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
	}
	
	public static void getLeaveInfoAppUserId() throws Exception {
		String Endpoint = LeaveServicesMap+"/get-user-leave-info/"+getappUserIdbyEmail(getDev1_EmailID());
		String Endpoint2 = LeaveServicesMap+"/get-user-leave-info/"+getappUserIdbyEmail(getDev1_EmailID());
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint2, General_Services.PM2_Login());
	}
	
	public static void getLeaveTracker() throws Exception {
		String Endpoint = LeaveServicesMap+"/project-manager/get-leave-tracker/0?searchStr";
		
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
	}
	
	public static void configureleaves() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/configure-appuser-leave";
		ArrayList<Integer> leaveTypeIdList = getLeaveTypeIds();
		int index = new Random().nextInt(leaveTypeIdList.size());
		final int leaveTypeId = leaveTypeIdList.get(index);
		final int appUserId = getappUserIdbyEmail(getDev1_EmailID());
		final int allAppUserId = 0;
		String days = XMLObjects.getAdmin_Data("Admin_ConfigureLeaveDays");
		int Compoffdays = 1;
		int leavePeriod = Calendar.getInstance().get(Calendar.YEAR);
		String workedDate = Utils.getDate("dd-MM-yyyy",-1);
		String leaveTypeTitle = Global.getLeaveTypeTitle(leaveTypeId);
		
		body = new JSONObject();
		body.put("leaveTypeId", leaveTypeId);
		body.put("leavePeriod", leavePeriod);
		
		if (!leaveTypeTitle.contains("Compensation Off")) {
			body.put("appUserId", appUserId);
			body.put("days", days);
		}else {
			body.put("appUserId", appUserId);
			body.put("workedDate", workedDate);
			body.put("days", Compoffdays);
		}
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		if(allAppUserId==0) {
			if (!leaveTypeTitle.contains("Compensation Off")) {
				body.put("appUserId", allAppUserId);
				body.put("days", days);
			}else {
				body.put("appUserId", allAppUserId);
				body.put("workedDate", workedDate);
				body.put("days", Compoffdays);
			}
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		}
	}
	
	public static void saveHolidays() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/save-holidays";
		String holidayFor = Utils.RandomString();
		String holidayDate = Utils.getDate("dd-MM-yyyy",-1);
		boolean compensatoryList[] = { true, false};
		int compensatory = new Random().nextInt(compensatoryList.length);
		String correspondingWorkingDay = Utils.getDate("dd-MM-yyyy",-10);
		
		body = new JSONObject();
		body.put("holidayFor", holidayFor);
		body.put("holidayDate", holidayDate);
		body.put("compensatory", compensatoryList[compensatory]);
		if (compensatoryList[compensatory]==true) {
			body.put("correspondingWorkingDay", correspondingWorkingDay);
		}
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
	}
	
	public static void addLeaveType() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/add-leave-type";
		String leaveType = Utils.RandomString();
		
		body = new JSONObject();
		body.put("leaveType", leaveType);
		
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
	}
	
	public static void getHolidays() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/get-holidays";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
	}
	
	public static void deleteHolidays() throws Exception {
		saveHolidays();
		int holidayId = getHolidayId();
		String Endpoint = LeaveServicesMap+"/admin/delete-holidays/"+holidayId;
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
	}
	
	public static void getLeaveTypes() throws Exception {
		String Endpoint = LeaveServicesMap+"/admin/get-leave-type";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
	}
	
	public static void main(String[] args) throws Exception {
		getLeaveTypes();
	}

}
