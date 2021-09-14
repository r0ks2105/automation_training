import base.BaseTest;
import elements.SubMenu;
import elements.WebGrids;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import web_pages.Cart;
import web_pages.MainPage;
import web_pages.web_components.PageHeader;

import static base.WebDriverConfig.driverThreadSafe;

public class AddToCart extends BaseTest {
    protected AddToCart() throws Exception {
    }

    @Test
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for the case when the Negative login to My Account page")
    public void addToCartAndBy() throws InterruptedException {
        new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount(email, password);

        SubMenu menu = new PageHeader(driverThreadSafe.get()).selectElement("1");
        menu.openT_shirtsPage();
        new WebGrids(driverThreadSafe.get()).setListView();
        new WebGrids(driverThreadSafe.get()).addToCart_fromList();
        Cart cart = new WebGrids(driverThreadSafe.get()).proceedToCheckout().increaseQuantity();
        Assert.assertEquals(cart.checkQuantity(), "2 Products");
        cart.clickSubmit().clickSubmitButton().selectPayment().confirmPayment();
        Assert.assertEquals(cart.checkTradeConfirmation(), "Your order on My Store is complete.");


    }
}
