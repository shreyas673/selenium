package Test_suite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class Test_Base {

     public WebDriver driver;


    @BeforeMethod

    public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      return driver;

    }

    public void initialize_URL(){
        driver.get("https://rahulshettyacademy.com/client/");
        driver.manage().window().maximize();
    }

    public String take_screenshot(String testname,WebDriver driver) throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File source=screenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"\\"+testname+".png";
        FileUtils.copyFile(source, new File(path));
        return path;
    }
}
