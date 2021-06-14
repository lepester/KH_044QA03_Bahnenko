package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class RozetkaDisplaysPage extends BasePage {
    @FindBy(css = "layout_with_sidebar")
    private WebElement sidebar;
    By sellerFilter = By.cssSelector("li.checkbox-filter__item");
    @FindBy(css = "div.catalog-settings")
    private WebElement catalogSettings;
    @FindBy(css = "a.goods-tile__picture")
    private WebElement display;


    public RozetkaDisplaysPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaProductPage chooseRozetkaSeller() {
        List<WebElement> filters = driver.findElements(sellerFilter);
        filters.get(0).click();
        visibilityWaiter(catalogSettings);
        display.click();
        return new RozetkaProductPage(driver);
    }
}
