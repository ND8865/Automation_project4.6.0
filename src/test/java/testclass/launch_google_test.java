package testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Baselibrary.BaseLibrary;
import pageclass.launch_google;

public class launch_google_test extends BaseLibrary {
	launch_google page;

	@BeforeTest
	public void getlaunch() {

		getlaunch("chrome", property_utility.PropertyUtility_Code.getdatafromfile("URL"));
		page = new launch_google();

	}

	@Test
	@Parameters()
	public void sendkey() throws InterruptedException {
		page.sendkey();
		Thread.sleep(8000);
	
	}

	@Test(priority = 2, description = " Verify that method is failed ", enabled = true)
	public void Failedmethod() throws InterruptedException {
		page.getfailed();
		Thread.sleep(8000);

	}

}
