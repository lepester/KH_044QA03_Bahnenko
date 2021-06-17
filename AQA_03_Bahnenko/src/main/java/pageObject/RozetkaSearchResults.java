package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RozetkaSearchResults extends BasePage {
    @FindBy(css = "a.goods-tile__picture")
    private WebElement firstProduct;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(css = "layout_with_sidebar")
    private WebElement sidebar;
    By sellerFilter = By.cssSelector("li.checkbox-filter__item");
    @FindBy(css = "div.catalog-settings")
    private WebElement catalogSettings;

    public RozetkaSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        resultsGrid.isDisplayed();
    }

    public RozetkaProductPage goToFirstProductPage() {
        firstProduct.click();
        return new RozetkaProductPage(driver);
    }

    public RozetkaSearchResults chooseRozetkaSeller() {
        List<WebElement> filters = driver.findElements(sellerFilter);
        filters.get(0).click();
        String assertSeller = "Rozetka";
        Assert.assertEquals(assertSeller,"Rozetka");
        visibilityWaiter(catalogSettings);
        return this;
    }
}
