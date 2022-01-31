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
public class ManufacturingOrdersPage extends PageFactoryInitializer {
	
	@FindBy(xpath = "//button[@data-original-title='Create record']")
	private WebElement createRecordButton;

	@Step("Click create Record Button in the Products Page")
	public ManufacturingOrdersPage clickOncreateRecordButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), createRecordButton);
		click(createRecordButton);
		return this;
	}

	@Step("Verify Products page title")
	public ManufacturingOrdersPage verifyPageTitle() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - Manufacturing Orders"));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - Manufacturing Orders");
		return this;
	}
}
