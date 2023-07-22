package extentReport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup extends ExtentRepo

{

	public static ExtentReports SetupextentReport() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/ExtentReport/ExecutionReport_" + actualdate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "https://rqe-dev.locationinc.com/users/sign_in");
		extent.setSystemInfo("RQE", "QA Team");
		extent.setSystemInfo("Date", actualdate);
		
		
		sparkReport.config().setDocumentTitle("Automation RQE");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName(" CoreLogic Cat Risk RQE ");
		return extent;

	}

}
