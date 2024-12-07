package Test_suite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG extends Test_Base{



    public static ExtentReports report_setup() {
        String path = System.getProperty("user.dir")+"\\Reports\\Reports.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Automation Repots");
        reporter.config().setDocumentTitle("Test Results");

       ExtentReports extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Shreyas");

        return extent;


    }


}
