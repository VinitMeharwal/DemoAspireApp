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
public class UpdateQuantityPage extends PageFactoryInitializer {
	
	@FindBy(xpath = "//button[@data-original-title='Create record']")
	private WebElement createRecordButton;
	
	@FindBy(xpath = "//button[@title='Save record']")
	private WebElement saveRecordButton;
	
	@FindBy(xpath = "//input[@name='inventory_quantity']")
	private WebElement inventoryQuantityTextbox;


	@Step("Click create Record Button in the Update Quantity Page")
	public UpdateQuantityPage clickOncreateRecordButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), createRecordButton);
		click(createRecordButton);
		return this;
	}
	
	@Step("Enter inventory_quantity in the Update Quantity Page")
	public UpdateQuantityPage enterInventoryQuantity(String value) throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), inventoryQuantityTextbox);
		clear(inventoryQuantityTextbox);
		sendKeys(inventoryQuantityTextbox, value);
		return this;
	}
	
	@Step("Click Save record Button in the Update Quantity Page")
	public UpdateQuantityPage clickOnSaveRecordButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), saveRecordButton);
		click(saveRecordButton);
		return this;
	}
	
	@Step("Verify Update Quantity Page title")
	public UpdateQuantityPage verifyPageTitle() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - Update Quantity"));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - Update Quantity");
		return this;
	}
}
