package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {
    private static String baseURL = "http://automationpractice.com/";
    private WebDriver driver;
@BeforeMethod
 public void setupDriver(){
        this.driver = WebDriverConfig.getChromeDriver();
        driver.get(baseURL);
    }

 @AfterMethod
public void closeBrowser(){
    this.driver.quit();
}

public WebDriver getDriver() {
    return this.driver;
}


}
