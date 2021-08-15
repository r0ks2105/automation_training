package web_pages.web_components;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader  extends BasePage {
    public PageHeader(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_query_top")
    private WebElement searchInput;
    @FindBy(css = "#searchbox > button")
    private WebElement searchButton;


    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }


}
