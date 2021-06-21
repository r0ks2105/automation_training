import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import web_pages.AuthenticationPage;
import web_pages.MainPage;

import static base.WebDriverConfig.driverThreadSafe;

public class Cases extends BaseTest {
    private static final String EMAIL = "aut0test1@yopmail.com";
    private static final String PASSWORD = "Passw0rd123";

    @Test
    public void loginNegative() {
        AuthenticationPage authenticationPage = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount("test", PASSWORD);
        Assert.assertEquals(authenticationPage.getError(), "Invalid email address.");
        authenticationPage
                .loginToMyAccount(EMAIL, "tes");
        Assert.assertEquals(authenticationPage.getError(), "Invalid password.");
        authenticationPage
                .loginToMyAccount("test@email.com", "Password123");
        Assert.assertEquals(authenticationPage.getError(), "Authentication failed.");
    }

    @Test
    public void loginPositive() {
       AuthenticationPage authenticationPage = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount(EMAIL, PASSWORD);
        Assert.assertEquals(authenticationPage.getPageTitle(), "My account - My Store");
    }

}
