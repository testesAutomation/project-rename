package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static utils.DriverHelper.closeDriverWeb;

@CucumberOptions(
        strict = true,
        glue = "steps",
        tags = "",
        plugin = {"json:target/json-cucumber-reports/cukejson.json",
                "testng:target/testng-cucumber-reports/cuketestng.xml",
                "rerun:target/rerun.txt",
        },
        features = "src/main/java/features")
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
        closeDriverWeb();
    }
}
