import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
 private WebDriver driver;
 private static final String EMAIL = "aut0test1@yopmail.com";
 private static final String PASSWORD = "Passw0rd123";
 @FindBy(css = ".login")
    WebElement signIN;
 @FindBy(css = "#email")
    WebElement emailInput;
 @FindBy(css = "#passwd")
    WebElement passwordInput;
 @FindBy(css = "#SubmitLogin")
    WebElement submitButton;
 @FindBy(css = "h1")
    WebElement pageTitle;

    public Login(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void signIn(){
        signIN.click();
        emailInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
        submitButton.click();
    }
    public String pageTitle(){
     String myAccount = pageTitle.getText();
     return myAccount;
    }
}
