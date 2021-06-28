package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RozetkaSearchResults extends BasePage {
    @FindBy(css = "a.goods-tile__picture")
    private WebElement firstProduct;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;

    public RozetkaSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaProductPage goToFirstProduct() {
        firstProduct.click();
        return new RozetkaProductPage(driver);
    }

    public RozetkaSearchResults ChooseSellerFilter(String []filtersArray) {
        BasePage.logger.debug("This is debug message");
        BasePage.logger.info("Searching for seller filters...");
        try {
           for (String filter : filtersArray) {
               WebElement checkBox = driver.findElement(By.xpath("//label[@for='" + filter + "']"));
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
