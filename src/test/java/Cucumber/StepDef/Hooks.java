package Cucumber.StepDef;

import BaseUtil.BaseUtil;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

public class Hooks extends BaseUtil {

    private WebDriver driver;
    private BaseUtil baseUtil;
    public Hooks(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }


    //@Test(alwaysRun = true)
    @SuppressWarnings("Duplicates")
    @Before
   public void setup() throws IOException {
        if ( driver== null) {
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path +"\\TestFine\\Drivers\\chromedriver.exe");
            ChromeOptions options = (ChromeOptions) new ChromeOptions().setAcceptInsecureCerts(true);

            baseUtil.setDriver(new ChromeDriver());
        }
    }
    @After
    public void tearDownTest(){
        baseUtil.getDriver().close();
    }
}

