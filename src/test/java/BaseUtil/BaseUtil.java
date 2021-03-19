package BaseUtil;

import PageObjects.CmnPageObjects;
import PageObjects.LoginPageObjects;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseUtil {

    protected String server = LoadProperties().getProperty("url");
    private WebDriver driver;
    private LoginPageObjects LoginPageObjects;
    private CmnPageObjects CmnPageObjects;

    public WebDriver getDriver() {

        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObjects loginPageObjects() {
        return LoginPageObjects;
    }

    public CmnPageObjects cmnPageObjects() {
        return CmnPageObjects;
    }

    public void initializePageObjectClasses(WebDriver driver) {

        LoginPageObjects = new LoginPageObjects(driver);
        CmnPageObjects = new CmnPageObjects(driver);
    }

    public Properties LoadProperties() {


        String path = System.getProperty("user.dir");
        //InputStream inStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Device Configuration properties file cannot be found");
        }

        return prop;
    }
}
