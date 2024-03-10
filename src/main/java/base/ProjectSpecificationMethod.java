package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Utils.Utility;

public class ProjectSpecificationMethod extends Utility {

	// Public method to launch browser and load url
	// Parameter tag to pass the browser and url values from testng xml
	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void browserLaunch(String browser, String url) {
		launchBrowser(browser, url);
	}

	// Public method to close browser
	@AfterMethod
	public void browserClose() {
		closeBrowser();
	}

	// Public method to read data from excel sheet
	@DataProvider(name = "ReadfromExcel")
	public String[][] excelRead() throws IOException {
		String[][] data = readExcel(excelFile, sheetName);
		return data;
	}

}