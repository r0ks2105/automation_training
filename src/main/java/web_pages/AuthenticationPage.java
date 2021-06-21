package web_pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
   // private WebDriver driver;
    @FindBy(css = "#email")
    private WebElement emailInput;
    @FindBy(css = "#passwd")
    private WebElement passwordInput;
    @FindBy(css = "#SubmitLogin")
    private WebElement submitButton;
    @FindBy(css = ".alert > ol > li")
    private WebElement authenticationError;

    public AuthenticationPage (WebDriver driver){
      // BaseTest.pageFactoryInit(driver, this);
        super(driver);
    }

    public AuthenticationPage loginToMyAccount(String email, String password){
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
        return this;
    }

    public String getPageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String getError(){
     return authenticationError.getText();
    }
}
