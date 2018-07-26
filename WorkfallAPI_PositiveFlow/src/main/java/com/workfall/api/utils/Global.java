package com.workfall.api.utils;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONObject;

import com.workfall.api.database.Database_Connection;

public class Global {
	public static String X_Authorization;
	public static String failStatus ="FAILURE";
	public static String successStatus = "SUCCESS";
	public static String API_URL = ReadPropertyFileAPI.ReadFile("API_URL");
	public static String Admin_Email = ReadPropertyFileAPI.ReadFile("Admin_Email");
	public static String Admin_pswd = ReadPropertyFileAPI.ReadFile("Admin_pswd");
	public static String PO1_Email = ReadPropertyFileAPI.ReadFile("PO1_Email");
	public static String PO1_pswd = ReadPropertyFileAPI.ReadFile("PO1_pswd");
	public static String PO2_Email = ReadPropertyFileAPI.ReadFile("PO2_Email");
	public static String PO2_pswd = ReadPropertyFileAPI.ReadFile("PO2_pswd");
	public static String AdminMap= ReadPropertyFileAPI.ReadFile("AdminMap");
	public static String DeveloperMap=ReadPropertyFileAPI.ReadFile("DeveloperMap");
	public static String ProductOwnerMap = ReadPropertyFileAPI.ReadFile("ProductOwnerMap");
	public static String ProjectManagerMap = ReadPropertyFileAPI.ReadFile("ProjectManagerMap");
	public static String ProjectServicesMap = ReadPropertyFileAPI.ReadFile("ProjectServicesMap");
	public static String DMSServicesMap = ReadPropertyFileAPI.ReadFile("DMSServicesMap");
	
	public static String Global_IntCallingCode = "+91";
	public static String Global_iso2 = "in";
	public static String countryName = "India";
	public static String countryId = "103";
	public static String Global_password = "12345678";
	public static String Change_password = "1234567890";
	public static String activeFalse = "false";
	public static String activeTrue = "true";
	public static JSONObject body = new JSONObject();
	
	// JDBC driver name and database URL
	public static String JDBC_DRIVER = ReadPropertyFileAPI.ReadFile("JDBC_DRIVER");
	public static String DB_URL = ReadPropertyFileAPI.ReadFile("DB_URL");

	// Database credentials
	public static String DB_USERNAME = ReadPropertyFileAPI.ReadFile("DB_USERNAME");
	public static String DB_PASSWORD = ReadPropertyFileAPI.ReadFile("DB_PASSWORD");
	
	
	public static JSONObject Admin_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", Admin_Email);
		ad.put("password", Admin_pswd);
		return ad;
	}
	public static JSONObject PM1_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", getPM1_EmailID());
		ad.put("password", PO1_pswd);
		return ad;
	}
	public static JSONObject PM2_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", getPM2_EmailID());
		ad.put("password", Global_password);
		return ad;
	}
	public static JSONObject PO1_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", PO1_Email);
		ad.put("password", PO1_pswd);
		return ad;
	}
	public static JSONObject PO2_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", PO2_Email);
		ad.put("password", PO2_pswd);
		return ad;
	}
	public static JSONObject Dev1_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", getDev1_EmailID());
		ad.put("password", PO1_pswd);
		return ad;
	}
	public static JSONObject Dev2_Loginbody() throws Exception {
		JSONObject ad = new JSONObject();
		ad.put("email", getDev2_EmailID());
		ad.put("password", PO1_pswd);
		return ad;
	}
	
	public static void makeAllVerificationsTrue() throws Exception{
		String query = "UPDATE app_user SET is_email_verified = 'TRUE', is_mobile_verified = 'TRUE'";
		Database_Connection.Database_executeUpdate(query);
	}
	public static ArrayList<String> getMobileNumbers() throws Exception{
		String query = "select mobile_number from app_user";

		ResultSet resultSet = Database_Connection.Database_executeQuery(query);

		ArrayList<String> mobileNumbersList = new ArrayList<String>();
		while (resultSet.next()) {
			String mobileNumber = resultSet.getString("mobile_number");
			mobileNumbersList.add(mobileNumber);
		}
		return mobileNumbersList;
	}
	public static ArrayList<String> getEmails() throws Exception{
		String query = "select email from app_user";

		ResultSet resultSet = Database_Connection.Database_executeQuery(query);

		ArrayList<String> emailList = new ArrayList<String>();
		while (resultSet.next()) {
			String email = resultSet.getString("email");
			emailList.add(email);
		}
		return emailList;
	}
	public static ArrayList<Integer> getAppUserIds() throws Exception{
		String query = "select id from app_user";

		ResultSet resultSet = Database_Connection.Database_executeQuery(query);

		ArrayList<Integer> appUserIdsList = new ArrayList<Integer>();
		while (resultSet.next()) {
			int appUserId = resultSet.getInt("id");
			appUserIdsList.add(appUserId);
		}
		return appUserIdsList;
	}
	public static String getEmailConfirmationKey(String EmailId) throws Exception {
		String ConfirmationKey = "";
		String query = "select email_confirmation_key from app_user  where email = " + "'"+EmailId+"'";

		ResultSet resultSet = Database_Connection.Database_executeQuery(query);

		while (resultSet.next()) {
			ConfirmationKey = resultSet.getString("email_confirmation_key");
		}
		if (ConfirmationKey == null) {
			Output.OutputConsoleForDatabase(">>>>>>> No ConfirmationKey Found with the Given Data <<<<<<<");
		}
		return ConfirmationKey;
	}
	public static int getappUserIdbyEmail(String EmailId) throws Exception {
		String query = "select id from app_user  where email  = "+"'"+EmailId+"'";
		int appUserId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			appUserId = resultSet.getInt("id");
		}
		if (appUserId == 0) {
			Output.OutputConsoleForDatabase(">>>>>>> No AppUser Found with Given Data <<<<<<<");
		}
		return appUserId;
	}
	public static String getPM1_EmailID() throws Exception{
		String query = "select email from app_user where role = 'PROJECT_MANAGER' order by id desc limit 1";
		String PM1_Email = "";
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			PM1_Email = resultSet.getString("email");
		}
		if (PM1_Email == null) {
			Output.OutputConsoleForDatabase(">>>>>>> No ProjectManager Found with Given Data <<<<<<<");
		}
		return PM1_Email;
	}
	public static String getPM2_EmailID() throws Exception{
		String query = "select email from app_user where role = 'PROJECT_MANAGER' order by id desc limit 2";
		String PM2_Email = "";
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			PM2_Email = resultSet.getString("email");
		}
		if (PM2_Email == null) {
			Output.OutputConsoleForDatabase(">>>>>>> No ProjectManager Found with Given Data <<<<<<<");
		}
		return PM2_Email;
	}
	public static String getDev1_EmailID()throws Exception{
		String query = "select email from app_user where role = 'DEVELOPER' order by id desc limit 1";
		String Dev1_Email = "";
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			Dev1_Email = resultSet.getString("email");
		}
		if (Dev1_Email==null) {
			Output.OutputConsoleForDatabase(">>>>>>> No Developer Found with Given Data <<<<<<<");
		}
		return Dev1_Email;	
	}
	public static String getDev2_EmailID()throws Exception{
		String query = "select email from app_user where role = 'DEVELOPER' order by id desc limit 2";
		String Dev2_Email = "";
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			Dev2_Email = resultSet.getString("email");
		}
		if (Dev2_Email==null) {
			Output.OutputConsoleForDatabase(">>>>>>> No Developer Found with Given Data <<<<<<<");
		}
		return Dev2_Email;	
	}
	public static int getSkillId() throws Exception{
		String query = "SELECT id from skill WHERE is_active = 'TRUE' ORDER BY id DESC LIMIT 1";
		int SkillId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			SkillId = resultSet.getInt("id");
		}
		if (SkillId==0) {
			Output.OutputConsoleForDatabase(">>>>>>> No ProjectLead Id Found <<<<<<<");
		}
		return SkillId;	
	}
	public static int getProjectLeadId() throws Exception{
		String query = "SELECT id FROM project_lead ORDER BY id DESC LIMIT 1";
		int ProjectLeadId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			ProjectLeadId = resultSet.getInt("id");
		}
		if (ProjectLeadId==0) {
			Output.OutputConsoleForDatabase(">>>>>>> No ProjectLead Id Found <<<<<<<");
		}
		return ProjectLeadId;	
	}
	public static int getprojectProposalId() throws Exception{
		String query = "select id from project_proposal where project_lead_id = "+"'"+getProjectLeadId()+"'"+"ORDER BY id DESC LIMIT 1";
		int projectProposalId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			projectProposalId = resultSet.getInt("id");
			 if (projectProposalId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No Project Proposal Found with the given ProjectLead Id <<<<<<<");	
			 }
	}
		return projectProposalId;	
	}
	public static int getProjectManagerId() throws Exception{
		String query = "SELECT id FROM app_user where role = 'PROJECT_MANAGER' and is_active = 'TRUE' and is_email_verified = 'TRUE' and is_mobile_verified = 'TRUE' ORDER BY id DESC LIMIT 1";
		int appuserID = 0;
		int managerid = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			appuserID = resultSet.getInt("id");
		}
		if (appuserID==0) {
			Output.OutputConsoleForDatabase(">>>>>>> No Project Manager Found <<<<<<<");
		}if (appuserID!=0) {
			String query2 = "select id from project_manager ORDER BY id DESC LIMIT 1";
			
			ResultSet resultSet2 = Database_Connection.Database_executeQuery(query2);
			while (resultSet2.next()) {
				 managerid = resultSet2.getInt("id");
			}
		}
		return managerid;
	}
	public static int getAppUserIdWithManagerId() throws Exception{
		String query = "select app_user_id from project_manager where id = "+"'"+getProjectManagerId()+"'";
		int appUserId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			appUserId = resultSet.getInt("app_user_id");
			 if (appUserId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No AppUser Found with the given ProjectManagerId <<<<<<<");	
			 }
	}
		return appUserId;	
	}
	public static int getAppUserIdWithDeveloperId() throws Exception{
		String query = "select app_user_id from developer where id = "+"'"+getdeveloperId()+"'";
		int appUserId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			appUserId = resultSet.getInt("app_user_id");
			 if (appUserId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No Project Proposal Found with the given ProjectLead Id <<<<<<<");	
			 }
	}
		return appUserId;
	}
	public static int getepicId() throws Exception{
		String query = "select id from epic where project_proposal_id = "+"'"+getprojectProposalId()+"'"+" ORDER BY id DESC LIMIT 1";
		int epicId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			epicId = resultSet.getInt("id");
			 if (epicId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No Epic Found with the given Project Proposal Id <<<<<<<");	
		}
	}
		return epicId;	
	}
	public static ArrayList<Integer> getEpicIds()throws Exception{	
		String query = "select id from epic where milestone_id = "+"'"+getMilestoneIdUnAssignedEpics()+"'";

		ResultSet resultSet = Database_Connection.Database_executeQuery(query);

		ArrayList<Integer> appUserIdsList = new ArrayList<Integer>();
		while (resultSet.next()) {
			int appUserId = resultSet.getInt("id");
			appUserIdsList.add(appUserId);
		}
		return appUserIdsList;
	}
	public static int getMilestoneId() throws Exception{
		String query = "select id from milestone where project_proposal_id = "+"'"+getprojectProposalId()+"'"+ " and milestone_status = 'REGULAR_EPICS' ORDER BY id DESC LIMIT 1";
		int milestoneId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			milestoneId = resultSet.getInt("id");
			 if (milestoneId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No MilestoneId Found with the given Project Proposal Id <<<<<<<");	
		}
	}
		return milestoneId;	
	}
	public static int getMilestoneIdUnAssignedEpics() throws Exception{
		String query = "select id from milestone where project_proposal_id = "+"'"+getprojectProposalId()+"'"+ " and milestone_status = 'UNASSIGNED_EPICS' ORDER BY id DESC LIMIT 1";
		int milestoneId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			milestoneId = resultSet.getInt("id");
			 if (milestoneId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No MilestoneId Found with the given Project Proposal Id <<<<<<<");	
		}
	}
		return milestoneId;	
	}
	public static ArrayList<Integer> getMilestoneCount() throws Exception {
		String query = "select id from milestone  where project_proposal_id  = "+"'"+getprojectProposalId()+"'"+ " and milestone_status = 'REGULAR_EPICS'";
		int milestoneCount = 0;
		ArrayList<Integer> milestoneCountList = new ArrayList<Integer>();
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			milestoneCount = resultSet.getInt("id");
			 if (milestoneCount==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No MilestoneId Found with the given Project Proposal Id <<<<<<<");	
		}
			 milestoneCountList.add(milestoneCount);
	}
		return milestoneCountList;	
	}
	public static int getAgreementId() throws Exception{
		String query = "select id from agreement where project_proposal_id = "+"'"+getprojectProposalId()+"'"+ " ORDER BY id DESC LIMIT 1";
		int agreementId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			agreementId = resultSet.getInt("id");
			 if (agreementId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No AgreementId Found with the given Project Proposal Id <<<<<<<");	
		}
	}
		return agreementId;
	}

	public static int getProjectId() throws Exception {
		String query = "select id from project where project_lead_id  = " + "'" + getProjectLeadId() + "'"+ " ORDER BY id DESC LIMIT 1";
		int projectId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			projectId = resultSet.getInt("id");
			if (projectId == 0) 
			{
				Output.OutputConsoleForDatabase(">>>>>>> No ProjectId Found with the given ProjectLead Id <<<<<<<");
			}
		}
		return projectId;
	}
	public static int getUserstoryId() throws Exception{
		String query = "select id from user_story where project_proposal_id  = "+"'"+getprojectProposalId()+"'"+" and epic_id = "+"'"+getepicId()+"'"+" ORDER BY id DESC LIMIT 1";
		int userstoryId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			userstoryId = resultSet.getInt("id");
			 if (userstoryId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No UserstoryId Found with the given Project ProposalId and EpicId <<<<<<<");	
		}
	}
		return userstoryId;
	}
	public static int getTaskId() throws Exception{
		String query = "select id from task where project_id = "+"'"+getProjectId()+"'"+" and epic_id = "+"'"+getepicId()+"'"+" ORDER BY id DESC LIMIT 1";
		int taskId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			taskId = resultSet.getInt("id");
			 if (taskId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No TaskID Found with the given ProjectId and EpicId <<<<<<<");	
		}
	}
		return taskId;	
	}
	public static int getTestScenarioId() throws Exception{
		//String query1 = "select id from test_execution_run where epic_id = "+"'"+getepicId()+"'"+" ORDER BY id DESC LIMIT 1";
		String query = "select id from test_scenario where project_id = "+"'"+getProjectId()+"'"+" ORDER BY id DESC LIMIT 1";
		int TestScenarioId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			TestScenarioId = resultSet.getInt("id");
			 if (TestScenarioId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No TestScenarioId Found with the given ProjectId <<<<<<<");	
		}
	}	
		return TestScenarioId;	
	}
	public static int getTestExecutionRunId() throws Exception{
		String query = "select id from test_execution_run where epic_id = "+"'"+getepicId()+"'"+" ORDER BY id DESC LIMIT 1";
		int testExecutionRunId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			testExecutionRunId = resultSet.getInt("id");
			 if (testExecutionRunId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No TestExecutionRunId Found with the given EpicID <<<<<<<");	
		}
	}
		return testExecutionRunId;
	}
	public static int getTestCaseId() throws Exception{
		String query = "select id from test_case where epic_id = "+"'"+getepicId()+"'"+" and user_story_id = "+"'"+getUserstoryId()+"'"+" ORDER BY id DESC LIMIT 1";
		int testCaseId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			testCaseId = resultSet.getInt("id");
			 if (testCaseId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No TestCaseId Found with the given EpicId and UserStoryId <<<<<<<");	
		}
	}
		return testCaseId;	
	}
	
	public static int getdefectLabelId() throws Exception{
		String query = "select id from defect_label where project_id = "+"'"+getProjectId()+"'"+" ORDER BY id DESC LIMIT 1";
		int defectLabelId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			defectLabelId = resultSet.getInt("id");
			 if (defectLabelId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No TestCaseId Found with the given EpicId and UserStoryId <<<<<<<");	
		}
	}
		return defectLabelId;	
	}
	public static int getQADefectId() throws Exception{
		String query = "SELECT id FROM defect WHERE project_id = "+"'"+getProjectId()+"'"+" AND defect_type = 'QA' ORDER by id DESC LIMIT 1";
		int QADefectId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			QADefectId = resultSet.getInt("id");
			 if (QADefectId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No UATDefectId Found with the given ProjectId <<<<<<<");	
		}
	}
		return QADefectId;	
	}	
	public static int getUATDefectId() throws Exception{
		String query = "SELECT id FROM defect WHERE project_id = "+"'"+getProjectId()+"'"+" AND defect_type = 'UAT' ORDER by id DESC LIMIT 1";
		int UATDefectId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			UATDefectId = resultSet.getInt("id");
			 if (UATDefectId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No UATDefectId Found with the given ProjectId <<<<<<<");	
		}
	}
		return UATDefectId;	
	}	
	public static int getdeveloperId() throws Exception{
		String query = "select id from app_user where email = " + "'" + getDev1_EmailID() + "'";
		int appuserID = 0;
		int DeveloloperID = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			appuserID = resultSet.getInt("id");
		}
		if (appuserID == 0) {
			Output.OutputConsoleForDatabase(">>>>>>> No AppUser Found with the given EmailId <<<<<<<");
		}
		if (appuserID != 0) {
			String query2 = "select id from developer where app_user_id = " + "'" + appuserID + "'";
			ResultSet resultSet2 = Database_Connection.Database_executeQuery(query2);
			while (resultSet2.next()) {
				DeveloloperID = resultSet2.getInt("id");
			}
		}
		return DeveloloperID;
	}
	public static int getDevelopersInProjectForAssign() throws Exception{
		String query = "select developer_id from developer_project_info where project_id = " + "'" + getProjectId()
				+ "'" + " ORDER BY id DESC LIMIT 1";
		int DevelolopersInProject = 0;
		int appuserID = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			DevelolopersInProject = resultSet.getInt("developer_id");
		}
		if (DevelolopersInProject == 0) {
			Output.OutputConsoleForDatabase(">>>>>>> No Developers Found with the given ProjectId <<<<<<<");
		}
		if (DevelolopersInProject != 0) {
			String query2 = "select app_user_id from developer where id = " + "'" + DevelolopersInProject + "'";
			ResultSet resultSet2 = Database_Connection.Database_executeQuery(query2);
			while (resultSet2.next()) {
				appuserID = resultSet2.getInt("app_user_id");
			}
		}
		return appuserID;
	}
	public static int getProjectDriveId() throws Exception{
		String query = "SELECT id from drive_entity where project_id = "+"'"+getProjectId()+"'" + " ORDER BY id DESC LIMIT 1";
		int DriveId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			DriveId = resultSet.getInt("id");
			 if (DriveId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No DriveId Found with the given ProjectId <<<<<<<");	
		}
	}	
		return DriveId;
	}
	public static int getClientDriveId() throws Exception{
		String query = "SELECT id from drive_entity where project_id = "+"'"+getProjectId()+"'" + " ORDER BY id DESC LIMIT 1";
		int DriveId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			DriveId = resultSet.getInt("id");
			 if (DriveId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No DriveId Found with the given ProjectId <<<<<<<");	
		}
	}	
		return DriveId;
	}
	public static int getFolderIdFromProjectDrive() throws Exception{
		String query = "select folder_entity_id from drive_entity_folder_entity  where drive_entity_id = "+"'"+getProjectDriveId()+"'";
		int FolderId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			FolderId = resultSet.getInt("folder_entity_id");
			 if (FolderId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No FolderId Found with the given DriveId <<<<<<<");	
		}
	}	
		return FolderId;
	}
	public static int getFolderIdFromClientDrive() throws Exception{
		String query = "select folder_entity_id from drive_entity_folder_entity  where drive_entity_id = "+"'"+getClientDriveId()+"'";
		int FolderId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			FolderId = resultSet.getInt("folder_entity_id");
			 if (FolderId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No FolderId Found with the given DriveId <<<<<<<");	
		}
	}	
		return FolderId;
	}
	
	public static int getAppliedLeaveApplicationId(int user) throws Exception{
		String query = "select id from leave_application  where app_user_id  = "+user+"and status = 'PENDING_APPROVAL' order by id desc limit 1";
		int LeaveAppId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			LeaveAppId = resultSet.getInt("id");
			 if (LeaveAppId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No AppliedLeaveApplicationId Found with the given data <<<<<<<");	
		}
	}	
		return LeaveAppId;
	}
	
	public static int getUserLeaveInfoId(int user) throws Exception{
		String query = "select id from app_user_leave_info  where app_user_id = "+user+"and days_added-days_used is not null order by id desc limit 1";
		int UserLeaveInfoId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			UserLeaveInfoId = resultSet.getInt("id");
			 if (UserLeaveInfoId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No UserLeaveInfoId Found with the given data <<<<<<<");	
		}
	}	
		return UserLeaveInfoId;
	}
	
	public static String getLeaveApplicationDays(int user) throws Exception{
		String query = "select days from leave_application where app_user_id  = "+user+" and status = 'PENDING_APPROVAL' order by id desc limit 1";
		String Days = "";
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			Days = resultSet.getString("days");
			 if (Days.equals(null)) {
					Output.OutputConsoleForDatabase(">>>>>>> No LeaveApplicationDays Found with the given data <<<<<<<");	
		}
	}	
		return Days;
	}
	public static int getLeaveTypeId(int user) throws Exception{
		String query = "select leave_type_id from app_user_leave_info  where app_user_id = "+user+" and (days_added-days_used >= "+getLeaveApplicationDays(user)+") order by id desc limit 1";
		int LeaveTypeId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			LeaveTypeId = resultSet.getInt("leave_type_id");
			 if (LeaveTypeId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No LeaveTypeId Found with the given data <<<<<<<");	
		}
	}	
		return LeaveTypeId;
	}
	
	public static int getApprovedLeaveApplicationId(int user) throws Exception{
		String query = "select id from leave_application  where app_user_id  = "+user+"and status = 'APPROVED' order by id desc limit 1";
		int LeaveAppId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			LeaveAppId = resultSet.getInt("id");
			 if (LeaveAppId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No ApprovedLeaveApplicationId Found with the given data <<<<<<<");	
		}
	}	
		return LeaveAppId;
	}
	
	public static ArrayList<Integer> getLeaveTypeIds() throws Exception{
		String query = "select id,leave_type_title from leave_type";

		ResultSet resultSet = Database_Connection.Database_executeQuery(query);

		ArrayList<Integer> leaveTypeIdList = new ArrayList<Integer>();
		while (resultSet.next()) {
			int leaveTypeId = resultSet.getInt("id");
			
			leaveTypeIdList.add(leaveTypeId);
		}
		return leaveTypeIdList;
	}
	public static String getLeaveTypeTitle(int typeId) throws Exception{
		String query = "select leave_type_title from leave_type  where id =  "+typeId;
		String leaveTypeTitle = "";
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			leaveTypeTitle = resultSet.getString("leave_type_title");
			 if (leaveTypeTitle.equals(null)) {
					Output.OutputConsoleForDatabase(">>>>>>> No LeaveTypeTitle Found with the given data <<<<<<<");	
		}
	}	
		return leaveTypeTitle;
	}
	
	public static int getHolidayId() throws Exception{
		String query = "select id from holiday order by id desc limit 1";
		int holidayId = 0;
		ResultSet resultSet = Database_Connection.Database_executeQuery(query);
		while (resultSet.next()) {
			holidayId = resultSet.getInt("id");
			 if (holidayId==0) {
					Output.OutputConsoleForDatabase(">>>>>>> No holidayId Found with the given data <<<<<<<");	
		}
	}	
		return holidayId;
	}
	public static class mainclass{
		public static void main(String[] args) throws Exception {
			getLeaveTypeTitle(7);
	}
	
	}
}
	
