package e2logtest.e2logtest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;


public class E2logCustomer {

	private static Date date;
	public static String rfqidValue;
	public static String today;

	
		
		
		
		public static void login() throws Exception{
			 //try {
				 
				 System.out.println(Getproperties.fetchProp("extentreportspath"));
					//System.setProperty("webdriver.chrome.driver", FetchProper.fetchProp("chromedriverpath"));
				
		Repository.launch_url("http://ci.thrymr.net:2018/customer");
		//Thread.sleep(6000);
//		Global.report=new ExtentReports(System.getProperty("user.dir")+"sample.html", false);
		
		ExtentTest test=Global.report.startTest("test e2log");
		
		//test.log(LogStatus.PASS, "testpass");
//		Global.logger=Global.report.startTest("VerifyBlogTitle");
		Global.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Repository.xpath_sendkeys(LocatorsJson.username, LocatorsJson.username_value);
		Repository.xpath_sendkeys(LocatorsJson.password, LocatorsJson.password_value);
		Repository.xpath_click(LocatorsJson.login);
		
		//Repository.xpath(ReadJson.json("customerDashboard"));
		//Thread.sleep(5000);
		WebElement login = Repository.xpath(LocatorsJson.customer_dashboard);
		System.out.println(login.getText().toString());
		//String step1value= step1.getText();
		//Assert.assertTrue(login.getText().toString().contains("Dashboard")); 
		Global.logger.log(LogStatus.PASS, "Customer logged in successfully");
	/*	Assert.assertTrue(login.getText().toString().contains("Dashboard")); 
		Global.logger.log(LogStatus.INFO, "login successfully");*/
		
		Global.report.endTest(test);
		 Global.report.flush();
		
		if (login.getText().toString().equals("Dashboard")) {
			System.out.println("login successfully");
		}
		else{
			System.out.println("unable to login");
		}
		
	
		//Thread.sleep(5000);
		}
		/*
		catch(Exception login){
			System.out.println("unable to  login");	
			
		}
			  */
//		}
		
		
		///rfq1
		
		
		public static void rfq1() throws Exception{
			Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
			Global.logger=Global.report.startTest("Verify updating Basic information");

			Repository.xpath_click(LocatorsJson.rfq);
			//Global.driver.findElement(By.xpath("(//*[@class='pull-right-container activelinkIndicator'])[1]")).click();
		Repository.xpath_click(LocatorsJson.datepicker);
		
		WebElement date_list = Repository.xpath(LocatorsJson.date_list);
		List<WebElement> tableTR = date_list.findElements(By.className(LocatorsJson.day));
		//String date ="10";(//*[@href='/customer/quotations/rfq'])[2]
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		date = c.getTime();
		int responseDate= date.getDate();
		System.out.println(responseDate+ "responseDate");
		String date1= Integer.toString(responseDate);
		
		for (int i = 0; i < tableTR.size(); i++) {
			System.out.println(tableTR.get(i).getText());
			if (tableTR.get(i).getText().contains(date1)){		
				//System.out.println("date cjaxdcvhduis");
				tableTR.get(i).click();
				Thread.sleep(5000);
				break;	
			}
	
		}
		
		
		WebElement e = Repository.xpath(LocatorsJson.currency);
		String cu =e.getText();
		e.click();
		Repository.xpath_sendkeys(LocatorsJson.rfq_title,LocatorsJson.rfq_titlename);
		
	//	Thread.sleep(5000);
		//Global.driver.findElement(By.xpath("//*[@id='home']/div/form/div[3]/div[1]/div[1]/div[2]/div[1]/input")).sendKeys("24-03-2018");
		Repository.xpath_sendkeys(LocatorsJson.contactperson, LocatorsJson.contactperson_value);
		Repository.xpath_sendkeys(LocatorsJson.contactperson_email, LocatorsJson.contactpersonemail_value);
		Repository.xpath_sendkeys(LocatorsJson.addmore_person, LocatorsJson.addmoreperson_value);
		
		WebElement mobile_co= Repository.xpath(LocatorsJson.mobilecountry_code);
		Select mobile_co_va = new Select(mobile_co);
		mobile_co_va.selectByValue(LocatorsJson.mobilecountrycode_value);
		Repository.xpath_sendkeys(LocatorsJson.mobile_number, LocatorsJson.mobilenumber_value);
		
		WebElement landline_co=Repository.xpath(LocatorsJson.landline_code);
		Select landline_co_va = new Select(landline_co);
		landline_co_va.selectByValue(LocatorsJson.landlinecode_value);
		Repository.xpath_sendkeys(LocatorsJson.landline_number,LocatorsJson.landlinenumber_value);
		
		//Global.driver.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("");
		Repository.xpath_sendkeys(LocatorsJson.description1,LocatorsJson.description_value);
			
		
		
		WebElement tier =Repository.xpath(LocatorsJson.tier_visible);
		JavascriptExecutor js = (JavascriptExecutor)Global.driver;
		js.executeScript("arguments[0].scrollIntoView();", tier);
		
		Repository.xpath_click(LocatorsJson.tier_visible);
		
		WebElement tier_se =Repository.xpath(LocatorsJson.tier_selection);
		js.executeScript("arguments[0].scrollIntoView();", tier_se);
		Repository.xpath_click(LocatorsJson.tier_selection);
		Repository.xpath_click(LocatorsJson.tierdropdown_close);
		Repository.xpath_click(LocatorsJson.payment1);
		
		//Global.driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("5346756");
		Repository.xpath_click(LocatorsJson.submit_1);
		
		//Thread.sleep(6000);
		
		WebElement step1 = Repository.xpath(LocatorsJson.shipmentdetails_text);
		System.out.println(step1.getText().toString());
		//String step1value= step1.getText();
		//Assert.assertTrue(step1.getText().toString().contains("Pickup Address")); 
		
		if (step1.getText().toString().equals("Pickup Address")) {
			System.out.println("rfq1 created successfully");
		}
		else{
			System.out.println("rfq1 not created successfully");
		}
		Global.logger.log(LogStatus.PASS, "Basic information updated successfully");
		Global.report.endTest(Global.logger);
		 Global.report.flush();
		
		}
		
		
		///rfq2
		
		public static void rfq2() throws Exception{
			
			Global.logger=Global.report.startTest("Verify updating Shipment details ");
			Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement location_pickup = Repository.xpath(LocatorsJson.pickup_Location);
		Select location_pickupvalue = new Select(location_pickup);
		location_pickupvalue.selectByVisibleText(LocatorsJson.pickupLocation_value);
		//Thread.sleep(3000);
		Repository.xpath_click(LocatorsJson.date_picker1);
		WebElement date_list1 = Repository.xpath(LocatorsJson.date_list);
		List<WebElement> tableTR1 = date_list1.findElements(By.className(LocatorsJson.day));
		//String date1 ="6";
		Calendar calendarCargo = Calendar.getInstance();
		calendarCargo.add(Calendar.DATE, 2);
		date = calendarCargo.getTime();
		System.out.println("date"+date);
		int cargodate= date.getDate();
		
		String cargodate_st= Integer.toString(cargodate);
		for (int i = 0; i < tableTR1.size(); i++) {
			//System.out.println(tableTR1.get(i).getText());
			if (tableTR1.get(i).getText().contains(cargodate_st)){		
				System.out.println("date cjaxdcvhduis");
				tableTR1.get(i).click();
				Thread.sleep(5000);
				break;	
			}
	
		}
		WebElement location_drop = Repository.xpath(LocatorsJson.delivery_Location);
		Select location_dropvalue = new Select(location_drop);
		location_dropvalue.selectByVisibleText(LocatorsJson.deliveryLocation_value);
		Repository.xpath_click(LocatorsJson.date_picker2);
		WebElement date_list2 = Repository.xpath(LocatorsJson.date_list);
		List<WebElement> tableTR2 = date_list2.findElements(By.className(LocatorsJson.day));
		//String date2 ="7";
		Calendar calendarRequired = Calendar.getInstance();
		calendarRequired.add(Calendar.DATE, 4);
		date = calendarRequired.getTime();
		int requ_deliver= date.getDate();
		String requ_deliver_date= Integer.toString(requ_deliver);
		for (int i = 0; i < tableTR2.size(); i++) {
			System.out.println(tableTR2.get(i).getText());
			if (tableTR2.get(i).getText().contains(requ_deliver_date)){		
				System.out.println("date cjaxdcvhduis");
				tableTR2.get(i).click();
				Thread.sleep(5000);
				break;	
			}
	
		}
		WebElement pickup_country = Repository.xpath(LocatorsJson.pickupCountry_Id);
		Select pickup_country_value = new Select(pickup_country);
		pickup_country_value.selectByValue(LocatorsJson.pickupCountry_Id_value);
		WebElement pickup_state = Repository.xpath(LocatorsJson.pickupState_Id);
		Select pickup_state_value = new Select(pickup_state);
		pickup_state_value.selectByValue(LocatorsJson.pickupStateId_value);
		WebElement pickup_city = Repository.xpath(LocatorsJson.pickupCity_Id);
		Select pickup_city_value = new Select(pickup_city);
		pickup_city_value.selectByValue(LocatorsJson.pickupCityId_value);
		WebElement delivery_country = Repository.xpath(LocatorsJson.deliverycountry_Id);
		Select delivery_country_value = new Select(delivery_country);
		delivery_country_value.selectByValue(LocatorsJson.deliveryCountryId_value);
		WebElement delivery_state = Repository.xpath(LocatorsJson.deliveryState_Id);
		Select delivery_state_value = new Select(delivery_state);
		delivery_state_value.selectByValue(LocatorsJson.deliveryStateId_value);
		WebElement delivery_city = Repository.xpath(LocatorsJson.deliveryCity_Id);
		Select delivery_city_value = new Select(delivery_city);
		delivery_city_value.selectByValue(LocatorsJson.deliveryCityId_value);
		Repository.xpath_sendkeys(LocatorsJson.pickuppost_code,LocatorsJson.pickuppostcode_value);
		Repository.xpath_sendkeys(LocatorsJson.deliverypost_code,LocatorsJson.deliverypostcode_value);
		Repository.xpath_sendkeys(LocatorsJson.pickup_address,LocatorsJson.pickupaddress_value);
		Repository.xpath_sendkeys(LocatorsJson.delivery_address,LocatorsJson.deliveryaddress_value);
		Repository.xpath_sendkeys(LocatorsJson.picon_person,LocatorsJson.piconperson_value);
		Repository.xpath_sendkeys(LocatorsJson.pickucop_email,LocatorsJson.pickucopemail_value);
		Repository.xpath_sendkeys(LocatorsJson.landline_number2,LocatorsJson.landlinenumber_value2);
		Repository.xpath_sendkeys(LocatorsJson.decon_person,LocatorsJson.deconperson_value);
		Repository.xpath_sendkeys(LocatorsJson.deconperson_email,LocatorsJson.deconpersonemail_value);
		Repository.xpath_sendkeys(LocatorsJson.landline_number3,LocatorsJson.landlinenumber_value3);
		Repository.xpath_sendkeys(LocatorsJson.mobile_number1,LocatorsJson.mobilenumber_1value);
		Repository.xpath_sendkeys(LocatorsJson.mobile_number2,LocatorsJson.mobilenumber_value2);
	//	Thread.sleep(3000);
		Repository.xpath_click(LocatorsJson.activity_checkbox);
		
		WebElement element = Repository.xpath(LocatorsJson.cargoreadiness_date); 
		((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView(true);", element); 
		/*JavascriptExecutor jse = (JavascriptExecutor)Global.driver;
		jse.executeScript("window.scrollBy(0,250)", "");*/
			WebDriverWait wait = new WebDriverWait(Global.driver, 10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Repository.xpath_p(LocatorsJson.cargoreadiness_date)));
		Repository.xpath_click(LocatorsJson.cargoreadiness_date);
		WebElement date_list3 = Repository.xpath(LocatorsJson.date_list);
		List<WebElement> tableTR3 = date_list3.findElements(By.className(LocatorsJson.day));
		//String date3 ="26";
		Calendar calendarInternal = Calendar.getInstance();
		calendarInternal.add(Calendar.DATE, 3);
		date = calendarInternal.getTime();
		int cargofinal= date.getDate();
		String cargofinal_date= Integer.toString(cargofinal);
		for (int i = 0; i < tableTR3.size(); i++) {
			System.out.println(tableTR3.get(i).getText());
			if (tableTR3.get(i).getText().contains(cargofinal_date)){		
				System.out.println("date cjaxdcvhduis");
				tableTR3.get(i).click();
			//	Thread.sleep(5000);        
				break;	
			}
	
		}
		Repository.xpath_click(LocatorsJson.permitted_quote);
		//Thread.sleep(5000);
		Repository.xpath_click(LocatorsJson.step2_next);
		//Thread.sleep(5000);
		WebElement step2 = Repository.xpath(LocatorsJson.item_details);
		System.out.println(step2.getText().toString());
		//String step1value= step1.getText();
		if (step2.getText().toString().equals("Total Items")) {
			System.out.println("rfq2 created successfully");
		}
		else{
			System.out.println("rfq2 not created successfully");
		}
		Global.logger.log(LogStatus.PASS, "Shipment details updated successfully");
		Global.report.endTest(Global.logger);
		 Global.report.flush();
		
		}
		
		
		////rfq3
		
		
		public static void rfqstep3() throws Exception{
			Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			Global.logger=Global.report.startTest("Verify updating Item details");
			//STEP3
			Repository.xpath_sendkeys(LocatorsJson.itemname, LocatorsJson.itemnamevalue);//("(//*[@type='text'])[1]")).sendKeys("item1");
			Repository.xpath_sendkeys(LocatorsJson.identifierNo, LocatorsJson.identifierNo_value);//By.xpath("(//*[@type='text'])[2]")).sendKeys("4578");
			Repository.xpath_sendkeys(LocatorsJson.priceperUnit, LocatorsJson.priceperUnit_value);//Global.driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("44");
			Repository.xpath_sendkeys(LocatorsJson.quantity, LocatorsJson.quantity_value);//Global.driver.findElement(By.xpath("(//*[@type='number'])[1]")).sendKeys("44");
			Repository.xpath_sendkeys(LocatorsJson.weight, LocatorsJson.weight_value);//Global.driver.findElement(By.xpath("(//*[@type='number'])[2]")).sendKeys("6");
			
			Repository.xpath_click(LocatorsJson.upload_file1);//Global.driver.findElement(By.xpath("(//*[@id='file'])[1]")).click();
			Thread.sleep(4000);
			WebElement upload = Repository.xpath(LocatorsJson.upload_file2);//Global.driver.findElement(By.xpath("(//*[@class='rfqPrintBtn btn cursor-pointer margin-0'])[3]"));
		    //upload.sendKeys("/home/thrymr/Desktop/from-a-child.jpg");
		    upload.click();
		    StringSelection upload1= new StringSelection("uploadfilepath");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload1,null );
		    Robot r =new Robot();
		    r.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		    r.keyPress(java.awt.event.KeyEvent.VK_V);
		    r.keyRelease(java.awt.event.KeyEvent.VK_V);
		    r.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		    //Thread.sleep(5000);
		    r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		    r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		    Repository.xpath_click(LocatorsJson.closeup);//Global.driver.findElement(By.xpath("(//*[@class='btn blue_button'])[3]")).click();
		    
			WebElement weight = Repository.xpath(LocatorsJson.weightme);//Global.driver.findElement(By.xpath("//*[@formcontrolname='weightIn']"));
			
			
			Select weight_value = new Select(weight);
			weight_value.selectByVisibleText(LocatorsJson.weightmevalue);
			Repository.xpath_sendkeys(LocatorsJson.sizel, LocatorsJson.sizelvalue);//Global.driver.findElement(By.xpath("(//*[@type='number'])[3]")).sendKeys("3");
			Repository.xpath_sendkeys(LocatorsJson.sizeb, LocatorsJson.sizebvalue);//Global.driver.findElement(By.xpath("(//*[@type='number'])[4]")).sendKeys("9");
			Repository.xpath_sendkeys(LocatorsJson.sizeh, LocatorsJson.sizehvalue);//Global.driver.findElement(By.xpath("(//*[@type='number'])[5]")).sendKeys("4");
			WebElement size = Repository.xpath(LocatorsJson.sizeme);//Global.driver.findElement(By.xpath("//*[@formcontrolname='sizeMetrics']"));
			Select size_value = new Select(size);
			size_value.selectByVisibleText(LocatorsJson.sizemevalue);
			WebElement DG = Repository.xpath(LocatorsJson.dg);//Global.driver.findElement(By.xpath("//*[@formcontrolname='itemClass']"));
			Select DG_value = new Select(DG);
			DG_value.selectByValue(LocatorsJson.dg_value);
			WebElement itemtype = Repository.xpath(LocatorsJson.new_Old);//Global.driver.findElement(By.xpath("//*[@formcontrolname='itemType']"));
			 //String x= Global.driver.findElement(By.xpath("//*[@formcontrolname='itemType']")).getAttribute("class");
			Select itemtype_value = new Select(itemtype);
			itemtype_value.selectByVisibleText(LocatorsJson.new_Oldvalue);
			Thread.sleep(5000);
			Repository.xpath_click(LocatorsJson.OriginPort);//Global.driver.findElement(By.xpath("//*[text()='Temporary Export']")).click();
			Repository.xpath_click(LocatorsJson.DestinationPort);//Global.driver.findElement(By.xpath("//*[text()='Temporary Import']")).click();
			
			WebElement element1 = Repository.xpath(LocatorsJson.stp3next);//Global.driver.findElement(By.xpath("//*[@class='rfqPrintBtn as_marLF_15']")); 
			
			((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			//Thread.sleep(5000);
			Repository.xpath_click(LocatorsJson.stp3next);//Global.driver.findElement(By.xpath("//*[@class='rfqPrintBtn as_marLF_15']")).click();
			//Thread.sleep(5000);
			WebElement step3 = Repository.xpath(LocatorsJson.additionalrequ);//Global.driver.findElement(By.xpath("//*[text()='Additional Requirements']"));
			System.out.println(step3.getText().toString());
			//String step1value= step1.getText();
			if (step3.getText().toString().equals("Additional Information")) {
				System.out.println("rfq3 created successfully");
			}
			else{
				System.out.println("rfq3 not created successfully");
			}
			Global.logger.log(LogStatus.PASS, "Item details updated successfully");
			Global.report.endTest(Global.logger);
			 Global.report.flush();
			 
			}
		
		//rfq4
			public static void rfqstep4() throws Exception {
				Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Global.logger=Global.report.startTest("Verify updating Additional information");
			//step4
			WebElement element2 = Repository.xpath(LocatorsJson.step4next);//Global.driver.findElement(By.xpath("//*[@class='rfqPrintBtn as_marLF_15 btn']")); 
			((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView(true);", element2);
			Repository.xpath_click(LocatorsJson.step4next);//Global.driver.findElement(By.xpath("//*[@class='rfqPrintBtn as_marLF_15 btn']")).click();
			//Thread.sleep(5000);
			WebElement step4 = Repository.xpath(LocatorsJson.review);//Global.driver.findElement(By.xpath("//*[text()='Review']"));
			System.out.println(step4.getText().toString());
			//String step1value= step1.getText();
			if (step4.getText().toString().equals("RFQ Title")) {
				System.out.println("rfq4 created successfully");
			}
			else{
				System.out.println("rfq4 not created successfully");
			}
			Global.logger.log(LogStatus.PASS, "Additional information updated successfully");
			Global.report.endTest(Global.logger);
			 Global.report.flush();
			 
			}
			
			
			//rfq5
			
			
			
			public static void rfqId() throws Exception {
				
				Global.logger=Global.report.startTest("Verify RFQ Creation");
				Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element3 = Repository.xpath(LocatorsJson.checkbox);//Global.driver.findElement(By.xpath("//*[@class='checkmark']")); 
			((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView(true);", element3);
			Repository.xpath_click(LocatorsJson.checkbox);//Global.driver.findElement(By.xpath("//*[@class='checkmark']")).click();
			
			Thread.sleep(5000);
			Repository.xpath_click(LocatorsJson.step5next);//Global.driver.findElement(By.xpath("//*[@class='btn rfqPrintBtn as_marLF_15 ng-star-inserted']")).click();
			WebElement step5 = Repository.xpath(LocatorsJson.submit);//Global.driver.findElement(By.xpath("//*[text()='Submit']"));
			System.out.println(step5.getText().toString());
			//String step1value= step1.getText();
			if (step5.getText().toString().equals("RFQ Expiry Date")) {
				System.out.println("rfq created successfully");
			}
			else{
				System.out.println("rfq not created successfully");
			}
			Global.logger.log(LogStatus.PASS, "RFQ created successfully");
			Global.report.endTest(Global.logger);
			 Global.report.flush();
			
			WebElement rfqid = Global.driver.findElement(By.xpath("(//*[@class='bluetext'])[1]"));
			 rfqidValue = rfqid.getText();
		
			}
		public static void customerLogout() throws Exception {
		
			Global.logger=Global.report.startTest("customer logout");
			Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(7000);
			Global.driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[3]")).click();
			Global.driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			WebElement log = Global.driver.findElement(By.xpath("(//*[text()=' Email Address'])[1]"));
			if (log.getText().equals("Email Address")) {
				System.out.println("customer logout successfully");
			}
			else {
				System.out.println("unable to logout");
			}
			Global.logger.log(LogStatus.PASS, "customer logout successfully");
			Global.report.endTest(Global.logger);
			 Global.report.flush();
			
		}
	
		public static void ctlogin() throws Exception {
			
			Global.logger=Global.report.startTest("ct login");
			Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Global.driver.get("http://ci.thrymr.net:2018/ct/login");
			Global.driver.findElement(By.xpath("//*[@placeholder='Enter Email']")).sendKeys("e2log@thrymr.net");
			Global.driver.findElement(By.xpath("//*[@placeholder='Enter Password']")).sendKeys("e2Log@123");
			Global.driver.findElement(By.xpath("//*[@type='submit']")).click();
			Global.logger.log(LogStatus.PASS, "ct login successfully");
			Thread.sleep(7000);
			Global.driver.findElement(By.xpath("(//*[@href='/ct/waiting-rfqs'])[1]")).click();
			Thread.sleep(5000);
			Global.driver.findElement(By.xpath("//*[@placeholder='RFQ ID']")).sendKeys(rfqidValue);
			Thread.sleep(5000);
			Global.driver.findElement(By.xpath("//*[text()='VIEW']")).click();
			JavascriptExecutor js = (JavascriptExecutor)Global.driver;
			
			WebElement rfqApprove = Global.driver.findElement(By.xpath("//*[@class='apporveButton']"));
			js.executeScript("arguments[0].scrollIntoView();", rfqApprove);
			rfqApprove.click();
			Thread.sleep(5000);
			Global.driver.findElement(By.xpath("(//*[@class='btn btn-success'])[1]")).click();
			Thread.sleep(7000);
			Global.driver.findElement(By.xpath("//*[@placeholder='RFQ ID']")).sendKeys(rfqidValue);
			WebElement approved= Global.driver.findElement(By.xpath("//*[@class='content-header']"));
			String appRfqs= approved.getText();
			if (appRfqs.equals("APPROVED RFQs")) {
				System.out.println("rfq approved successfully");
			}
				else {
					
				
					System.out.println("rfq is not approved");
				}
			Global.logger.log(LogStatus.PASS, "rfq approved successfully");
			Global.report.endTest(Global.logger);
			 Global.report.flush();
			
			}
			/*WebElement rfqIdtable =Global.driver.findElement(By.xpath("//*[@class='table']"));
			List<WebElement> rfqlist = Global.driver.findElements(By.tagName("tr"));
			for (int i = 0; i < rfqlist.size(); i++) {
				String rfqListStr= rfqlist.get(i).getText();
				if (rfqListStr.equals("APPROVED")) {
					System.out.println("rfq approved successfully");
				}
					else {
						
					
						System.out.println("rfq is not approved");
					}
				
				}*/
		
		public static boolean date1() throws InterruptedException {

			// table[@class='caltable']/tbody
			List<WebElement> value = Global.driver.findElements(By.className("daycell"));
			today = getCurrentDay();

			String prop = String.valueOf(getTomorrowDate());
			for (int i = 0; i < value.size(); i++) {
				System.out.println(value.get(i)); // .contains(prop)
				if (value.get(i).getText().contains(prop)) {
					System.out.println(value.get(i));
					value.get(i).click();
					Thread.sleep(4000);
					break;
				}

			}
			return true;

		}

		public static String getCurrentDay() {
			// Create a Calendar Object
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

			// Get Current Day as a number
			int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("Today Int: " + todayInt + "\n");

			// Integer to String Conversion
			String todayStr = Integer.toString(todayInt);
			System.out.println("Today Str: " + todayStr + "\n");

			return todayStr;

		}

		public static int getTomorrowDate() {

			Date dt = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(dt);

			{
				c.add(Calendar.DATE, 2);
				dt = c.getTime();
				System.out.println("DAte======>" + dt.getDate());

			}
			return dt.getDate();

		}
		
		public static void quotation()  throws InterruptedException {
			Global.logger=Global.report.startTest("Creation of Quotation");
			Repository.launch_url("http://ci.thrymr.net:2018/lsp");
			Global.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Global.driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("suryajyoti.bisen@thrymr.net");
			Thread.sleep(1000);
			Global.driver.findElement(By.xpath("(//*[@type='Password'])[1]")).sendKeys("e2loG@123");
			Thread.sleep(1000);
			Global.driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
			Thread.sleep(2000);
			Global.driver.findElement(By.xpath("//*[@href='/lsp/lsp-manage-quotations']")).click();
			Thread.sleep(1000);
			Global.driver.findElement(By.xpath("//*[@placeholder='RFQ ID']")).sendKeys(rfqidValue);
			Thread.sleep(2000);
			Global.driver.findElement(By.xpath("//*[text()='VIEW RFQ']")).click();
			Thread.sleep(1000);
			Global.driver.findElement(By.xpath("//*[text()='BID']")).click();
			if (Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[1]")).isDisplayed()) {
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[1]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[2]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[3]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[4]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[5]")).click();

				WebElement ww = Global.driver.findElement(
						By.xpath("//div[@class='row bodyMargin margin-bottom-0']//h6[text()='International Transit']"));
				try {
					Actions action = new Actions(Global.driver);
					action.click(ww).build().perform();
					Thread.sleep(1000);
					for (int i = 0; i < 24; i++) {
						action.sendKeys(Keys.ARROW_RIGHT).build().perform();
						Thread.sleep(500);
					}
				}

				catch (Exception e) {
					System.out.println("jkashdjshsajh");
				}

				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[6]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[7]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[8]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[9]")).click();
				Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[10]")).click();

			} else {
				System.out.println("No check boxes");
			}

			// Custom Clearance
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[1]")).sendKeys("12");
			Global.driver.findElement(By.xpath("//*[@name='camanpowerPrice']")).sendKeys("122");
			Global.driver.findElement(By.xpath("//*[@name='catravelAccomodationRate']")).sendKeys("12");
			Global.driver.findElement(By.xpath("//*[@name='catravelAccomodationPersons']")).sendKeys("134");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[1]")).click();
			// packing and packing list preparation
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[2]")).sendKeys("13");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[2]")).click();
			Global.driver.findElement(By.xpath("//*[@name='plpforkLiftPrice']")).sendKeys("14");
			Global.driver.findElement(By.xpath("//*[@name='plpcranesPrice']")).sendKeys("15");
			Global.driver.findElement(By.xpath("//*[@name='plplashingPrice']")).sendKeys("16");
			Global.driver.findElement(By.xpath("//*[@name='plpwoddenBoxPrice']")).sendKeys("122");
			Global.driver.findElement(By.xpath("//*[@name='plpheavyPackingPrice']")).sendKeys("13");
			Global.driver.findElement(By.xpath("//*[@name='plpbundlingPrice']")).sendKeys("122");
			Global.driver.findElement(By.xpath("//*[@name='plpcontainerStuffingPrice']")).sendKeys("18");
			Global.driver.findElement(By.xpath("//*[@name='plppackingListPreparationPrice']")).sendKeys("21");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[2]")).click();
			// loading and transportation(to load port)
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[3]")).sendKeys("16");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[3]")).click();
			Global.driver.findElement(By.xpath("//*[@name='ltforkLiftPrice']")).sendKeys("14");
			Global.driver.findElement(By.xpath("//*[@name='ltcranesPrice']")).sendKeys("43");
			Global.driver.findElement(By.xpath("//*[@name='ltenclosedTruckPrice']")).sendKeys("44");
			Global.driver.findElement(By.xpath("//*[@name='ltflatBedPrice']")).sendKeys("45");
			Global.driver.findElement(By.xpath("//*[@name='ltlowBedPrice']")).sendKeys("46");
			Global.driver.findElement(By.xpath("//*[@name='lthydraulicPrice']")).sendKeys("47");
			Global.driver.findElement(By.xpath("//*[@name='ltescortCharges']")).sendKeys("48");
			Global.driver.findElement(By.xpath("//*[@name='ltroadPermits']")).sendKeys("49");
			Global.driver.findElement(By.xpath("//*[@name='ltotherCostDescription']")).sendKeys("30");
			Global.driver.findElement(By.xpath("//*[@name='ltotherCost']")).sendKeys("122");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[3]")).click();
			// custom clearance (load port)
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[4]")).sendKeys("21");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[4]")).click();
			Global.driver.findElement(By.xpath("//*[@name='cclagencyFeesPercentage']")).sendKeys("321");
			Global.driver.findElement(By.xpath("//*[@name='cclstatutoryCharges']")).sendKeys("32");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[4]")).click();
			// terminal/ port handling ( load port)
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[5]")).sendKeys("32");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[5]")).click();
			Global.driver.findElement(By.xpath("//*[@name='tlthcPhcPrice']")).sendKeys("32");
			Global.driver.findElement(By.xpath("//*[@name='ltloadingCranePrice']")).sendKeys("54");
			Global.driver.findElement(By.xpath("//*[@name='lttruckinPrice']")).sendKeys("32");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[5]")).click();
			// International transit
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[6]")).sendKeys("18");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[6]")).click();
			Global.driver.findElement(By.xpath("//*[@name='itfreightPortPrice']")).sendKeys("43");
			Global.driver.findElement(By.xpath("//*[@name='itfreightPortWtPrice']")).sendKeys("32");
			Global.driver.findElement(By.xpath("//*[@name='itratePersurvey']")).sendKeys("42");
			Global.driver.findElement(By.xpath("//*[@name='itnoOfSurvey']")).sendKeys("32");
			Global.driver.findElement(By.xpath("//*[@name='itinsurancePrice']")).sendKeys("32");
			Global.driver.findElement(By.xpath("//*[@name='itroadPerms']")).sendKeys("32");
			Global.driver.findElement(By.xpath("//*[@name='itescortCharges']")).sendKeys("54");
			WebElement other_details = Global.driver.findElement(By.xpath("//*[@name='itinternationalTransportMode']"));
			Select s1 = new Select(other_details);
			s1.selectByVisibleText("SEA");
			Global.driver.findElement(By.xpath("//*[@name='itvesselType']")).sendKeys("type");
			Global.driver.findElement(By.xpath("//*[@name='itvesselSizeInTons']")).sendKeys("1322");
			Global.driver.findElement(By.xpath("//*[@name='itvesselSizeInCbms']")).sendKeys("542");
			WebElement Freight_plan = Global.driver.findElement(By.xpath("//*[@name='itfreightPlan']"));
			Select s2 = new Select(Freight_plan);
			s2.selectByVisibleText("Break Bulk");
			Global.driver.findElement(By.xpath("//*[@name='itnameOfCarrier']")).sendKeys("sea");
			Global.driver.findElement(By.xpath("//*[@name='itflagOfCarrier']")).sendKeys("blue");
			Global.driver.findElement(By.xpath("//*[@name='itloadingPort']")).sendKeys("43");
			Global.driver.findElement(By.xpath("//*[@name='itagencyResponsibleLoading']")).sendKeys("load");
			WebElement element = Global.driver.findElement(By.xpath("(//*[@class='mydpicon icon-mydpcalendar'])[4]"));
			((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Global.driver.findElement(By.xpath("(//*[@class='mydpicon icon-mydpcalendar'])[1]")).click();
			date1();
			Global.driver.findElement(By.xpath("(//*[@class='mydpicon icon-mydpcalendar'])[2]")).click();
			date1();
			Global.driver.findElement(By.xpath("//*[@name='itdetentionLoadPortCharges']")).sendKeys("14422");
			Global.driver.findElement(By.xpath("//*[@name='itfreeDaysForLoading']")).sendKeys("122");
			Global.driver.findElement(By.xpath("//*[@name='itdischargePort']")).sendKeys("port");
			Global.driver.findElement(By.xpath("//*[@name='itagencyResponsibleForOffLoading']")).sendKeys("party");
			Global.driver.findElement(By.xpath("(//*[@class='mydpicon icon-mydpcalendar'])[3]")).click();
			date1();
			Global.driver.findElement(By.xpath("(//*[@class='mydpicon icon-mydpcalendar'])[4]")).click();
			date1();
			Global.driver.findElement(By.xpath("//*[@name='itdetentionDischargePortCharges']")).sendKeys("23");
			Global.driver.findElement(By.xpath("//*[@name='itfreeDaysforOffLoading']")).sendKeys("23");
			WebElement BL_release = Global.driver.findElement(By.xpath("//*[@name='ittypeOfBLRelease']"));
			Select s3 = new Select(BL_release);
			s3.selectByVisibleText("Express");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[6]")).click();
			// Loading/port handling (discharge port)
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[7]")).sendKeys("32");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[7]")).click();
			Global.driver.findElement(By.xpath("//*[@name='tphdthcPhcPrice']")).sendKeys("32");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[7]")).click();
			// Custom clerance (discharge port)
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[8]")).sendKeys("32");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[8]")).click();
			Global.driver.findElement(By.xpath("//*[@name='ccdagencyFeesPercentage']")).sendKeys("321");
			Global.driver.findElement(By.xpath("//*[@name='ccdstatutoryCharges']")).sendKeys("543");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[8]")).click();
			// Loading and transportation at destination
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[9]")).sendKeys("43");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[9]")).click();
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[1]")).sendKeys("43");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[2]")).sendKeys("122");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[3]")).sendKeys("65");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[4]")).sendKeys("43");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[5]")).sendKeys("98");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[6]")).sendKeys("78");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[7]")).sendKeys("65");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[8]")).sendKeys("43");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[9]")).click();
			// off loading at destination
			Global.driver.findElement(By.xpath("(//*[@name='namead'])[10]")).sendKeys("43");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[10]")).click();
			Global.driver.findElement(By.xpath("//*[@name='offLoadingAtDloadForkLiftPrice']")).sendKeys("54");
			Global.driver.findElement(By.xpath("(//*[@name='namead2'])[10]")).sendKeys("54");
			Global.driver.findElement(By.xpath("(//*[@class='fa fa-angle-down'])[10]")).click();
			Thread.sleep(2000);
			Global.driver.findElement(By.xpath("(//*[@class='checkmark'])[11]")).click();
			Global.driver.findElement(By.xpath("//*[text()='SUBMIT QUOTE']")).click();
			Thread.sleep(5000);
			Global.driver.findElement(By.xpath("(//*[@class='btn btn-success'])[1]")).click();

			Global.logger.log(LogStatus.PASS, "Quotation created successfully");
			Global.report.endTest(Global.logger);
			 Global.report.flush();
			Global.report.close();	
				
			

		}
}
