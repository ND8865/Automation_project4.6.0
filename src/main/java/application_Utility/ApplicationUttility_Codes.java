package application_Utility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baselibrary.BaseLibrary;

public class ApplicationUttility_Codes extends BaseLibrary
{

public static void doublecclick(WebElement ele)
{
	Actions  act = new Actions(driver);
	act.doubleClick(ele).perform();
}
public static void rightclick( WebElement ele)
{
	Actions  rightclick = new Actions(driver);
	rightclick.contextClick(ele).perform();
}

public static void dropdownvalue(WebElement ele , String value)
{
	Select sel  = new Select(ele);
	sel.selectByVisibleText(value);
}

public static void fileupload(String location) throws AWTException   // awt class
{
	StringSelection sel = new StringSelection(location);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(sel, null);
	Robot robo = new Robot();
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.keyRelease(KeyEvent.VK_ENTER);
	robo.keyPress(KeyEvent.VK_CONTROL);
	robo.keyPress(KeyEvent.VK_V);
	robo.keyRelease(KeyEvent.VK_V);
	robo.keyRelease(KeyEvent.VK_CONTROL);
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.delay(200);
	robo.keyRelease(KeyEvent.VK_ENTER);
	
}
public static String datepick()
{
	String Date;
	SimpleDateFormat  df = new SimpleDateFormat("MM-dd-yyyy");
	Date   dt = new Date();
	    Date = df.format(dt);
	   return Date;
}
public static String datepicktime()
{
	String Date1;
	SimpleDateFormat  df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
	Date   dt = new Date();
	    Date1 = df.format(dt);
	   return Date1;
}
	public static void mousehoverd(WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}


public static void getwait()
{
	
}
}


