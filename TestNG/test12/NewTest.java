package test12;

import org.testng.annotations.Test;

import patanjali1.Global;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test
  public void f() {
	  Global.driver.findElement(By.xpath("//*[@id='customerLoginForm']/div/div[1]/input")).sendKeys("mamatha1@test.com");
		Global.driver.findElement(By.xpath("//*[@id='customerLoginForm']/div/div[2]/input")).sendKeys("e2Log@123");
		Global.driver.findElement(By.xpath("//*[@id='customerLoginForm']/div/div[6]/div/button[1]")).click();
		Thread.sleep(5000);
		WebElement login = Global.driver.findElement(By.xpath("//*[text()='Dashboard']"));
		System.out.println(login.getText().toString());
		//String step1value= step1.getText();
		if (login.getText().toString().equals("Dashboard")) {
			System.out.println("login successfully");
		}
		else{
			System.out.println("unable to login");
		}
		}
  }
  @BeforeMethod
  public void beforeMethod() {
	// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/Mamatha/chromedriver");
			// WebDriver driver = new ChromeDriver();
			//Global.driver.get("localhost:4200/customer");
			Global.driver.get("http://ci.thrymr.net:2018/customer");
			Global.driver.manage().window().maximize();
			Thread.sleep(5000);
  }

  @AfterMethod
  public void afterMethod() {
	  Global.driver.findElement(By.xpath("//*[@href='/customer/quotations/rfq']")).click();
		Thread.sleep(5000);
		//Global.driver.findElement(By.xpath("//*[@name='currency']")).click();
		
		//Global.driver.findElement(By.xpath("//*[@class='mydpicon icon-mydpcalendar']")).click();
	/*List<WebElement> allDates=Global.driver.findElements(By.xpath("(//*[@tabindex='0'])[3]//td"));
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("19"))
			{
				ele.click();
				break;
			}*/

		
	
	
			
			//WaitForElementVisible(Global.driver, By.xpath("//a[@href= '/customer/quotations/rfq']"));
			//Global.driver.findElement(By.xpath("//a[@href= '/customer/quotations/rfq']")).click();
			//Global.driver.findElement(By.xpath("//span[@class='mydpicon icon-mydpcalendar']")).click();
		Global.driver.findElement(By.xpath("//span[@class='mydpicon icon-mydpcalendar']")).click();
		WebElement date_list = Global.driver.findElement(By.xpath("//table[@class='caltable ng-star-inserted']/tbody"));
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
		
		WebElement currency = Global.driver.findElement(By.xpath("//*[@name='currency']"));
		Select currency_se = new Select(currency);
		WebElement e = Global.driver.findElement(By.xpath("//*[@id='home']/div/form/div[1]/div/select/option[23]"));
		String cu =e.getText();
		e.click();
		Global.driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("Shipping from india to singapore");
		Thread.sleep(5000);
		//Global.driver.findElement(By.xpath("//*[@id='home']/div/form/div[3]/div[1]/div[1]/div[2]/div[1]/input")).sendKeys("24-03-2018");
		Global.driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("mamatha");
		Global.driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("mamatha@thrymr.net");
		Global.driver.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("mamatha@thrymr.net");
		WebElement mobile_co= Global.driver.findElement(By.xpath("//*[@name='contactPersonMobileCountry']"));
		Select mobile_co_va = new Select(mobile_co);
		mobile_co_va.selectByValue("101");
		Global.driver.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("8121026766");
		WebElement landline_co= Global.driver.findElement(By.xpath("//*[@name='officeLandNumberCountry']"));
		Select landline_co_va = new Select(landline_co);
		landline_co_va.selectByValue("101");
		Global.driver .findElement(By.xpath("//*[@type='number']")).sendKeys("8121026766");
		
		//Global.driver.findElement(By.xpath("(//*[@type='text'])[7]")).sendKeys("");

			Global.driver.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("nothing to say");
		JavascriptExecutor js = (JavascriptExecutor) Global.driver; 
		WebElement tier =Global.driver.findElement(By.xpath("//*[@class='fa fa-angle-down']"));
		js.executeScript("arguments[0].scrollIntoView();", tier);
		
		Global.driver.findElement(By.xpath("//*[@class='fa fa-angle-down']")).click();
		
		WebElement tier_se =Global.driver.findElement(By.xpath("//*[text()='Select All']"));
		js.executeScript("arguments[0].scrollIntoView();", tier_se);
		Global.driver.findElement(By.xpath("//*[text()='Select All']")).click();
		Global.driver.findElement(By.xpath("//*[@class='fa fa-angle-up']")).click();
		Global.driver.findElement(By.xpath("(//*[@class='label-text'])[1]")).click();
		//Global.driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("5346756");
		Global.driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(6000);
		WebElement step1 = Global.driver.findElement(By.xpath("//*[text()='Shipment Details']"));
		System.out.println(step1.getText().toString());
		//String step1value= step1.getText();
		if (step1.getText().toString().equals("Shipment Details")) {
			System.out.println("rfq1 created successfully");
		}
		else{
			System.out.println("rfq1 not created successfully");
		}
		}
  }

}
