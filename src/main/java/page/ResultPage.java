package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//li[@class='item product product-item']")
    private List<WebElement> productList;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Double sumPricesLessThan(Double lessThan) {

        Double totalAmountLessThan = 0.0;

        for (WebElement liProduct : productList) {
            Double priceValue = null;

            try {
                //TODO maybe change the locators
                WebElement specialPriceSpan = liProduct.findElement(By.className("special-price"));
                WebElement specialPrice = specialPriceSpan.findElement(By.className("price"));

                priceValue = Double.valueOf(specialPrice.getText().substring(1));
            } catch (Exception e) {
                //e.printStackTrace();
            }

            if (priceValue == null) {
                WebElement spanPrice = liProduct.findElement(By.className("price"));
                priceValue = Double.valueOf(spanPrice.getText().substring(1));
            }

            if (priceValue < lessThan) {
                totalAmountLessThan += priceValue;
            }

        }

        return totalAmountLessThan;
    }
}
