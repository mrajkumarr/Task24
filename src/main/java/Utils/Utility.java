package Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

//Public driver instance	
	public static WebDriver driver;

//Public instance of Excel file 
	public String excelFile;

//Public instance of Excel sheet name
	public String sheetName;

//Public method to launch browser and load url
	public void launchBrowser(String browser, String url) {

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

//Public method to close browser
	public void closeBrowser() {
		driver.close();
	}

//Public method to perform click operation
	public void click(WebElement ele) {
		ele.click();
	}

//Public method to find an element and enter text
	public void findElementAndSendKeys(String attributevalue, String value) {
		driver.findElement(By.id(attributevalue)).sendKeys(value);
	}

	// public method to explicit wait for visibility of element
	public void visibiltiyofElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

//Public method to read data from Excel file
	public String[][] readExcel(String excelfile, String sheetname) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Users\\mrajk\\eclipse-workspace\\Task24\\data\\" + excelfile + ".xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);

		// Getting the row count and column count
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		// Two dimensional array to store row and column values of cells
		String[][] data = new String[rowCount][columnCount];

		// Get into row
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Get into cell
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		// Closing the book
		book.close();
		return data;
	}

//Public method to generate random user name for Sign up functionality	
	public String randomNameGenerator() {

		// Creating string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// Creating random string builder
		StringBuilder sb = new StringBuilder();

		// creating an object of random class
		Random random = new Random();

		// Specifying the length of random string
		int length = 7;

		for (int i = 0; i < length; i++) {
			// Generating random index number
			int index = random.nextInt(alphabet.length());

			// Getting the character based on the specified index
			char randomChar = alphabet.charAt(index);

			// Appending the character to string builder
			sb.append(randomChar);

		}
		String name = sb.toString();
		System.out.println("The random string is " + name);
		return name;
	}

//Public method to take screenshot with time stamp
	public String takeScreenshot(String screenshotName) throws IOException {
		Date d = new Date();
		String date = d.toString();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\mrajk\\eclipse-workspace\\Task24\\Screenshots\\" +screenshotName+".png";
		//System.out.println("Screenshot" +path);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

}