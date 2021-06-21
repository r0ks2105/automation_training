package web_pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
 //private WebDriver driver;
 private static final String EMAIL = "aut0test1@yopmail.com";
 private static final String PASSWORD = "Passw0rd123";
 @FindBy(css = ".login")
   private WebElement signIN;

    public MainPage(WebDriver driver){
       //PageFactory.initElements(driver, this);
        super(driver);
    }
    public AuthenticationPage navigateToSignIn(){
        signIN.click();
        return new AuthenticationPage(this.driver);
    }
}
