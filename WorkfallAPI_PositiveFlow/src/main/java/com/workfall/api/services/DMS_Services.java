package com.workfall.api.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.workfall.api.requests.Response;
import com.workfall.api.utils.Global;
import com.workfall.api.utils.Output;
import com.workfall.api.utils.Utils;

public class DMS_Services extends Global{
	
	public static void createDrive() throws Exception{
		String Endpoint = DMSServicesMap+getProjectId()+"/create-drive";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
	}
	public static void getDrives() throws Exception{
		String Endpoint = DMSServicesMap+getProjectId()+"/po-pm-admin/get-drives";
		
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
	}
	public static void createOrUpdateFolderProjectDrive() throws Exception{
		
			String Endpoint = DMSServicesMap+getProjectId()+"/dev/create-or-update-folder";
			
			String description = Utils.RandomStringLong();
			int driveId = getProjectDriveId();
			
			body = new JSONObject();
			body.put("description", description);
			body.put("driveId", driveId);
			
			body.put("folderName",  Utils.RandomString());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
			body.put("folderName",  Utils.RandomString());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PM2_Login());
			body.put("folderName",  Utils.RandomString());
			Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
			body.put("folderName",  Utils.RandomString());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
			body.put("folderName",  Utils.RandomString());
			Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
			
	}
	public static void createOrUpdateFolderClientDrive() throws Exception{
		
		String Endpoint = DMSServicesMap+getProjectId()+"/dev/create-or-update-folder";
		
		String description = Utils.RandomStringLong();
		int driveId = getClientDriveId();
		
		body = new JSONObject();
		body.put("description", description);
		body.put("driveId", driveId);
		
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM2_Login());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO2_Login());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
			
}
	public static void CreateFolderInsideFolder() throws Exception{
		String Endpoint = DMSServicesMap + getProjectId() + "/dev/create-or-update-folder";

		String folderId = "";
		int parentFolderId = getFolderIdFromProjectDrive();
		String description = Utils.RandomStringLong();

		body = new JSONObject();
		body.put("parentFolderId", parentFolderId);
		body.put("description", description);
		
		body.put("driveId", getProjectDriveId());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
		body.put("driveId", getProjectDriveId());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM2_Login());
		body.put("driveId", getProjectDriveId());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		body.put("driveId", getProjectDriveId());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
		body.put("driveId", getProjectDriveId());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
		Output.OutputConsole("										############Creating Folder in Client Drive############");
		body.put("driveId", getClientDriveId());
		body.put("folderName",  Utils.RandomString());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
	}
	public static void getDataFromProjectFolder() throws Exception{
		String Endpoint = DMSServicesMap + getProjectId() + "/dev/get-data?type=FOLDER&id="+getFolderIdFromProjectDrive();
		
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM2_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
	}
	public static void getFolders() throws Exception{
		String Endpoint = DMSServicesMap + getProjectId() +"/dev/get-folders";
		
		Response.OutputResponse_Get(Endpoint, General_Services.PM1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PM2_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Admin_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO1_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.PO2_Login());
		Response.OutputResponse_Get(Endpoint, General_Services.Dev1_Login());
	}
	public static void shareFolder() throws Exception{
		String Endpoint = DMSServicesMap + getProjectId() + "/po-pm-admin/share-folder";
		
		int driveId = getProjectDriveId();
		int id = getFolderIdFromProjectDrive();
		
		JSONArray appUserIdArray = new JSONArray();
		appUserIdArray.put(getDevelopersInProjectForAssign());
		
		body=new JSONObject();
		body.put("driveId", driveId);
		body.put("id", id);
		body.put("toShareIds", appUserIdArray);
		
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PM2_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
		Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
	}
	public static void deleteFolderFromClientDrive() throws Exception{
			String Endpoint = DMSServicesMap + getProjectId() + "/po-pm-admin/delete-folder";
			int driveId = getClientDriveId();
			int folderId = getFolderIdFromClientDrive();
			String parentFolderId = "";

			body = new JSONObject();
			body.put("driveId", driveId);
			body.put("folderId", folderId);
			body.put("parentFolderId", parentFolderId);

			Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PM2_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());
			
	}
	public static void deleteFolderFromProjectDrive() throws Exception{
			String Endpoint = DMSServicesMap + getProjectId() + "/po-pm-admin/delete-folder";
			int driveId = getProjectDriveId();
			int folderId = getFolderIdFromProjectDrive();
			String parentFolderId = "";

			body = new JSONObject();
			body.put("driveId", driveId);
			body.put("folderId", folderId);
			body.put("parentFolderId", parentFolderId);

			Response.OutputResponse_Post(Endpoint, body, General_Services.PM1_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PM2_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.Admin_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.PO1_Login());
			Response.OutputResponse_Post(Endpoint, body, General_Services.Dev1_Login());

	}
	public static void main(String[] args) throws Exception {
		getFolders();
	}
}
