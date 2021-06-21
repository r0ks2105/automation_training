package web_pages;
import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {


    public MyAccountPage (WebDriver driver){
                //BaseTest.pageFactoryInit(super.driver, this);
       super(driver);
    }
}
