package base;

import org.openqa.selenium.WebDriver;

public abstract class BaseElement extends BasePage{
    public BaseElement(WebDriver driver) {
        super(driver);
    }
}
