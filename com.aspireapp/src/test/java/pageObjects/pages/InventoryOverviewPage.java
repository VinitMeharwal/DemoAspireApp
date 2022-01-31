package pageObjects.pages;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;

/**
 * @Author ${Vinit Kumar}
 * 
 */
public class InventoryOverviewPage extends PageFactoryInitializer {
	
	@FindBy(xpath = "//button[@title='Products']")
	private WebElement productsTab;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsLink;

	@Step("Click On Products Tab in the Inventory Overview Page")
	public InventoryOverviewPage clickOnProductsTab() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), productsTab);
		click(productsTab);
		return this;
	}

	@Step("Click On Products link under sub list of Products Tab in the Inventory Overview Page")
	public InventoryOverviewPage clickOnProductsLink() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), productsLink);
		click(productsLink);
		return this;
	}

	@Step("Verify Inventory Overview page title")
	public InventoryOverviewPage verifyPageTitle() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(d -> d.getTitle().equals("Odoo - Inventory Overview"));
		Assert.assertEquals(getWebDriver().getTitle(), "Odoo - Inventory Overview");
		return this;
	}
}
