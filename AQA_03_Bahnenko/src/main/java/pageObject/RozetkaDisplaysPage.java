package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RozetkaDisplaysPage extends BasePage {
    @FindBy(css = "layout_with_sidebar")
    private WebElement sidebar;
    @FindBy(xpath = "//a[@href='/monitors/c80089/seller=rozetka/']")
    private WebElement rozetkaSeller;
    @FindBy(css = "div.catalog-settings")
    private WebElement catalogSettings;
    @FindBy(css = "a.goods-tile__picture")
    private WebElement display;


    public RozetkaDisplaysPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaProductPage chooseRozetkaSeller() {
        rozetkaSeller.click();
        visibilityWaiter(catalogSettings);
        display.click();
        return new RozetkaProductPage(driver);
    }
}
