package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.DriverClass;

public class Login_page extends DriverClass {
	public Login_page() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='user_email']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='user_password']")
	private WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-primary btn-block sign-in submit-btn']")
	private WebElement SignIn;

	public boolean Verifyusername() {
		username.click();
		username.sendKeys(propertyUtility.GetData.getcred("UserName"));

		if (username.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean Verifypassword() {
		password.click();
		password.sendKeys(propertyUtility.GetData.getcred("Password"));
		return true;

	}

	public boolean clickonsignin() {
		SignIn.click();
		return true;
	}

public boolean failtestcase()
{
	username.isEnabled();
	return false;
	
			
}

}




