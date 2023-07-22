package testClasses;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseLibrary.DriverClass;
import pageClasses.Login_page;
import waitClass.WaitClass;

public class Login_test extends DriverClass {
	Login_page action;

	@BeforeTest
	public void getlaunch() {

		getlaunch("chrome", propertyUtility.GetData.geturl("URL"));
		action = new Login_page();

	}

	@Test(priority = 1, description = " Verify that user is able to Enter the username. ", enabled = true)
	public void Verifyusername() {
		WaitClass.waitForTime(1000);
		action.Verifyusername();

	}

	@Test(priority = 2, description = " Verify that user is able to Enter the Password. ", enabled = true)
	public void VerifyPassword() {
		action.Verifypassword();
	}

	@Test(priority = 3, description = " Verify that user is able to click on the sign button ", enabled = true)
	public void clickonSignin() {
		action.clickonsignin();
	}

	@Test(priority = 4, description = "  ", enabled = true)
	public void failtest() {
		action.failtestcase();
	}


}
