package web_pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
 private static final String EMAIL = "aut0test1@yopmail.com";
 private static final String PASSWORD = "Passw0rd123";
 @FindBy(css = ".login")
   private WebElement signIN;

    public MainPage(WebDriver driver){
        super(driver);
    }

    @Step("Navigate to Sign in page")
    public AuthenticationPage navigateToSignIn(){
        signIN.click();
        return new AuthenticationPage(this.driver);
    }
}
