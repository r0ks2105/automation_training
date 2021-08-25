import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import web_pages.AuthenticationPage;
import web_pages.MainPage;

import static base.WebDriverConfig.driverThreadSafe;

public class PositiveLogin extends BaseTest {

    protected PositiveLogin() throws Exception {
    }

    @Test
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for the case when the Positive login to My Account page")
    public void loginPositive() {
        AuthenticationPage authenticationPage = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount(super.email, super.password);
        Assert.assertEquals(authenticationPage.getPageTitle(), "My account - My Store");
    }
}
