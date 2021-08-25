import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.RegistrationData;
import web_pages.MainPage;
import web_pages.PersonalInfo;

import static base.WebDriverConfig.driverThreadSafe;

public class SuccessfulAccountRegistration extends BaseTest {


    protected SuccessfulAccountRegistration() throws Exception {
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
}
