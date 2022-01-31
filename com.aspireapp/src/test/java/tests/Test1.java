package tests;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class Test1 extends PageFactoryInitializer 
{
	
	@Description("To verify the Inventory and Manufacturing module functionality")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void verifyAspireappOdoo(String testCaseID,String emailID,String password) throws Exception
	{
		String productName = "DemoProductVinit";
		loginPage().verifyPageLoaded().login(emailID, password);
		homePage().clickOnInventoryLinkLink();
	    inventoryOverviewPage().verifyPageTitle().clickOnProductsTab().clickOnProductsLink();
	    productsPage().verifyPageTitle().clickOncreateRecordButton();
	    newProductsPage().verifyPageTitle().enterProductName(productName).clickOnSaveRecordButton().verifyCreatedProductPageTitle(productName).clickOnUpdateQuantityTab();
	    updateQuantityPage().verifyPageTitle().clickOncreateRecordButton().enterInventoryQuantity("11").clickOnSaveRecordButton();
	    appHeaderComponent().clickOnHomeMenuLink().homePage().clickOnManufacturingLink();
	    manufacturingOrdersPage().verifyPageTitle().clickOncreateRecordButton();
	    newManufacturingOrdersPage().enterProductName(productName).clickOnConfirmButton().clickOnMarkAsDonebutton();
	    confirmationPopup().verifyPopupHeader().clickOnOkButtonButton();
	    immediateProductionPopup().verifyPopupHeader().clickOnApplyButtonButton().newManufacturingOrdersPage().verifyCurrentState("DONE").clickOnSaveRecordButton();
	    
	   
	}

}
