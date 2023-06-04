package screenshoot_utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import  Baselibrary.BaseLibrary;

public class ScreenShootUtility_Code extends BaseLibrary
{
   
	public static String getscreenshoot(WebDriver driver , String Screenshoot) throws IOException
{
	
	try 
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/FailedTestsScreenshots/";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	} 
	
	catch (Exception e)
	
	{
		return null;
	}
	
	
	
}



}
