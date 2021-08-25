import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.RegistrationData;
import web_pages.AuthenticationPage;
import web_pages.MainPage;
import web_pages.PersonalInfo;

import static base.WebDriverConfig.driverThreadSafe;

public class NegativeAccountRegistration extends BaseTest {
    protected NegativeAccountRegistration() throws Exception {
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
}
