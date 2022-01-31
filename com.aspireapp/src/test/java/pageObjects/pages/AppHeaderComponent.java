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
public class AppHeaderComponent extends PageFactoryInitializer
{
	@FindBy(xpath="//a[@title='Home menu']")
	private WebElement homeMenuLink;

	@Step("Click On Home Menu Link in the App header component")
	public AppHeaderComponent clickOnHomeMenuLink() throws Exception
	{
		AllureAttachments.saveWebElement(getWebDriver(), homeMenuLink);
		click(homeMenuLink);	
		return this;		
	}
}
