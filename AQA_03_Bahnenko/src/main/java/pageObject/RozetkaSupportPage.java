package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaSupportPage extends BasePage {
    @FindBy(css = "section.articles")
    private WebElement popularArticles;
    @FindBy(id = "query")
    private WebElement searchInput;

    public RozetkaSupportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        popularArticles.isDisplayed();
    }

    public SupportSearchResults enterQuery(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.submit();
        return new SupportSearchResults(driver);
    }
}