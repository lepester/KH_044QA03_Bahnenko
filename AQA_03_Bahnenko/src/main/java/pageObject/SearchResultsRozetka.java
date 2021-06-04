package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsRozetka extends BasePage {

    @FindBy(css = "rz-lazy.app-footer")
    private WebElement footer;

    public SearchResultsRozetka(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage goToFooter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        return new SearchResultsPage(driver);
    }
}
