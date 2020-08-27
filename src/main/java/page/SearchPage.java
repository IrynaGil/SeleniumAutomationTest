package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class SearchPage extends BasePage {
    private static final String PAGE_URL = "https://www.craftdirect.com/";

    @FindBy(className = "logo")
    private WebElement websiteLogo;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(className = "nav-search-button")
    private WebElement submitButton;

    @FindBy(className = "toolbar-number")
    private WebElement resultCounter;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage openPage() {
        openURL(PAGE_URL);
        return this;
    }

    public boolean exists() {
        return isElementVisible(websiteLogo);
    }

    public ResultPage performSearch(String searchRequest) {
        assertTrue(isElementVisible(searchField), "Search field is not found");
        assertTrue(isElementVisible(submitButton), "Submit button is not found");

        enterInputValue(searchField, searchRequest);

        clickOnElement(submitButton);

        return new ResultPage(driver);
    }
}
