package Extent_setup;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportSetup extends extentRepo

{
	
	public static ExtentReports SetupextentReport()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate =format.format(date);
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport/ExecutionReport_"+actualdate+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitel");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Project Name");
		return extent;
	
	}

}
