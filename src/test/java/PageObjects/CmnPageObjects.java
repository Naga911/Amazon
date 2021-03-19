package PageObjects;

import Utilities.Generic;
import io.cucumber.core.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CmnPageObjects extends Generic {
	//private static final Logger logger = LogManager.getLogger(pageobjects.CmnPageObjects.class);
	Scenario scn;

	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	private By hamburger_menu_link =  By.id("nav-hamburger-menu");
	private By nav_link_logo =  By.xpath("//a[@class='nav-logo-link']");
	private By nav_link_cart =  By.id("nav-cart");
	private By nav_link_prime =  By.id("nav-link-prime");
	private By nav_link_orders =  By.id("nav-orders");
	private By nav_link_acount =  By.id("nav-link-accountList");

	private String hamburger_menu_category_link_xpath =  "//div[@id='hmenu-content']//div[text()='%s']";
	private String hamburger_menu_sub_category_link_xpath =  "//div[@id='hmenu-content']//a[text()='%s']";

	public CmnPageObjects(WebDriver driver) {
		setDriver(driver);
	//	this.scn = s;
	}

	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
		//logger.info("Value enetered in search box: " + text);
		takeScreenShotAndAttachInReport(scn);
	}

	public void ClickOnSearchButton() {
		clickElement(search_button);	
		//logger.info("Clicked on Search Button");
	}

	public void ClickOnHamburgerMenuButton() {
		clickElement(hamburger_menu_link);
	//	scn.write("Clicked on Hamburger Menu Link");
	//	logger.info("Clicked on Hamburger Menu Button");
	}

	public void ClickOnHamburgerMenuProductCategoryLink(String linkText) {
		By byElement = By.xpath(String.format(hamburger_menu_category_link_xpath,linkText));
		clickElement(byElement);
	//	scn.write("Clicked on Hamburger Menu Category link: " + linkText);
	//	logger.info("Clicked on Hamburger Menu Category link: " + linkText);
	}
	
	public void ClickOnHamburgerMenuProductSubCategoryLink(String linkText) {
		By byElement = By.xpath(String.format(hamburger_menu_sub_category_link_xpath,linkText));
		clickElement(byElement);
	}

	public void validateHamBurgerMenuIsDisplayed() {
		boolean b = validateElementIsDisplayed(hamburger_menu_link);
		Assert.assertTrue(b);
	}

	public void validateAmazonLogo() {
		boolean b = validateElementIsDisplayed(nav_link_logo);
		Assert.assertTrue(b);
	}
	
	public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals(true, b);
	//	scn.write("Page title matched: " + expectedTitle );
	}
/*	public void SendKeysToTextfield(WebElement elementToBeClicked) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(elementToBeClicked)).click();

		//Assert.assertEquals(true, b);
		//	scn.write("Page title matched: " + expectedTitle );
	}*/

	public void validateElementPresentInHeaderSection(String text) throws Exception {
		boolean b=false;

		switch(text.toLowerCase().trim()) {

		case "hamburger menu":
			b = validateElementIsDisplayed(hamburger_menu_link);
			break;
		case "amazon prime logo":
			b = validateElementIsDisplayed(nav_link_logo);
			break;
		case "accounts and list link":
			b = validateElementIsDisplayed(nav_link_acount);
			break;
		case "return and orders":
			b = validateElementIsDisplayed(nav_link_orders);
			break;
		case "your prime link":
			b = validateElementIsDisplayed(nav_link_prime);
			break;
		case "cart link":
			b = validateElementIsDisplayed(nav_link_cart);
			break;
		case "search text box":
			b = validateElementIsDisplayed(search_text_box);
			break;
		default:
		//	logger.fatal("Header Link Description is not present in the case. Please add link description first.");
			scn.write("Header Link Description is not present in the case. Please add link description first.");
			throw new Exception("Header Link Description is not present in the case. Please add link description first.");
		}

		if (b) {
			scn.write("Header Link is displayed: " + text);
			Assert.assertEquals(true, b);
		}else {
			scn.write("Header Link is not displayed: " + text);
		//	logger.fatal("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}

	}

}
