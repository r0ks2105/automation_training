package web_pages;

import base.BasePage;
import elements.WebDropDown;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfo extends BasePage {
    public PersonalInfo(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#customer_firstname")
    private WebElement firstNameInput;
    @FindBy(css = "#customer_lastname")
    private WebElement lastNameInput;
    @FindBy(css = "#passwd")
    private WebElement passwordInput;
    @FindBy(css = "#firstname")
    private WebElement firstName;
    @FindBy(css = "#lastname")
    private WebElement lastName;
    @FindBy(css = "#address1")
    private WebElement streetAddress;
    @FindBy(css = "#city")
    private WebElement cityAddress;
    @FindBy(id = "postcode")
    private WebElement zipCode;
    @FindBy(css = "#id_state")
    private WebElement stateDropDown;
    @FindBy(id = "id_country")
    private WebElement Country;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneNumber;
    @FindBy(id = "submitAccount")
    private WebElement submitButton;
    @FindBy(id = "account-creation_form")
    public WebElement registrationForm;
    @FindBy(css = "#center_column > div > ol > li:nth-child(1)")
    private WebElement errorNotification;
    private String optionLocator = "//option[text()=\"OPT\"]";


    @Step("Click submit button")
    public MyAccountPage registerAccount(String name, String surname, String password,
                                         String streetAddress, String city,
                                         String state, String zip,
                                         String country, String phone) throws InterruptedException {
        typeFirstName(name).
                typeSurName(surname).
                typePassword(password).
                typeStreet(streetAddress).
                typeCity(city).
                selectState(state).
                typeZipCode(zip).
                selectCountry(country).
                typeMobilePhone(phone).
                submitButton.click();
        return new MyAccountPage(driver);
    }

    @Step("Type the user's mobile phone")
    protected PersonalInfo typeMobilePhone(String phone) {
        mobilePhoneNumber.sendKeys(phone);
        return this;
    }
    @Step("Select country from dropdown")
    protected PersonalInfo selectCountry(String optionName) throws InterruptedException {
        new WebDropDown(driver).selectOptionXpath(optionLocator, optionName, stateDropDown);
        return this;
    }
    @Step("Type user's zip code")
    protected PersonalInfo typeZipCode(String postCode) {
        zipCode.sendKeys(postCode);
        return this;
    }
    @Step("Type user's city")
    protected PersonalInfo typeCity(String city) {
        cityAddress.sendKeys(city);
        return this;
    }
    @Step("Type user's street")
    protected PersonalInfo typeStreet(String street) {
        streetAddress.sendKeys(street);
        return this;
    }
    @Step("Type user's password")
    protected PersonalInfo typePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Type user's first name")
    protected PersonalInfo typeFirstName(String name) {
        firstNameInput.sendKeys(name);
        firstName.sendKeys(name);
        return this;
    }
    @Step("Type user's sure name")
    protected PersonalInfo typeSurName(String surName) {
        lastNameInput.sendKeys(surName);
        lastName.sendKeys(surName);
        return this;
    }
    @Step("Select state from dropdown")
    protected PersonalInfo selectState(String optionName) throws InterruptedException {
        new WebDropDown(driver).selectOptionXpath(optionLocator, optionName, stateDropDown);
        return this;
    }

    @Step("Get error notification")
    public String getRegistrationError(){
        String error = errorNotification.getText();
        return error;
    }

}


