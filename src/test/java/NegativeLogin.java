import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import web_pages.AuthenticationPage;
import web_pages.MainPage;

import static base.WebDriverConfig.driverThreadSafe;

public class NegativeLogin extends BaseTest {
    protected NegativeLogin() throws Exception {
    }

    @Test
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for the case when the Negative login to My Account page")
    public void loginNegative() {
        AuthenticationPage authenticationPage = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount("test", password);
        Assert.assertEquals(authenticationPage.getError(), "Invalid email address.");
        authenticationPage
                .loginToMyAccount(email, "tes");
        Assert.assertEquals(authenticationPage.getError(), "Invalid password.");
        authenticationPage
                .loginToMyAccount("test@email.com", "Password123");
        Assert.assertEquals(authenticationPage.getError(), "Authentication failed.");
    }
}
