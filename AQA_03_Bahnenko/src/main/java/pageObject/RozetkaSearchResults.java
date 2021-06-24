package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RozetkaSearchResults extends BasePage {
    @FindBy(css = "a.goods-tile__picture")
    private WebElement firstProduct;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement sidebar;
    By sellerFilter = By.cssSelector("li.checkbox-filter__item");
    @FindBy(css = "div.catalog-settings")
    private WebElement catalogSettings;

    public RozetkaSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        visibilityWaiter(catalogSettings);
    }

    public RozetkaProductPage goToFirstProduct() {
        firstProduct.click();
        return new RozetkaProductPage(driver);
    }

    public RozetkaSearchResults ChooseSellerFilter(String []filtersArray) {
       try {
           for (String moreFilter : filtersArray) {
               WebElement checkBox = driver.findElement(By.xpath("//label[@for='" + moreFilter + "']"));
               visibilityWaiter(checkBox);
               checkBox.click();
               resultsGrid.isDisplayed();
           }
       } catch (StaleElementReferenceException e) {
           e.printStackTrace();
       }
        return this;
    }
}
