package extentReport;

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

public class ListenersImplementation extends ExtentRepo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "" + result.getMethod().getMethodName() + " is Passed");
		String text = "#The test case has passed.";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		test.log(Status.PASS, m);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "" + result.getMethod().getMethodName() + " is failed");
		test.log(Status.FAIL, result.getThrowable());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		String screenshotpath = System.getProperty("user.dir") + "/TestCaseFailedScreenShoot/ScreenShots_" + actualdate
				+ ".jpeg";
		File dest = new File(screenshotpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(screenshotpath, "Test Case failure screenshot");
		String text = "#The test case has failed.";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		test.log(Status.PASS, m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String text = "The test case is skipped.";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.YELLOW);
		test.log(Status.PASS, m);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReportSetup.SetupextentReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
