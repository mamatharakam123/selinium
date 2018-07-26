package e2logtest.e2logtest;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Global {
	public static WebDriver driver;
	/*
	 * static String extentReportFile =
	 * System.getProperty("/home/thrymr/Desktop/") + "extentReportFile.html";
	 * String extentReportImage = System.getProperty("/home/thrymr/Desktop/") +
	 * "\\extentReportImage.png";
	 */
	public static ExtentReports report =new ExtentReports(System.getProperty("user.dir") + "ReportFile.html", true);
	public static ExtentTest logger;
	
	public static String extentReportFile = System.getProperty("user.dir") + "ReportFile.html";
	public static ExtentReports extent = new ExtentReports(extentReportFile, true);

	public static void pub(String filePath) {
		// TODO Auto-generated method stub
		
		
	}
}
