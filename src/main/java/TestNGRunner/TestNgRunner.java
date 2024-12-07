package TestNGRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\main\\java\\Cucumber_Files",
glue="Step_definitions",
monochrome = true,plugin ={"html:target/cucumber.html"})

public class TestNgRunner extends AbstractTestNGCucumberTests {
}
