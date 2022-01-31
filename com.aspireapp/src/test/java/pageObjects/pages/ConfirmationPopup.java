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
public class ConfirmationPopup extends PageFactoryInitializer {
	
	@FindBy(xpath = "//h4[@class='modal-title']")
	private WebElement confirmationHeader;

	@FindBy(xpath = "//button[@type='button']//span[text()='Ok']")
	private WebElement okButton;

	@Step("Click OK Button in the Confirmation Header")
	public ConfirmationPopup clickOnOkButtonButton() throws Exception {
		AllureAttachments.saveWebElement(getWebDriver(), okButton);
		click(okButton);
		return this;
	}

	@Step("Verify Confirmation Popup header")
	public ConfirmationPopup verifyPopupHeader() throws Exception {
		Assert.assertEquals(confirmationHeader.getText(), "Confirmation");
		return this;
	}
}
