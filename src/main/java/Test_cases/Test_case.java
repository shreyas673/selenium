package Test_cases;

import Test_suite.Landing_page;
import Test_suite.ExtentReporterNG;
import Test_suite.Test_Base;
import org.testng.annotations.Test;

public class Test_case extends Test_Base {

    Landing_page landing_page;
    ExtentReporterNG report;

    @Test
    public void Test_case01(){


        initialize_URL();
      landing_page=new Landing_page(driver);
      landing_page.Login_to_loginPage("samdamoo1968@gmail.com","Sam@1999");



    }
}
