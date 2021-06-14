package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public ThreadLocal<WebDriver> driverThreadSafe = new ThreadLocal<>();
    private static String baseURL = "http://automationpractice.com/";
@BeforeMethod
 public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driverThreadSafe.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
    }
 @AfterMethod
public void closeBrowser(){
    driverThreadSafe.get().quit();
}


}
