package Demo.DemoTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


import junit.framework.Assert;




/**
 * Hello world!
 *
 */
public class App 
{
	//private static Logger Log = Logger.getLogger(Log.class.getName());
	static WebDriver driver;
	@Test (priority=2)
	  public void login() throws Exception {
		  driver.findElement(By.xpath("//*[@id='customerLoginForm']/div/div[1]/input")).sendKeys("mamatha1@test.com");
			driver.findElement(By.xpath("//*[@id='customerLoginForm']/div/div[2]/input")).sendKeys("e2Log@123");
			driver.findElement(By.xpath("//*[@id='customerLoginForm']/div/div[6]/div/button[1]")).click();
			Thread.sleep(5000);
			WebElement login = driver.findElement(By.xpath("//*[text()='Dashboard']"));
			System.out.println(login.getText().toString());
			//String step1value= step1.getText();
			if (login.getText().toString().equals("Dashboard")) {
				System.out.println("login successfully");
			}
			else{
				System.out.println("unable to login");
			}
			}
	 
	  
	  @BeforeTest
	  public void launchbrowser() throws Exception {
		// TODO Auto-generated method stub
		  //DOMConfigurator.configure("log4j.xml");
				System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/Mamatha/chromedriver");
				 driver = new ChromeDriver();
				
				//driver.get("localhost:4200/customer");
				
				driver.get("http://ci.thrymr.net:2018/customer");
				driver.manage().window().maximize();
				Thread.sleep(5000);
	  }

	  @AfterTest
	  public void afterMethod() throws Exception {
		  driver.findElement(By.xpath("//*[@href='/customer/quotations/rfq']")).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@name='currency']")).click();
			
			//driver.findElement(By.xpath("//*[@class='mydpicon icon-mydpcalendar']")).click();
		/*List<WebElement> allDates=driver.findElements(By.xpath("(//*[@tabindex='0'])[3]//td"));
			
			for(WebElement ele:allDates)
			{
				
				String date=ele.getText();
				
				if(date.equalsIgnoreCase("19"))
				{
					ele.click();
					break;
				}*/
	  }
	  @Test (priority=2)
			public void rfqstep() throws Exception  {
				
				
				driver.findElement(By.xpath("//*[@href='/customer/quotations/rfq']")).click();
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//*[@name='currency']")).click();
				
				//driver.findElement(By.xpath("//*[@class='mydpicon icon-mydpcalendar']")).click();
			/*List<WebElement> allDates=driver.findElements(By.xpath("(//*[@tabindex='0'])[3]//td"));
				
				for(WebElement ele:allDates)
				{
					
					String date=ele.getText();
					
					if(date.equalsIgnoreCase("19"))
					{
						ele.click();
						break;
					}*/

				
			
			
					
					//WaitForElementVisible(driver, By.xpath("//a[@href= '/customer/quotations/rfq']"));
					//driver.findElement(By.xpath("//a[@href= '/customer/quotations/rfq']")).click();
					//driver.findElement(By.xpath("//span[@class='mydpicon icon-mydpcalendar']")).click();
				driver.findElement(By.xpath("//span[@class='mydpicon icon-mydpcalendar']")).click();
				WebElement date_list = driver.findElement(By.xpath("//table[@class='caltable ng-star-inserted']/tbody"));
				List<WebElement> tableTR = date_list.findElements(By.className("daycell"));
				String date ="5";
				for (int i = 0; i < tableTR.size(); i++) {
					System.out.println(tableTR.get(i).getText());
					if (tableTR.get(i).getText().contains(date)){		
						System.out.println("date cjaxdcvhduis");
						tableTR.get(i).click();
						Thread.sleep(5000);
						break;	
					}
			
				}
				
				WebElement currency = driver.findElement(By.xpath("//*[@name='currency']"));
				Select currency_se = new Select(currency);
				WebElement e = driver.findElement(By.xpath("//*[@id='home']/div/form/div[1]/div/select/option[23]"));
				String cu =e.getText();
				e.click();
				driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("Shipping from india to singapore");
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//*[@id='home']/div/form/div[3]/div[1]/div[1]/div[2]/div[1]/input")).sendKeys("24-03-2018");
				driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("mamatha");
				driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("mamatha@thrymr.net");
				driver.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("mamatha@thrymr.net");
				WebElement mobile_co= driver.findElement(By.xpath("//*[@name='contactPersonMobileCountry']"));
				Select mobile_co_va = new Select(mobile_co);
				mobile_co_va.selectByValue("101");
				driver.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("8121026766");
				WebElement landline_co= driver.findElement(By.xpath("//*[@name='officeLandNumberCountry']"));
				Select landline_co_va = new Select(landline_co);
				landline_co_va.selectByValue("101");
				driver .findElement(By.xpath("//*[@type='number']")).sendKeys("8121026766");
				
				//driver.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("");

					driver.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("nothing to say");
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				WebElement tier =driver.findElement(By.xpath("//*[@class='fa fa-angle-down']"));
				js.executeScript("arguments[0].scrollIntoView();", tier);
				
				driver.findElement(By.xpath("//*[@class='fa fa-angle-down']")).click();
				
				WebElement tier_se =driver.findElement(By.xpath("//*[text()='Select All']"));
				js.executeScript("arguments[0].scrollIntoView();", tier_se);
				driver.findElement(By.xpath("//*[text()='Select All']")).click();
				driver.findElement(By.xpath("//*[@class='fa fa-angle-up']")).click();
				driver.findElement(By.xpath("(//*[@class='label-text'])[1]")).click();
				//driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("5346756");
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				Thread.sleep(6000);
				WebElement step1 = driver.findElement(By.xpath("//*[text()='Shipment Details']"));
				System.out.println(step1.getText().toString());
				//String step1value= step1.getText();
				/*if (step1.getText().toString().equals("Shipment Details")) {
					System.out.println("rfq1 created successfully");
				}
				else{
					System.out.println("rfq1 not created successfully");
				}*/
				 Assert.assertEquals(step1.getText().toString().equals("Shipment Details"), true);
				 System.out.println("rfq1 created successfully");
				}

		
	}

