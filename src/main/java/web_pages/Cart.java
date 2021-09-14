package web_pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cart_quantity_up_1_1_0_518215")
    protected WebElement cartQuantityUp;
    @FindBy(id = "cart_quantity_down_1_1_0_518215")
    protected WebElement cartQuantityDown;
    @FindBy(id = "summary_products_quantity")
    protected WebElement quantity;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    protected WebElement submitButton;
    @FindBy(xpath = "//*/p/button [@type=\"submit\"]")
    protected WebElement submitButton2;
    @FindBy(xpath = "//*[@id=\"carrier_area\"]/h1")
    protected WebElement shipping;
    @FindBy (id="cgv")
    protected WebElement checkBox;
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    protected WebElement paymentByCheck;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    protected WebElement tradeConfirmationNotification;


    public Cart increaseQuantity() {
        cartQuantityUp.click();
        return this;
    }

    public String checkQuantity() throws InterruptedException {
        Thread.sleep(4000);
        String quantityCheck = quantity.getText();
        return quantityCheck;
    }

    public Cart clickSubmit() {
        submitButton.click();
        return new Cart(driver);
    }

    public Cart clickSubmitButton() {
        submitButton2.click();
        new WebDriverWait(this.driver, 10)
                .until(ExpectedConditions.visibilityOf(shipping));
        checkBox.click();
        submitButton2.click();
        return new Cart(driver);
    }

    public Cart selectPayment(){
        paymentByCheck.click();
        return new Cart(driver);
    }
    public Cart confirmPayment(){
        submitButton2.click();
        return new Cart(driver);
    }

    public String checkTradeConfirmation(){
       String confirmationNotif = tradeConfirmationNotification.getText();
       return confirmationNotif;
    }

}
