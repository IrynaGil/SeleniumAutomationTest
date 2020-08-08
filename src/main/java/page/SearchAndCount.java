package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAndCount extends BasePage {
    public SearchAndCount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "logo")
    private WebElement websiteLogo;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(className = "nav-search-button")
    private WebElement submitButton;

    @FindBy(className = "toolbar-number")
    private WebElement resultCounter;

    public WebElement getWebsiteLogo() {
        return websiteLogo;
    }
    public WebElement getSearchField() {
        return searchField;
    }
    public WebElement getSubmitButton() {
        return submitButton;
    }
    public WebElement getResultCounter() {
        return resultCounter;
    }
}


