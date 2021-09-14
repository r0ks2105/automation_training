package elements;

import base.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_pages.Cart;

public class WebGrids extends BaseElement {

    public WebGrids(WebDriver driver) {
        super(driver);
        }
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    public WebElement firsItemInGrid;
    @FindBy(xpath = "//*[@id=\"list\"]/a/i")
    protected WebElement listView;
    @FindBy(xpath = "//*[@id=\"grid\"]/a/i")
    protected WebElement gridView;
    @FindBy(xpath = "//* [@title=\"Add to cart\"]/span")
    protected WebElement addToCart_inList;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    protected WebElement proceedToCheckout;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]")
    protected WebElement popup;

    @Step
    public void openElementDetails(){
      firsItemInGrid.click();
    }

    @Step
    public WebGrids setListView(){
        listView.click();
        return new WebGrids(driver);
    }

    @Step
    public void setGridView(){
        gridView.click();
    }
    @Step
    public void addToCart_fromList(){
        addToCart_inList.click();
    }

    @Step
    public Cart proceedToCheckout(){
        new WebDriverWait(this.driver, 10)
                .until(ExpectedConditions.visibilityOf(popup));
        proceedToCheckout.click();
        return new Cart(driver);
    }
}


