package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupportSearchResults extends BasePage {

    @FindBy(css = "div.search-results")
    private WebElement searchResults;

    public SupportSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        searchResults.isDisplayed();
    }

}
