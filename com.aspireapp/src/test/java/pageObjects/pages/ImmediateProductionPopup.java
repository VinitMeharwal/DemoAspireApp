package pageObjects.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.AllureAttachments;
import utils.RandomGenerator;

/**
 * @Author ${Vinit Kumar}
 * 
 */
public class ImmediateProductionPopup extends PageFactoryInitializer {
	
	@FindBy(xpath = "//h4[@class='modal-title' and text()='Immediate Production?']")
	private WebElement ImmediateProductionHeader;

	@FindBy(xpath = "//button[@type='button']//span[text()='Apply']")
	private WebElement applyButton;

	@Step("Click Apply Button in the Immediate Production Header")
	public ImmediateProductionPopup clickOnApplyButtonButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), applyButton);
		click(applyButton);
		return this;
	}

	@Step("Verify Immediate Production? Popup header")
	public ImmediateProductionPopup verifyPopupHeader() throws Exception {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(ImplicitlyWait));
		wait.until(ExpectedConditions.visibilityOf(ImmediateProductionHeader));
		Assert.assertEquals(ImmediateProductionHeader.getText(), "Immediate Production?");
		return this;
	}
}
