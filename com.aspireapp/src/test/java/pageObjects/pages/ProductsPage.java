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
public class ProductsPage extends PageFactoryInitializer {
	
	@FindBy(xpath = "//button[@title='Create record']")
	private WebElement createRecordButton;

	@Step("Click create Record Button in the Products Page")
	public ProductsPage clickOncreateRecordButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), createRecordButton);
		click(createRecordButton);
		return this;
	}

	@Step("Verify Products page title")
	public ProductsPage verifyPageTitle() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - Products"));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - Products");
		return this;
	}
}
