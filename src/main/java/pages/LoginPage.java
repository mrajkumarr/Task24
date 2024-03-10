package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethod;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LoginPage extends ProjectSpecificationMethod {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement login;

	//Parameterized constructor to pass driver as argument
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Method to fill username from Data provider
	public LoginPage userName(String username) {
		findElementAndSendKeys("loginusername", username);
		return this;
	}

	//Method to fill password from Data provider
	public LoginPage password(String password) {
		findElementAndSendKeys("loginpassword", password);
		return this;
	}

	//Method to click SignUp button
	public LoginPage logInButton() throws InterruptedException {
		login.click();
		return this;
	}

}