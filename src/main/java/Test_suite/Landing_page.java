package Test_suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_page extends Test_Base {
    WebDriver driver;

    public Landing_page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }


        @FindBy(xpath ="//input[@id='userEmail']")
         WebElement user_Email;

        @FindBy(xpath ="//input[@id='userPassword']")
        WebElement password;

        @FindBy(xpath = "//input[@id='login']")
        WebElement login_button;


        public void Login_to_loginPage(String useremail,String Password){
            user_Email.sendKeys(useremail);
            password.sendKeys(Password);
            login_button.click();

    }


}
