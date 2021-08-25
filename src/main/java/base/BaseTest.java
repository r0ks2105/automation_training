package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test_data.ReadProperties;


public abstract class BaseTest {
    private static final String BASEURL = "http://automationpractice.com/";
    private WebDriver driver;
    protected static String newEmail = "aut0test"+(int)(Math.random()*100+1000)+"@yopmail.com";
    private int emailId = Integer.parseInt(ReadProperties.getInstance().getProperty("emailId"));
    protected String email = ReadProperties.getInstance().getProperty("mainLogin");
    protected String password = ReadProperties.getInstance().getProperty("mainPassword");

    protected BaseTest() throws Exception {
    }

    @BeforeMethod
    public void setupDriver() {
        this.driver = WebDriverConfig.getChromeDriver();
        driver.get(BASEURL);
    }

/* @AfterMethod
public void closeBrowser(){
    this.driver.quit();
}*/

    public WebDriver getDriver() {
        return this.driver;
    }

    public void waitForElement(int sec, WebElement webElement) {
        new WebDriverWait(this.driver, sec)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
    public void saveEmail() throws Exception {
        ReadProperties.getInstance().setProperties("email"+ emailId++, newEmail);
        ReadProperties.getInstance().setProperties("emailId",String.valueOf(emailId++));
    }

}
