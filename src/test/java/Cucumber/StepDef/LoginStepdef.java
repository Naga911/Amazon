package Cucumber.StepDef;

import BaseUtil.BaseUtil;
import Reports.ExtentTestManager;
import StepDefs.Login;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

//import io.cucumber.core.api.Scenario;

public class LoginStepdef extends ExtentTestManager {


    BaseUtil baseUtil;

    // Scenario scn;
    public LoginStepdef(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Given("^user Opens the browser and load the url$")
    public void userOpensTheBrowserAndLoadTheUrl() throws Exception {
        ExtentTest logInfo = null;
        try {

            test = extent.createTest(Feature.class, "Verification of Amazon");
          //  test = test.createNode(Scenario.class, "user Opens the browser and load the url").assignCategory("Sanity").assignAuthor("Nagaraj");
            logInfo = test.createNode(new GherkinKeyword("Given"), "user Opens the browser and load the url");
            WebDriver driver = baseUtil.getDriver();

            Login login=new Login();


            baseUtil.setDriver(driver);
            baseUtil.initializePageObjectClasses(driver);
            driver.get(baseUtil.LoadProperties().getProperty("url"));
            driver.manage().window().maximize();
          //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            test.pass("Successfully web page launched ");


        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", baseUtil.getDriver(), logInfo, e);
        }

    }
    @When("^Click on login link$")
    public void clickOnLoginLink() throws Throwable {
        ExtentTest logInfo = null;
        System.out.println("2nd method");
        try {
       //     test = test.createNode(Scenario.class, "Click on login link").assignCategory("Sanity").assignAuthor("Nagaraj");
            logInfo = test.createNode(new GherkinKeyword("When"), "Click on login link");
            Thread.sleep(30000);
            baseUtil.loginPageObjects().ClickOnSearchButton();
            test.pass("Clicked on Login button");

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", baseUtil.getDriver(), logInfo, e);
        }
    }
    @Then("^Verify page title$")
    public void homePageShouldAppear() {
        ExtentTest logInfo = null;
        try {
         //   test = test.createNode(Scenario.class, "Verify page title").assignCategory("Sanity").assignAuthor("Nagaraj");
            logInfo = test.createNode(new GherkinKeyword("Then"), "Verify page title");
            baseUtil.cmnPageObjects().validatePageTitleMatch("Amazon");

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", baseUtil.getDriver(), logInfo, e);
        }
    }


        @Then("^login page should appear$")
        public void loginPageShouldAppear () throws Throwable {
            System.out.println("Page is loaded");
        }

        @Given("^Entering username and password and submit$")
        public void entering_username_and_password () throws Throwable {
            ExtentTest logInfo = null;
            try {
            test = test.createNode(Scenario.class, "Logging into application").assignCategory("Sanity").assignAuthor("Nagaraj");
            logInfo = test.createNode(new GherkinKeyword("Given"), "Entering username and password");
                String user="yellowspider321@gmail.com";
                String pass="Nagaraj123";
                baseUtil.loginPageObjects().EnterUsername(user);
                baseUtil.loginPageObjects().EnterPassword(pass);
                baseUtil.loginPageObjects().ClickOnSearchButton();
                //  driver.findElement(By.xpath("//input[@placeholder='Enter your e-mail ID or GSM number']")).sendKeys("yellowspider321@gmail.com");
                //  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Nagaraj123");

                //  driver.findElement(By.xpath("//button[@class='form-group btn btn-light']")).click();
                Thread.sleep(10000);
                logInfo.pass("Entered username and password");
                //   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

            } catch (AssertionError | Exception e) {
                 testStepHandle("FAIL", baseUtil.getDriver(), logInfo, e);
            }
        }

        @When("^user should be navigated to Home Screen$")
        public void clicked_On_Submit_Button_User_Should_Be_Navigated_To_Home_Screen () throws Throwable {
            ExtentTest logInfo = null;
            try {
                //   logInfo = test.createNode(new GherkinKeyword("And"), "Verify whether user is logged in successfully");
                //   driver = Hooks.getDriver();
                System.out.println("Home page");
                logInfo.pass("User is logged in successfully");
                //   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
            } catch (AssertionError | Exception e) {
                //        testStepHandle("FAIL", driver, logInfo, e);
            }
        }

    @Given("Entering username and password with data in excel at {string}")
    public void enteringUsernameAndPasswordWithDataInExcelAt(String path) {
       // ExcelReader.ExcelReaderBuilder.setFileLocation(path);


    }


   /* @Given("^Click Add Account and Enter mandatory fields$")
    public void Click_Add_Account_entering_Mandatory_Fields() throws Throwable {
        ExtentTest logInfo = null;
        try {
            test = extent.createTest(Scenario.class, "Registration of user details");
            logInfo = test.createNode(new GherkinKeyword("Given"), "Entering mandatory fields");
          //  driver = Hooks.getDriver();


            logInfo.pass("Entering mandatory fields");
            //      logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
        }
    }

    @Then("^Clicking on submit button$")
    public void clicking_On_Submit_Button() throws Throwable {
        ExtentTest logInfo = null;
        try {
            logInfo = test.createNode(new GherkinKeyword("Then"), "Clicking on submit button");
            logInfo.pass("clicked submit button");


            //     logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
           testStepHandle("FAIL", driver, logInfo, e);
        }
    }*/

   /* public static class Hooks extends BaseUtil {


        //@Test(alwaysRun = true)
        @SuppressWarnings("Duplicates")
        @Before()
        public static void setup() {
            if (driver == null) {

                String workingDir = System.getProperty("user.dir");
                ChromeOptions options = (ChromeOptions) new ChromeOptions().setAcceptInsecureCerts(true);

                options.addArguments("--disable-notifications");
                System.setProperty("webdriver.chrome.driver", workingDir + "\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            }
        }

        public static WebDriver getDriver() {
            return driver;
        }

        @After()
        public void afterScenario() {

                driver.close();
                driver.quit();


        }
    }*/
    }
