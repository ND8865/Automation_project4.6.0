package pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baselibrary.BaseLibrary;

public class launch_google extends BaseLibrary
{
	public launch_google() {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//*[@id=\"APjFqb\"]")
	private WebElement input;
	
	
	public boolean sendkey()
	{
		input.sendKeys("nishant");
		return false;
	}

public boolean getfailed()
{
	input
	return false;
}

}
