import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import web_pages.MainPage;
import web_pages.ProductDetails;
import web_pages.SearchResults;

import static base.WebDriverConfig.driverThreadSafe;

public class Search extends BaseTest {
    protected Search() throws Exception {
    }

    @Test
    @TmsLink("threats")
    @Issue("repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Registration negative")
    public void searchItems() throws InterruptedException {
        SearchResults searchResults = new MainPage(driverThreadSafe.get()).
                search("Dress");
        super.waitForElement(5, searchResults.searchFrame);
        searchResults.openFirstSearchResult();
        ProductDetails productDetails = new ProductDetails(driverThreadSafe.get());
        Assert.assertTrue(productDetails.getProductName().contains("Dress"));
    }
}
