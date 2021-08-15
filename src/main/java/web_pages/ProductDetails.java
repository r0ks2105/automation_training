package web_pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends BasePage {
@FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
protected WebElement productName;
    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
       String name = productName.getText();
       return name;
    }

}
