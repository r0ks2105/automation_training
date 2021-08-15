package web_pages;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
    @FindBy(css = "#email")
    private WebElement emailInput;
    @FindBy(css = "#passwd")
    private WebElement passwordInput;
    @FindBy(css = "#SubmitLogin")
    private WebElement submitButton;
    @FindBy(css = ".alert > ol > li")
    private WebElement authenticationError;
    @FindBy(css = "#email_create")
    private WebElement createAccountInput;
    @FindBy (css = "#SubmitCreate")
    private WebElement createAccountButton;
    @FindBy (css = "#create_account_error>ol>li")
    private WebElement createAccountError;

    public AuthenticationPage (WebDriver driver){
             super(driver);
    }

    @Step("Log in to the user account page")
    public AuthenticationPage loginToMyAccount(String email, String password){
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
        return this;
    }

    @Step("Check page title")
    public String getPageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
    @Step("Verify error message")
    public String getError(){
     return authenticationError.getText();
    }

    @Step("Type user credentials for registration")
    public PersonalInfo createAccount(String newEmail){
        createAccountInput.clear();
        createAccountInput.sendKeys(newEmail);
        System.out.println(newEmail);
        createAccountButton.click();
               return new PersonalInfo(driver);
    }

    @Step("Get registration error")
    public String getRegistrationError(){
        String error = createAccountError.getText();
        return error;
    }
}
