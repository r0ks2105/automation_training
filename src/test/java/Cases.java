import base.BasePage;
import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ReadProperties;
import test_data.RegistrationData;
import web_pages.*;

import static base.WebDriverConfig.driverThreadSafe;

public class Cases extends BaseTest {
    private String email = ReadProperties.getInstance().getProperty("mainLogin");
    private String password = ReadProperties.getInstance().getProperty("mainPassword");


    public Cases() throws Exception {
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

    @Test
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test for the case when the Positive login to My Account page")
    public void loginPositive() {
        AuthenticationPage authenticationPage = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .loginToMyAccount(email, password);
        Assert.assertEquals(authenticationPage.getPageTitle(), "My account - My Store");
    }

    @Test(dataProvider = "registrationData", dataProviderClass = RegistrationData.class)
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive registration")
    public void registerAccountSuccessful(String name, String surname, String password, String streetAddress,
                                          String city, String state, String zip, String
                                                      country, String phone) throws Exception {
        PersonalInfo personalIfo = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .createAccount(super.newEmail);
        saveEmail();
        super.waitForElement(5, personalIfo.registrationForm);
        personalIfo.registerAccount(name, surname, password,streetAddress, city, state, zip, country,phone);
        Assert.assertEquals(personalIfo.getPageTitle(), "My account - My Store");
    }

    @Test(dataProvider = "registrationData", dataProviderClass = RegistrationData.class)
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Registration negative")
    public void registerAccountNegative(String name, String surname, String password, String streetAddress,
                                        String city, String state, String zip, String
                                                country, String phone) throws Exception {
        PersonalInfo personalInfo = new MainPage(driverThreadSafe.get())
                .navigateToSignIn()
                .createAccount(email);
        AuthenticationPage authenticationPage = new AuthenticationPage(driverThreadSafe.get());
        Assert.assertEquals(authenticationPage.getRegistrationError(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
        authenticationPage.createAccount(super.newEmail);
        saveEmail();
        super.waitForElement(5, personalInfo.registrationForm);
        personalInfo.registerAccount(name, surname, password,streetAddress, city, state, "123123132123", country,phone);
        Assert.assertEquals(personalInfo.getRegistrationError(), "postcode is too long. Maximum length: 12");
    }

    @Test
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Registration negative")
    public void searchItems() throws InterruptedException {
        SearchResults searchResults = new MainPage(driverThreadSafe.get()).
                search("Dress");
        super.waitForElement(5, searchResults.searchFrame);
        searchResults.openFirstSearchResult();
        ProductDetails productDetails = new ProductDetails(driverThreadSafe.get());
        Assert.assertTrue(productDetails.getProductName().contains("Dress"));
    }
}
