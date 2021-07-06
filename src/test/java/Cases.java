import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ReadProperties;
import web_pages.AuthenticationPage;
import web_pages.MainPage;
import web_pages.PersonalInfo;

import static base.WebDriverConfig.driverThreadSafe;

public class Cases extends BaseTest {
    private String email = ReadProperties.getInstance().getProperty("mainLogin");
    private String password = ReadProperties.getInstance().getProperty("mainPassword");


    public Cases() throws Exception {
    }

    @Test
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

    @Test
    public void loginPositive() {
       AuthenticationPage authenticationPage = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount(email, password);
        Assert.assertEquals(authenticationPage.getPageTitle(), "My account - My Store");
    }

    @Test
    public void registerAccountSuccessful() throws Exception {
        PersonalInfo personalIfo = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .createAccount(super.newEmail);
                saveEmail();
                super.waitForElement(5, personalIfo.registrationForm);
                personalIfo.registerAccount("John","Doe", "Passw0rd123",
                        "L'viv Naukova 7G","L'viv", "Alaska","81115", "United States",
                        "+380670000000");
               Assert.assertEquals(personalIfo.getPageTitle(), "My account - My Store");
    }

}
