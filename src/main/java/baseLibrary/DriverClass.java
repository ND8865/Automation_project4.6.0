package baseLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;

public class DriverClass {

	public static WebDriver driver;

	public void getlaunch(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
			driver = new ChromeDriver(chromeOptions);
			driver.get(url);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions fireoptions = new FirefoxOptions();
			fireoptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();

	}

}
