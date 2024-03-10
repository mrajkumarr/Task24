package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {

//Page factory to inspect element inside constructor
	@FindBy(id = "login2")
	WebElement login;

	@FindBy(id = "signin2")
	WebElement signup;

//Parameterized constructor to pass driver as argument
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Method that returns by creating an object for LoginPage class
	public LoginPage loginButton() {
		login.click();
		return new LoginPage(driver);
	}

//Method that returns by creating an object for SignUpPage class
	public SignUpPage signupButton() {
		signup.click();
		return new SignUpPage(driver);
	}

}