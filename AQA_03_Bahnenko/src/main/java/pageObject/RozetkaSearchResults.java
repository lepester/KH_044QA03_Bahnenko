package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaSearchResults extends BasePage {

    @FindBy(css = "a.goods-tile__picture")
    private WebElement display;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;

    public RozetkaSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait pageLoading = new WebDriverWait(driver ,5);
        pageLoading.until(ExpectedConditions.elementToBeClickable(resultsGrid));
    }

    public RozetkaProductPage goToProductPage() {
        display.click();
        return new RozetkaProductPage(driver);
    }
}
