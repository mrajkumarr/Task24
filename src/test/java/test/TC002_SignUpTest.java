package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC002_SignUpTest extends ProjectSpecificationMethod {

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		excelFile = "TestData";
		sheetName = "SignUpTest";
	}

	@Test(dataProvider = "ReadfromExcel")
	public void SignUpTest(String Username, String Password, String DataMatch) throws InterruptedException{
		// TODO Auto-generated method stub

		HomePage obj = new HomePage(driver);
		obj.signupButton()
		.singUpUserName(Username)
		.singUpPassword(Password)
		.signUpButton();

		// Validating test cases using assertion for login functionality
		if (DataMatch.equals("newUser")) {
			// Using thread to get the text name after successful Signup
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"Sign up successful.");

		} else if (DataMatch.equals("ExistingUser")) {
			//Using thread to get the text from alert and accept it 
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"This user already exist.");

		} else if (DataMatch.equals("InvalidUserName")) {
			//Using thread to get the text from alert and accept it 
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"Invalid user name. Please enter a valid username");

		} else {
			//Using thread to get the text from alert and accept it 
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"Invalid password. Please enter a valid password");

		}
	}

}