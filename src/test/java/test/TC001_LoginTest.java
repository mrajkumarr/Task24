package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC001_LoginTest extends ProjectSpecificationMethod {

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		excelFile = "TestData";
		sheetName = "LoginTest";
	}

	@Test(dataProvider = "ReadfromExcel")
	public void LoginTest(String username, String password, String dataMatch) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// randomNameGenerator();
		HomePage obj = new HomePage(driver);
		obj.loginButton().userName(username).password(password).logInButton();

		// Validating test cases using assertion for login functionality
		if (dataMatch.equals("bothCorrect")) {
			// Using thread to get the text name after successful login
			Thread.sleep(2000);
			WebElement name = driver.findElement(By.id("nameofuser"));
			System.out.print(name.getText());
			Assert.assertTrue(name.isDisplayed());

		} else if (dataMatch.equals("wrongPassword")) {
			// Using thread to get the text from alert and accept it
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"Wrong password.");

		} else if (dataMatch.equals("wrongUsername")) {
			// Using thread to get the text from alert and accept it
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"User does not exist.");

		} else {
			// Using thread to get the text from alert and accept it
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			Assert.assertEquals(text,"Invalid user name and password");
		}

	}

}