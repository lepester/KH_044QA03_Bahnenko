package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {

    @FindBy(partialLinkText = "Интернет-магазин ROZETKA")
    private WebElement targetLink;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaHomePage goToRozetkaHomePage() {
        targetLink.click();
        return new RozetkaHomePage(driver);
    }

}
