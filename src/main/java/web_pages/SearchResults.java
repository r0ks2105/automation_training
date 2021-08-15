package web_pages;

import base.BasePage;
import elements.WebGrids;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends BasePage {
    public SearchResults(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "search_query_top")
    public WebElement searchFrame;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    public WebElement firsItemInGrid;

    public ProductDetails openFirstSearchResult() throws InterruptedException {

         new WebGrids(driver)
       .openElementDetails(firsItemInGrid);
         return new ProductDetails(driver);
    }
}
