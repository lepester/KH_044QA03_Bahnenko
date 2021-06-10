package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaSearchResults extends BasePage {
    @FindBy(css = "a.goods-tile__picture")
    private WebElement display;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;

    public RozetkaSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        clickableWaiter(resultsGrid);
    }

    public RozetkaProductPage goToProductPage() {
        display.click();
        return new RozetkaProductPage(driver);
    }
}
