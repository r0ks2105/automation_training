package elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebGrids {
    private WebDriver driver;

    public WebGrids(WebDriver driver) {
        this.driver = driver;
    }


    @Step
    public void openElementDetails(WebElement elementInGrid) throws InterruptedException {
      elementInGrid.click();
    }
}


