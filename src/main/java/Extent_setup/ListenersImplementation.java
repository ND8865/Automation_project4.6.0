package Extent_setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenersImplementation extends extentRepo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case :" + result.getMethod().getMethodName() + " is Pass");

		String text = "The Test Case is Pass";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		test.log(Status.PASS, m);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case :" + result.getMethod().getMethodName() + " is failed");
		test.log(Status.FAIL, result.getThrowable());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		String screenshotpath = System.getProperty("user.dir") + "/ExtentReport/ScreenShots_" + actualdate + ".jpeg";
		File dest = new File(screenshotpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(screenshotpath, "Test Case failure screenshot");
		String text = "The Test Case is Failed";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		test.log(Status.PASS, m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String text = "The Test Case is Skip";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.YELLOW);
		test.log(Status.PASS, m);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extent = extentReportSetup.SetupextentReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
