import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class standalone_testcase {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("samdamoo1968@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"userPassword\"]")).sendKeys("Sam@1999");
        driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
        Thread.sleep(5000);
        List<WebElement> products=driver.findElements(By.xpath("//div[contains(@class,\"mb-3\")] "));
        WebElement prod=products.stream().filter(product->
                product.findElement(By.tagName("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.xpath("//div[@class=\"card-body\"]//button[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"toast-container\"]")));

        driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();
        List<WebElement>names=driver.findElements(By.xpath("//li[contains(@class,\"ng-star-inserted\")]//h3"));
        Boolean match=names.stream().anyMatch(name->name.getText().equalsIgnoreCase("ZARA COAT 3"));

        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[contains(@class,\"btn-primary\")])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[contains(@class,\"text-validated\")])[3]")).sendKeys("Ind");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(@class,\"ng-star-inserted\")][2]")).click();

        WebElement click_ele = driver.findElement(By.xpath("//a[contains(@class,\"ng-star-inserted\")]"));

        Thread.sleep(5000);
        driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText().equalsIgnoreCase("Thankyou for the order.");






    }

}
