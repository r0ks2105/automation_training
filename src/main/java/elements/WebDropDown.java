package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDropDown extends BaseElement {
    private WebDriver driver;

    public WebDropDown(WebDriver driver) {
        super(driver);
           }

    public void selectOptionXpath(String locator, String optionName, WebElement dropDownMenu) throws InterruptedException {
            dropDownMenu.click();
            Thread.sleep(1000);
            WebElement dropdownElement = this.driver.findElement(By.xpath(locator.replace("OPT", optionName)));
            dropdownElement.click();

    }
}
