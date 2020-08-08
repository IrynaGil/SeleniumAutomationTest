package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchAndCountTest extends BaseTest {
    private SearchAndCount page;

    private static final String searchRequest = "scrapbook album material";

    @Test
    public void GetSearchResultsAndCountSum() {
        page = new SearchAndCount(getDriver());
        page.openURL("https://www.craftdirect.com/");

        WebElement websiteLogo = page.getWebsiteLogo();

        assertTrue(page.isElementVisible(websiteLogo), "Website Home page is not found");

        WebElement searchField = page.getSearchField();
        assertTrue(page.isElementVisible(searchField), "Search field is not found");

        page.enterInputValue(searchField, searchRequest);

        WebElement submitButton = page.getSubmitButton();
        assertTrue(page.isElementVisible(submitButton), "Submit button is not found");

        page.clickOnElement(submitButton);

        WebElement resultCounter = page.getResultCounter();
        assertTrue(page.isElementVisible(resultCounter), "Search results counter is not found");

        System.out.println("По запиту: " + searchRequest);
        System.out.println(resultCounter.getText() + " items found");

        WebElement olProductList = getDriver().findElement(By.className("product-items"));

        List<WebElement> productList = olProductList.findElements(By.tagName("li"));
        System.out.println(productList);

        Double lessThan = 10.0; //$

        Double totalAmountLessThan = 0.0;

        for (WebElement product: productList) {

            Double priceValue = null;

            try {
                WebElement specialPriceSpan = product.findElement(By.className("special-price"));
                WebElement specialPrice = specialPriceSpan.findElement(By.className("price"));
                priceValue = Double.valueOf(specialPrice.getText().substring(1));
            } catch (Exception e) {
                //e.printStackTrace();
            }

            if (priceValue == null) {
                WebElement spanPrice = product.findElement(By.className("price"));
                priceValue = Double.valueOf(spanPrice.getText().substring(1));
            }

            if (priceValue < lessThan) {
                totalAmountLessThan += priceValue;
            }

        }

        System.out.println(totalAmountLessThan);

    }
}