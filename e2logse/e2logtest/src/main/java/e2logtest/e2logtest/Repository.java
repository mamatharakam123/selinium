package e2logtest.e2logtest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Repository {
	public static void launch_url(String url) {
		
//		System.out.println(FetchProper.fetchProp("chromedriverpath"));
		
		System.setProperty("webdriver.chrome.driver", Getproperties.fetchProp("chromepath"));
		System.out.println(Getproperties.fetchProp("chromepath"));
		Global.driver = new ChromeDriver();
		Global.driver.get(url);
		Global.driver.manage().window().maximize();
	}
	public static void main(String[] args) {
		launch_url("");
	}

	public static void idclick(String value) {
		Global.driver.findElement(By.id(value)).click();
	}

	public static void idsendkeys(String value, String text) {
		Global.driver.findElement(By.id(value)).sendKeys(text);
	}

	public static void name(String value, String text) {
		Global.driver.findElement(By.name(value)).sendKeys(text);
	}

	public static void nameclick(String value) {
		Global.driver.findElement(By.name(value)).click();
	}

	public static void class_click(String value) {
		Global.driver.findElement(By.className(value)).click();
	}
	public static List class_list(String value) {
		
		return Global.driver.findElements(By.className(value));
	}
	public static void class_sendkeys(String value, String text) {
		Global.driver.findElement(By.className(value)).sendKeys(text);
	}

	public static void xpath_click(String value) {
		System.out.println(Global.driver);
		Global.driver.findElement(By.xpath(value)).click();
	}
	
	public static void xpath_sendkeys(String value, String text) {
		Global.driver.findElement(By.xpath(value)).sendKeys(text);
	}

	public static void linktext_click(String value) {
		Global.driver.findElement(By.linkText(value)).click();
	}

	public static void linktext_sendkeys(String value, String text) {
		Global.driver.findElement(By.linkText(value)).sendKeys(text);
	}

	public static WebElement xpath(String value) {
		return Global.driver.findElement(By.xpath(value));
	}
	public static By xpath_p(String value) {
		return By.xpath(value);
	}
	public static List xpath_list(String value) {
		return Global.driver.findElements(By.xpath(value));
	}

	public static void tagname(String value) {
		Global.driver.findElement(By.tagName(value));
	}

	public static void dropdown_xpth(String value, String text) {
		Select dropdown = new Select(Global.driver.findElement(By.xpath(value)));
		dropdown.selectByVisibleText(text);
	}

	public static void dropdown_tagname(String value, String text) {
		Select dropdown = new Select(Global.driver.findElement(By.tagName(value)));
		dropdown.selectByVisibleText(text);
	}

	public static void xpath_keys(String value, String text) {
		Global.driver.findElement(By.xpath(value)).sendKeys(text, Keys.TAB);
	}

	public static void maximize_window() {
		Global.driver.manage().window().maximize();
	}

	public static void mousehover_doublepaths(String MainMenu, String submenuxpath, String subxpath) {
		Actions action = new Actions(Global.driver);
		WebElement mainMenu = Global.driver.findElement(By.xpath(MainMenu));
		action.moveToElement(mainMenu).moveToElement(Global.driver.findElement(By.xpath(submenuxpath)))
				.moveToElement(Global.driver.findElement(By.xpath(subxpath))).click().build().perform();
	}

	public static void mousehover_path(String MainMenu, String submenuxpath) {
		Actions action = new Actions(Global.driver);
		WebElement mainMenu = Global.driver.findElement(By.xpath(MainMenu));
		action.moveToElement(mainMenu).moveToElement(Global.driver.findElement(By.xpath(submenuxpath))).click().build()
				.perform();
	}

	public static void switchwindow() {
		Set<String> set1 = Global.driver.getWindowHandles();
		Iterator<String> win1 = set1.iterator();
		String parent = win1.next();
		String child = win1.next();
		Global.driver.switchTo().window(child);
	}

	public static void switchtoframe(String value) {
		Global.driver.switchTo().frame(Global.driver.findElement(By.xpath(value)));
	}

	public static void switchtodefault() {
		Global.driver.switchTo().defaultContent();
	}

	public static void switchtoframe_id(String value) {
		Global.driver.switchTo().frame(Global.driver.findElement(By.id(value)));
	}

	public static void idsendkeys_TAB(String value, String text) {
		Global.driver.findElement(By.id(value)).sendKeys(text, Keys.DOWN, Keys.ENTER);
	}

	public static void autocomplete_textbox(String xpathvalue, String textinput, String target_text_from_list) {
		WebElement autocomplete = Global.driver.findElement(By.xpath(xpathvalue));
		autocomplete.sendKeys(textinput);
		Actions builder = new Actions(Global.driver);
		WebElement ele = Global.driver.findElement(By.xpath(target_text_from_list));
		// use Mouse hover action for that element
		builder.moveToElement(ele).build().perform();
		// Give wait for 2 seconds
		WebDriverWait wait = new WebDriverWait(Global.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target_text_from_list)));
		;
		// finally click on that element
		builder.click(ele).build().perform();
	}

	public static void bootstrap_datepicker(String date) throws Exception {
		String date_ent = date;// D-M-Y
		String date_ent1[] = date_ent.split("-");
		String shipFDay = date_ent1[0];
		String shipFMonth = date_ent1[1];
		String shipFYear = date_ent1[2];
		String date_pres = Global.driver.findElement(By.xpath("//th[@title='Select Month']")).getText();
		System.out.println(date_pres);
		String dp[] = date_pres.split(" ");
		String month_pres = dp[0];
		String year_pres = dp[1];
		if (year_pres.equals(shipFYear)) {
			Global.driver.findElement(By.xpath("//th[@title='Select Month']")).click();

			Global.driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
			Thread.sleep(5000);

		} else if (Integer.parseInt(year_pres) > Integer.parseInt(shipFYear)) {
			Global.driver.findElement(By.xpath("//th[@title='Select Month']")).click();

			while (2 > 1) {
				year_pres = Global.driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
				if (year_pres.equalsIgnoreCase(shipFYear)) {

					Global.driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();
					Thread.sleep(5000);
					break;
				}
				Global.driver.findElement(By.xpath("//span[@title='Previous Year']")).click();
			}

		} else {
			Global.driver.findElement(By.xpath("//th[@title='Select Month']")).click();
			while (2 > 1) {
				year_pres = Global.driver.findElement(By.xpath("//th[@title='Select Year']")).getText();
				if (year_pres.equalsIgnoreCase(shipFYear)) {

					Global.driver.findElement(By.xpath("//span[contains(.,'" + shipFMonth + "')]")).click();

					Thread.sleep(5000);
					break;
				}
				Global.driver.findElement(By.xpath("//span[@title='Next Year']")).click();
			}
		}

	}

	public static void highLightElement(WebElement element)// highlight element

	{
		JavascriptExecutor js = (JavascriptExecutor) Global.driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
/*
	public static void mobile_scroll_H() {
		Dimension size = Global.driver.manage().window().getSize();
		int x_start = (int) (size.width * 0.60);
		int x_end = (int) (size.width * 0.30);
		int y = 130;
		Global.driver.swipe(x_start, y, x_end, y, 4000);
	}
*/
	/*public static void touchaction(int x, int y) {
		TouchAction act = new TouchAction(Global.driver);
		act.tap(x, y).perform();
	}
*/
	/*public static XSSFCell read_excel(String excel_sheet,String  excelpath,int i, int j) throws IOException {
		String filepath = Get_cofig.path(excelpath);
		String sheetname = Get_cofig.path(excel_sheet);
		FileInputStream file = new FileInputStream(new File(filepath));

		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFCell x = sheet.getRow(i).getCell(j);

		// System.out.println(x);
		return x;

	}*/

	/*public static void downloadfiles() {
		Repository.launch_url(Locators.url);
		String loc = Get_cofig.path("downloadfile_loaction");
		String downloadFilepath = loc;

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); // to disable browser
														// extension popup

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		Global.driver = new ChromeDriver(cap);
		// Global.driver.get("http://www.seleniumhq.org/download/");
		Global.driver.findElement(By.linkText(Locators.download_btn_linktext)).click();
	}*/

	public static void refresh_browser() {
		Global.driver.navigate().refresh();
	}

	public static void next_page() {
		Global.driver.navigate().forward();
	}

	public static void previous_page() {
		Global.driver.navigate().back();
	}

	public static void explict_wait_xpath(String xpathvalue) {

		WebDriverWait wait = new WebDriverWait(Global.driver, 100);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));
		element.click();
	}

	public static void explict_wait_linktext(String linktext) {

		WebDriverWait wait = new WebDriverWait(Global.driver, 100);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linktext)));
		element.click();
	}

	/*public static void db_execute_query() throws Exception {
		
		 * Create Connection + Execute Statement + Close Connection
		 
		String DBURL = Get_cofig.path("DBURL");
		String DB_username = Get_cofig.path("DB_username");
		String DB_password = Get_cofig.path("DB_password");
		// Object of Connection from the Database
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		Class.forName("com.mysql.jdbc.Driver");

		// Open a connection
		conn = DriverManager.getConnection(DBURL, DB_username, DB_password);

		// Execute a query
		stmt = conn.createStatement();

		resultSet = stmt.executeQuery("select * from sampletable");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3)
					+ "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}*/

	// @Test-------
	/*
	 * need to test this below method validate UI DATA with The Database
	 */
/*	public static void DBvalidation(String url) throws SQLException, ClassNotFoundException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		// Register JDBC driver (JDBC driver name and Database URL)
		Class.forName("com.mysql.jdbc.Driver");

		// Open a connection
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

		Repository.launch_url(url);// insert url
		ChromeOptions options = new ChromeOptions();

		// Code to disable the popup of saved password
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		Global.driver = new ChromeDriver(options);
		// Global.driver.get("<URL>");

		try {
			// Execute a query
			stmt = conn.createStatement();

			resultSet = stmt.executeQuery("");// read queries from excel???

			// Get the all row of UI Table
			List<WebElement> lstTr = Global.driver.findElement(By.id("")).findElements(By.tagName(""));

			// Index for Row
			int rowCount = 0;

			// Count of Matched Column
			int matchColumnCount = 0;

			// Count of Matched Row
			int matchRowCount = 0;

			System.out.println("Row Count => " + lstTr.size());

			// Extract the data from Table
			while (resultSet.next()) {

				// (rowCount + 1) because first row is a header row , Get all
				// the columns from a particular row
				List<WebElement> lstTd = lstTr.get(rowCount + 1).findElements(By.tagName("td"));
				System.out.println("Cloumn Count => " + lstTd.size());

				for (int j = 0; j < lstTd.size(); j++) {
					String uiCell = lstTd.get(j).getText();
					System.out.println("UI Cell Data => " + uiCell);

					
					 * (j + 1) in the resultSet => because index is start from 1
					 * and here loop is starting from 0
					 
					String dbCell = resultSet.getString(j + 1);
					System.out.println("DB Cell Data => " + dbCell);

					// Comparison between both string
					if (uiCell.trim().equalsIgnoreCase(dbCell.trim())) {
						matchColumnCount++;
					}
				}

				if (matchColumnCount == lstTd.size()) {
					matchRowCount++;
					System.out.println("========ROW MATCHED==========");
				}

				// Set 'matchColumnCount' to 0 for next row matchColumnCount =
				// 0;
				rowCount++;
			}
			assertEquals(matchRowCount, rowCount, "UI Table is the exact copy of Database Table");

		} catch (Exception e) {
			System.out.println(e);
		}

		// Code to close each and all Object related to Database connection
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		Global.driver.quit();
	}

	// need to test this method(data -db)
	public static void InsertToDB(String url, String username, String password) {
		try {
			// create a mysql Database connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);

			// the mysql insert statement
			String query = " Insert into sampletable (FirstName, LastName , PhoneNo, Company) values(?,?,?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "<FirstName>");
			preparedStmt.setString(2, "<LastName>");
			preparedStmt.setString(3, "<Phone No.>");
			preparedStmt.setString(4, "<Company Name>");

			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
			// Runtime.getRuntime().exec("adb shell am force-stop com.XXX.YYY");

		}
	}

	public static void mobile_dragdrop() throws InterruptedException {

		Thread.sleep(2000);
		WebElement ele = Global.driver.findElement(By.xpath("//android.view.View[@index='0']"));
		TouchAction touch = new TouchAction((MobileDriver) Global.driver);
		touch.press(ele).waitAction(3000).moveTo(1188, 1328).release().perform();
	}

	public static void getlocation_id(String value) {
		org.openqa.selenium.Point x = Global.drive.findElement(By.id(value)).getLocation();
		x.getX();
		x.getY();
		TouchAction act = new TouchAction(Global.drive);
		act.tap(x.getX(), x.getY()).perform();
		System.out.println(x.getX() + x.getY());

	}
	public static void getlocation_xpath(String value) {
		org.openqa.selenium.Point x = Global.drive.findElement(By.xpath(value)).getLocation();
		x.getX();
		x.getY();
		
		TouchAction act = new TouchAction(Global.drive);
		act.tap(x.getX(), x.getY()).perform();
		System.out.println(x.getX() + x.getY());

	}
	public static void horizontalswipe(int starty,int endy,int duration) {
		Global.driver.swipe(0, starty, 0, endy, duration);
	}
	public static void verticalswipe(int startx,int endx,int duration) {
		Global.driver.swipe(startx, 0, endx, 0, duration);
	}*/
	
}
