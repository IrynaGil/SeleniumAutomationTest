package page;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchPageTest extends BaseTest {

    private static final String SEARCH_REQUEST = "scrapbook album material";
    private static final Double LESS_THAN = 10.0;

    @Test
    public void GetSearchResultsAndCountSum() {
        SearchPage page = new SearchPage(getDriver())
                .openPage();

        assertTrue(page.exists(), "Website Home page is not found");

        ResultPage resultPage = page.performSearch(SEARCH_REQUEST);

        Double totalAmountLessThan = resultPage.sumPricesLessThan(LESS_THAN);

        System.out.println(totalAmountLessThan);
    }
}
