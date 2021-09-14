package web_pages;

import base.BasePage;
import elements.WebGrids;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends BasePage {
    public SearchResults(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_query_top")
    public WebElement searchFrame;


    @Step
    public ProductDetails openFirstSearchResult(){

        new WebGrids(driver)
                .openElementDetails();
        return new ProductDetails(driver);
    }
}
