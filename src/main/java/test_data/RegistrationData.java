package test_data;

import org.testng.annotations.DataProvider;

public class RegistrationData {
    @DataProvider(name = "registrationData")
    public Object[][] getData(){
        Object[][] registrationFields = {{"John", "Doe", "Passw0rd123", "L'viv Naukova 7G", "L'viv", "Alaska", "01234", "United States",
                "+380670000000"}};
        return registrationFields;
    }
}
