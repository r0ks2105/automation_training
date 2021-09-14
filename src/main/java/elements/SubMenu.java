package elements;

import base.BaseElement;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenu extends BaseElement {
        public SubMenu(WebDriver driver) {
        super(driver);
           }

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
    public WebElement t_shirts;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
    protected WebElement blouses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a")
    protected WebElement casualDresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a")
    protected WebElement eveningDresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
    protected WebElement summerDresses;

    public void openT_shirtsPage() throws InterruptedException {
        Thread.sleep(2000);
        t_shirts.click();
    }
}
