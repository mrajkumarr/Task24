package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signup;

	//Parameterized constructor to pass driver as argument
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Method to fill username from Data provider
	public SignUpPage singUpUserName(String username) {
		// driver.findElement(By.id("sign-username")).sendKeys("Magiinthan");
		findElementAndSendKeys("sign-username", username);
		return this;
	}

	//Method to fill password from Data provider
	public SignUpPage singUpPassword(String password) {
		// driver.findElement(By.id("sign-password")).sendKeys("Pasword@123");
		findElementAndSendKeys("sign-password", password);
		return this;
	}

	//Method to click SignUp button
	public SignUpPage signUpButton() {
		// WebElement signup = driver.findElement(By.xpath("//button[text()='Sign
		// up']"));
		signup.click();
		return this;
	}
}