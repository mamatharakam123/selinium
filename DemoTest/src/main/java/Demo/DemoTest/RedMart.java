package Demo.DemoTest;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RedMart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/Mamatha/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://redmart.com");
		Actions action= new Actions(driver);
		WebElement fruits= driver.findElement(By.linkText("Fruit & Veg"));
		action.moveToElement(fruits).build().perform();
		driver.findElement(By.linkText("Fresh Fruits")).click();
		Thread.sleep(5000);
		WebElement fruitsty= driver.findElement(By.xpath("(//*[@class='productShelf'])"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=0; i<10;i++){
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(4000);
		}
		List<WebElement> fruitslist= fruitsty.findElements(By.tagName("ul"));
		List<WebElement> list= fruitsty.findElements(By.tagName("li"));
		System.out.println(list.size());
		for (int j = 0; j <list.size(); j++) {
			
			System.out.println(list.get(j).getText());
			
		}
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='description'])[1]")).click();*/
	}

}
