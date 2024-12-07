package Test_suite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Test_Base implements ITestListener {
    ExtentTest test;
   ExtentReports extent= ExtentReporterNG.report_setup();
   ThreadLocal<ExtentTest>extent_test=new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        test=extent.createTest(iTestResult.getMethod().getMethodName());
        extent_test.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extent_test.get().log(Status.PASS,"PASS");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
     extent_test.get().fail(iTestResult.getThrowable());
     try {
      driver=(WebDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
     } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
     } catch (NoSuchFieldException e) {
      throw new RuntimeException(e);
     }

     String filepath;
     try {
      filepath = take_screenshot(iTestResult.getMethod().getMethodName(),driver);

     } catch (IOException e) {
      throw new RuntimeException(e);
     }
     try {
      extent_test.get().addScreenCaptureFromPath(filepath, iTestResult.getMethod().getMethodName());
     } catch (IOException e) {
      throw new RuntimeException(e);
     }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
     extent.flush();

    }
}
