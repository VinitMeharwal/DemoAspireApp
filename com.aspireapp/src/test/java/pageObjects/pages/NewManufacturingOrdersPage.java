package pageObjects.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;

/**
 * @Author ${Vinit Kumar}
 * 
 */
public class NewManufacturingOrdersPage extends PageFactoryInitializer {
	
	@FindBy(xpath = "//div[@name='product_id']//input[@type='text']")
	private WebElement productNameTextbox;

	@FindBy(xpath = "//button[@name='action_confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//button[@name='button_mark_done' and @confirm][2]/span")
	private WebElement markAsDoneButton;
	
	@FindBy(xpath = "//button[@title='Save record']")
	private WebElement saveRecordButton;

	@FindBy(xpath = "//div[@name='state']//button[@title='Current state']")
	private WebElement currentState;
	
	
	
	@Step("Select Product Name from list of available products in the New Manufacturing Orders Page")
	public NewManufacturingOrdersPage enterProductName(String name) throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), productNameTextbox);
		sendKeys(productNameTextbox, name);
		List<WebElement> products = getWebDriver().findElements(By.xpath("//a[@class='dropdown-item ui-menu-item-wrapper' and text()='"+name+"']"));
		click(products.get(0));
		return this;
	}
	
	@Step("Click Save Record Button in the New Manufacturing Orders Page")
	public NewManufacturingOrdersPage clickOnSaveRecordButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), saveRecordButton);
		click(saveRecordButton);
		return this;
	}
	
	@Step("Click Mark As Done button in the New Manufacturing Orders Page")
	public NewManufacturingOrdersPage clickOnMarkAsDonebutton() throws Exception {
		((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].scrollIntoView();", markAsDoneButton);
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(ExpectedConditions.elementToBeClickable(markAsDoneButton));
		AllureAttachments.saveWebElement(getWebDriver(), markAsDoneButton);
		click(markAsDoneButton);
		return this;
	}
	
	@Step("Click confirm in the New Manufacturing Orders Page")
	public NewManufacturingOrdersPage clickOnConfirmButton() throws Exception {
		((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].scrollIntoView();", confirmButton);
		AllureAttachments.saveWebElement(getWebDriver(), confirmButton);
		click(confirmButton);
		return this;
	}
	
	@Step("Verify current state of New Manufacturing Orders")
	public NewManufacturingOrdersPage verifyCurrentState(String state) throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(ExpectedConditions.textToBePresentInElement(currentState, state));
		Assert.assertEquals(currentState.getText(), state);
		return this;
	}

	@Step("Verify New Manufacturing Orders Page title")
	public NewManufacturingOrdersPage verifyPageTitle() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - New"));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - New");
		return this;
	}
}
