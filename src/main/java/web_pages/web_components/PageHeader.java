package web_pages.web_components;

import base.BasePage;
import elements.MainMenuElements;
import elements.SubMenu;
import elements.WebDropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.MainPage;
import web_pages.PersonalInfo;

public class PageHeader  extends BasePage {
    public PageHeader(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_query_top")
    private WebElement searchInput;
    @FindBy(css = "#searchbox > button")
    private WebElement searchButton;
    private String mainMenuElement = "//*[@id=\"block_top_menu\"]/ul/li[\"ELEMENT\"]";


    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public SubMenu selectElement(String elementOfMenu) throws InterruptedException {
        new MainMenuElements(driver).hoverMainMenuElement(mainMenuElement, elementOfMenu);
        return new SubMenu(driver);
    }
}
