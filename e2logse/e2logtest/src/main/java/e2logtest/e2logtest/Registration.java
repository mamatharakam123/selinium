package e2logtest.e2logtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {

	public static void main(String[] args) {
		//try {
//			System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/Mamatha/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://ci.thrymr.net:2018/lsp");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[text()='SIGN UP']")).click();
			driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("test");
			driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("thrymr");
			driver.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("test13@thrymr.net");
			driver.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("Thrymr software");
			driver.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("8121026766");
			WebElement coun = driver.findElement(By.xpath("//*[@id='country']"));
			Select country = new Select(coun);
			country.selectByValue("94");
			/*WebElement cou_code = driver.findElement(By.xpath("//*[@id='countryCode']"));
			Select country_code = new Select(cou_code);
			country_code.selectByValue("94");*/
			driver.findElement(By.xpath("(//*[@class='checkmark'])[2]")).click();
			
			boolean submit = driver.findElement(By.xpath("(//*[@type='submit'])[2]")).isEnabled();
			System.out.println(submit);
			if (submit==true) {
				
				System.out.println("Register button is enabled");
				
			} else {
				System.out.println("regsiter button is not enabled");
			}
			driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
			//System.out.println("test");
		//	 driver.switchTo().alert().accept();
			// System.out.println("test pass");
			driver.switchTo().window("0");
		      WebElement regis = driver.findElement(By.xpath("//*[text()='Registration request has been received successfully']"));
		       String a = regis.getText();
			//String dashb =driver.switchTo().alert().getText();	
			//assert.dashb.equals("");
		       System.out.println(a);
		       driver.findElement(By.xpath("//*[text()='OK']")).click();
			//alert.dismiss();
			//assert.dashb.equals("");
		} /*catch (Exception registration) {
			// TODO: handle exception
			System.out.println("unable to register");
		}*/
		// TODO Auto-generated method stub
		
		
		
	}


