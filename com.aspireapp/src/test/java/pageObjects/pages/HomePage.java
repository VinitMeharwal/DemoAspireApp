package pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;
import utils.RandomGenerator;

/**
 * @Author ${Vinit Kumar}
 * 
 */
public class HomePage extends PageFactoryInitializer
{
	@FindBy(xpath="//a[div[text()='Manufacturing']]")
	private WebElement manufacturingLink;
	
	@FindBy(xpath="//a[div[text()='Inventory']]")
	private WebElement inventoryLink;


	@Step("Click On Manufacturing Link in the Home Page")
	public HomePage clickOnManufacturingLink() throws Exception
	{
		AllureAttachments.saveWebElement(getWebDriver(), manufacturingLink);
		click(manufacturingLink);	
		return this;		
	}
	
	@Step("Click On Inventory Link in the Home Page")
	public HomePage clickOnInventoryLinkLink() throws Exception
	{
		AllureAttachments.saveWebElement(getWebDriver(), inventoryLink);
		click(inventoryLink);	
		return this;		
	}
}
