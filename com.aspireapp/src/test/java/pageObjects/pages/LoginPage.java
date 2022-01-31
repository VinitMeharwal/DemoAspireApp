package pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;

/**
 * @Author Vinit Kumar
 */
public class LoginPage extends PageFactoryInitializer
{
	@FindBy(xpath="//input[@name='login']")
	private WebElement emailIDTextBox;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginButton;

	@Step("To Enter Email ID, Password and Click Log in Button")
	public LoginPage login(String emailID, String password) 
	{
		AllureAttachments.saveWebElement(getWebDriver(), emailIDTextBox);
		emailIDTextBox.sendKeys(emailID);	
		AllureAttachments.saveWebElement(getWebDriver(), passwordTextBox);
		passwordTextBox.sendKeys(password);
		AllureAttachments.saveWebElement(getWebDriver(), loginButton);
		loginButton.click();
		return this;
	}

	@Step("Verify the login button of the Login Page")
	public LoginPage verifyPageLoaded() {
		Assert.assertTrue(loginButton.isEnabled(), "Login button enabled");
		return this;
	}
	
	
	
}
