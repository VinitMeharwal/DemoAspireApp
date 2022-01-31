package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.AppHeaderComponent;
import pageObjects.pages.ConfirmationPopup;
import pageObjects.pages.HomePage;
import pageObjects.pages.ImmediateProductionPopup;
import pageObjects.pages.InventoryOverviewPage;
import pageObjects.pages.LoginPage;
import pageObjects.pages.ManufacturingOrdersPage;
import pageObjects.pages.NewManufacturingOrdersPage;
import pageObjects.pages.NewProductsPage;
import pageObjects.pages.ProductsPage;
import pageObjects.pages.UpdateQuantityPage;

/**
 * @Author Vinit Kumar
 */

public class PageFactoryInitializer extends BaseMethod {

    public LoginPage loginPage() {
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public HomePage homePage() {
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }
    
    public AppHeaderComponent appHeaderComponent() {
        return PageFactory.initElements(getWebDriver(), AppHeaderComponent.class);
    }
    
    public ConfirmationPopup confirmationPopup() {
        return PageFactory.initElements(getWebDriver(), ConfirmationPopup.class);
    }
    
    public ImmediateProductionPopup immediateProductionPopup() {
        return PageFactory.initElements(getWebDriver(), ImmediateProductionPopup.class);
    }
    
    public InventoryOverviewPage inventoryOverviewPage() {
        return PageFactory.initElements(getWebDriver(), InventoryOverviewPage.class);
    }
    
    public ManufacturingOrdersPage manufacturingOrdersPage() {
        return PageFactory.initElements(getWebDriver(), ManufacturingOrdersPage.class);
    }
    
    public NewManufacturingOrdersPage newManufacturingOrdersPage() {
        return PageFactory.initElements(getWebDriver(), NewManufacturingOrdersPage.class);
    }
    
    public NewProductsPage newProductsPage() {
        return PageFactory.initElements(getWebDriver(), NewProductsPage.class);
    }
    
    public ProductsPage productsPage() {
        return PageFactory.initElements(getWebDriver(), ProductsPage.class);
    }
    
    public UpdateQuantityPage updateQuantityPage() {
        return PageFactory.initElements(getWebDriver(), UpdateQuantityPage.class);
    }

}
