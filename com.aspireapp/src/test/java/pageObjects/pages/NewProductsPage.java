package pageObjects.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;
import utils.RandomGenerator;

/**
 * @Author ${Vinit Kumar}
 * 
 */
public class NewProductsPage extends PageFactoryInitializer {
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement productNameTextbox;

	@FindBy(xpath = "//button[@title='Save record']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//button[@name='action_update_quantity_on_hand']")
	private WebElement updateQuantityTab;
	

	@Step("Click create Record Button in the New Product Page")
	public NewProductsPage clickOnSaveRecordButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), saveButton);
		click(saveButton);
		return this;
	}
	
	@Step("Click Update Quantity Tab in the New Product Page")
	public NewProductsPage clickOnUpdateQuantityTab() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), updateQuantityTab);
		click(updateQuantityTab);
		return this;
	}
	
	@Step("Enter Product Name in the New Product Page")
	public NewProductsPage enterProductName(String name) throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), productNameTextbox);
		sendKeys(productNameTextbox, name);
		return this;
	}

	@Step("Verify Products page title")
	public NewProductsPage verifyPageTitle() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - New"));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - New");
		return this;
	}
	
	@Step("Verify created Product")
	public NewProductsPage verifyCreatedProductPageTitle(String productName) throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - "+productName));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - "+productName);
		return this;
	}
}
