package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainMenuElements {

    private WebDriver driver;

    public MainMenuElements(WebDriver driver) {
        this.driver = driver;
    }
    public void hoverMainMenuElement(String locator, String elementOfMenu) throws InterruptedException {
       WebElement mainMenuElement = this.driver.findElement(By.xpath(locator.replace("\"ELEMENT\"", elementOfMenu)));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenuElement).release().perform();


    }
}
