package applicationUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import baseLibrary.DriverClass;
import propertyUtility.GetData;

public class Utilities extends baseLibrary.DriverClass {

	static Select sel;
	public static String StrDt;
	static int timeout = 80;
	// This method is used for select drop-down values using contains.

	public static void dropdownTextContains(WebElement element, String text) {
		try {
			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String txt = webElement.getText();
				if (txt.contains(text)) {
					sel.selectByVisibleText(txt);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in drop down value selection");
			e.printStackTrace();
		}
	}

	public static void dropdownTextEqualIgnoreCase(WebElement element, String text) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String txt = webElement.getText();
			if (txt.equalsIgnoreCase(text)) {
				sel.selectByVisibleText(txt);
				break;
			}
		}
	}

	public static void dropdownValue(WebElement element, String value) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String val = webElement.getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				sel.selectByValue(val);
				break;
			}
		}
	}

	public static void getddpvalueusingstring(WebDriver driver, String strval, String Strddpval) {
		try {
			WebElement drp_element = driver.findElement(By.xpath(strval));
			Select Sel = new Select(drp_element);
			Sel.selectByVisibleText(Strddpval);
		} catch (Exception e) {
			System.out.println("Exception value selection.");
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}

	public static void dropdownIndex(WebElement element, int index) {
		try {
			sel = new Select(element);
			sel.selectByIndex(index);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String[] split(String inputstring, String regex) {
		return inputstring.split(regex);
	}

	public static String getTextandCloseAlert(WebDriver driver) {
		try {
			boolean acceptNextAlert = true;
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				if (acceptNextAlert) {
					alert.accept();
				} else {
					alert.dismiss();
				}
				return alertText;
			} finally {
				acceptNextAlert = true;
			}
		} catch (Exception e) {
			System.out.println("Alert message clicked.");
		}
		return StrDt;
	}

	public static void Focuschange(WebDriver driver, String strfocusobject, int iwaittimemilisend) {
		try {
			driver.findElement(By.xpath(strfocusobject)).click();
			Thread.sleep(iwaittimemilisend);

		} catch (Exception e) {
			System.out.println("Exception while focus change!" + e.getMessage());
		}

	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			Reporter.log("No Alert Present.", true);
			return false;
		}
	}

	public static void acceptAlert(WebDriver driver) {
		boolean bool = true;
		bool = isAlertPresent(driver);
		if (bool) {
			driver.switchTo().alert().accept();
		}
	}

	public static String getAlertText(WebDriver driver) {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			return alertText;
		} catch (Exception ex) {
			System.out.println(ex);
			return alertText;
		}

	}

	// method used to get alert text and close for custom control
	public static String getalerttextnclose(WebDriver driver) {
		String altext = "";
		try {
			altext = driver.findElement(By.xpath("//*[@id='lblMesg']")).getText();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='Img1']")).click();

		} catch (Exception ex) {
			System.out.println("Issue in get value from alert text.");
		}

		return altext;

	}

	/// method to highlight the click Area
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: Green; border: 15px solid blue;');", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

	}

	// Common method to open new tab
	public void Ntab(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

	}

	// Common method to quit from Driver
	public void Fun_DriverQuit(WebDriver driver) {
		try {
			driver.quit();
			driver = null;
		} catch (Exception e) {
			System.out.println("Exception on quit from Browser !");
		}
	}

	public void switchToTab(WebDriver driver) {
		// Switching between tabs using CTRL + tab keys.
		try {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
			// Switch to current selected tab's content.
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Exception in Switch tab.");
		}

	}

	// Common method to Object identification
	public static boolean Fun_IsElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true; // Success!
		} catch (Exception ignored) {

			System.out.println("Exception in Object Identification ! ");
			return false;
		}
	}

	// Common method to IB page in
	public void openIB(WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			String StrURLIB = GetData.geturl("urlIB");
			driver.get(StrURLIB);
		} catch (Exception e) {
			System.out.println("Exception in open IB page");
			e.printStackTrace();
		}
	}

	// Method for mouse-hover and click
	public static void MouseHovernclick(WebDriver driver, String Strhoverobj, String Strobjclick) {
		try {
			WebElement element = driver.findElement(By.linkText(Strhoverobj));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(4000);
			driver.findElement(By.linkText(Strobjclick)).click();
		} catch (Exception ex) {
			System.out.println("Exception in MouseHovern click");
		}
	}

	// Method for Get numbers from String
	public long getnumberfromstr(String strval) {
		long tokenno = (long) Double.parseDouble(strval.replaceAll("[^0-9\\.]+", ""));
		return tokenno;
	}

	/// Function for Remove space of given String
	public static String Fun_RemoveSpace(String stringvalue) {
		String withoutspaces = "";
		char ch = 'a';
		for (int i = 0; i < stringvalue.length(); i++) {
			ch = stringvalue.charAt(i);
			if (ch != 32)
				withoutspaces += stringvalue.charAt(i);
		}
		return withoutspaces;
	}

	public void Scroll_Page_To_Bottom(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception ex) {
			System.out.println("Exception scroll.");
		}
	}

	public static void Inner_scrolltoptobottom(WebDriver driver, WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop = arguments[1];", ele, 500);
		} catch (Exception ex) {
			System.out.println("Exception in inner scroll.");
		}

	}

	public static void Inner_scrolllefttoright(WebDriver driver, WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollLeft = arguments[1];", ele, 500);
		} catch (Exception ex) {
			System.out.println("Exception in inner scroll.");
		}

	}

	// Method for Clear the all textbox
	public static void CleartextCollection(WebDriver driver) {
		try {
			List<WebElement> links = driver.findElements(By.tagName("input"));
			System.out.println(links.size());
			for (int i = 0; i < links.size(); i++) {
				if (links.get(i).isDisplayed() == true) {
					links.get(i).clear();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in clear all text box.");
			e.printStackTrace();
		}
	}

	/*
	 * public static void DynamicWait(WebDriver driver, String StrXpath) { try {
	 * WebDriverWait wait = new WebDriverWait(driver, 200);
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(StrXpath)
	 * )); } catch (Exception e) {
	 * System.out.println("Exception dynamic wait mathod."); } }
	 */

	// Method to get the number from string
	public static String getnoofstring(String strvalue, String strsign) {
		String strfinal = "";
		try {
			strfinal = strvalue.substring(strvalue.lastIndexOf(strsign) + 1);
			strfinal = strfinal.trim();
			return strfinal;
		} catch (Exception e) {
			e.printStackTrace();
			return strfinal;
		}
	}

	public static void closepopup(WebElement element, WebDriver driver) {
		element.click();

	}

	public static String getalerttext(WebDriver driver, WebElement WebElmentMessage) {
		String altext = "";
		try {
			altext = WebElmentMessage.getText();
			Thread.sleep(1000);
			return altext;
		} catch (Exception ex) {
			System.out.println("Issue in get value from alert text.");
		}
		return altext;
	}

	// method used to close for custom control
	public static void AlertClose(WebDriver driver, WebElement WebElmentclose) {

		try {
			Thread.sleep(1000);
			WebElmentclose.click();

		} catch (Exception ex) {
			System.out.println("Issue in get value from alert text.");
		}
	}

	public static void Mouseover_action(WebDriver driver, WebElement ele) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
		} catch (Exception e) {
			System.out.println("Issue in Mouse hover action");
		}
	}

	public static String Phoenixalertclose(WebDriver driver) {
		String Strmsg = "";
		try {
			WebElement Weblmsg = driver.findElement(By.xpath("//*[@id='alertDiv']/p"));
			Strmsg = Weblmsg.getText();
			driver.findElement(By.xpath("//*[@id='btnClose'][@style='float:right;']")).click();
			return Strmsg;
		} catch (Exception e) {
			System.out.println("Issue in get alert Message");
			return "";
		}
	}

	public static void doubleclick(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele);
		action.clickAndHold(ele);
		action.doubleClick().build().perform();
	}

	public static String reversedate(String date, String regin) {
		String revdate = "";
		try {
			String datesplit[] = Utilities.split(date, regin);
			String year = datesplit[2];
			String month = datesplit[1];
			String day = datesplit[0];
			revdate = year + regin + month + regin + day;
		} catch (Exception e) {
			System.out.println("Issue in reverse date");
		}
		return revdate;
	}

	public static String GetdateTime() {
		String datetime = null;
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yy");
			Date dateobj = new Date();
			df.format(dateobj);
			datetime = df.format(dateobj);
			return datetime;
		} catch (Exception e) {
			System.out.println("Issue in Getdatetime" + e);
		}
		return datetime;
	}

	public static int getRandomNumber(int start, int end) {
		int number = 0;
		try {
			number = (int) Math.random() * start + end;
			return number;
		} catch (Exception e) {
			System.out.println("Issue in Random Number");
		}
		return number;
	}

	public static By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith(".//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else if (locator.startsWith("id=")) {
			result = By.id(locator.replace("id=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}

	public static void sendKeys(String locator, String text) {
		try {

			WebElement el = driver.findElement(ByLocator(locator));
			el.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int RandomNumber() {
		int randomNumber = 0;
		try {
			Random objGenerator = new Random();
			for (int i = 0; i < 10; i++) {
				randomNumber = objGenerator.nextInt(1000);
			}
			return randomNumber;
		}

		catch (Exception e) {
			System.out.println("issue in Random number" + e);
		}
		return randomNumber;

	}

	public static void uploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(150);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			System.out.println("Issue in RobotUpload file");
		}

		robot.delay(250);

	}

	public static void ChangeWindow(int tab) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(DriverClass.driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tab));
		} catch (Exception e) {
			System.out.println("Issue in ChangeWindow" + e);
		}
	}

	public static void draganddropbyIndex(WebElement element, int x, int y) {
		try {
			Actions act = new Actions(driver);
			act.dragAndDropBy(element, x, y).build().perform();
		} catch (Exception e) {
			System.out.println("Issue in draganddropbyIndex" + e);
		}
	}

	public static void Slider(String element) {
		try {
			WebElement Slider = driver.findElement(By.xpath(element));
			Actions SliderAction = new Actions(driver);
			SliderAction.clickAndHold(Slider).moveByOffset((50), 0).release().perform();
		} catch (Exception e) {
			System.out.println("issue in Slider" + e);
		}
	}

	public static void scrollByXPath(WebElement xpath) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", xpath);
		} catch (Exception e) {
			System.out.println("Issue in ScrollByxpath" + e);
		}
	}

}
