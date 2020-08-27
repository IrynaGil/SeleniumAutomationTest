package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    private final short defaultTimeout = 3;

    protected WebDriver driver;

    public BasePage() {
        driver = BaseTest.getDriver();
    }

    public void openURL(String URL) {
        driver.get(URL);
    }

    public void waitForVisibilityOfElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean isElementVisible(WebElement element) {
        try {
            waitForVisibilityOfElement(element, defaultTimeout);
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void enterInputValue(WebElement element, String string) {
        element.sendKeys(string);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

}
