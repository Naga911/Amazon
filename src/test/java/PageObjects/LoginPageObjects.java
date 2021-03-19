package PageObjects;

import Utilities.Generic;
import io.cucumber.core.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageObjects extends Generic {

    private final By clickElement = By.xpath("//button[contains(text(),'Login')]");
    private final By username = By.xpath("//input[@placeholder='Enter your e-mail ID or GSM number']");
    private final By password = By.xpath("//input[@placeholder='Password']");


    Scenario scn;

    public LoginPageObjects(WebDriver driver) {
        setDriver(driver);
      //  this.scn = s;
    }
        public void ClickOnSearchButton () {
            clickElement(clickElement);
           // logger.info("Clicked on Search Button");
        }
        public void EnterUsername(String user)
        {
          //  setElement(By.(username),user);
        }

    public void EnterPassword(String pass)
    {
        setElement(By.xpath(String.valueOf(password)),pass);
    }
    }


/*    @Test
    public void softAssertTest() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(2,2,"Error on 1st validation");
        soft.assertEquals(1,1,"Error on 2nd validation");
        soft.assertEquals(1,2,"Error on 3rd validation");
        soft.assertEquals(2,1,"Error on 4th validation");
        soft.assertAll();
    }*/
