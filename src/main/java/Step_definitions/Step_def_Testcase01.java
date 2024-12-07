package Step_definitions;

import Test_suite.Landing_page;
import Test_suite.Test_Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Step_def_Testcase01 extends Test_Base {

    Landing_page landing_page;

    @Given("I navigate to URL")
    public void i_navigate_to_url() {
        setup();
        initialize_URL();
    }
    @When("I enter {string} and {string}")
    public void i_enter_and(String email, String password) {
        landing_page=new Landing_page(driver);
        landing_page.Login_to_loginPage(email,password);
    }
    @When("I click on login button")
    public void i_click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.close();
    }

}
