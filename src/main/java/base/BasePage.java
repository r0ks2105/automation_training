package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web_pages.SearchResults;

public abstract class BasePage {
    protected WebDriver driver;



    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getPageTitle() throws InterruptedException {
        Thread.sleep(1000);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
}
