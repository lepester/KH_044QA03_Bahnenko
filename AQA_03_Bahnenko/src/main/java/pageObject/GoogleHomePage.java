package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage {

    @FindBy(css = "input.gLFyf")
    private WebElement searchFieldGoogle;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleHomePage openPage() {
        driver.get("https://www.google.com/");
        return this;
    }

    public SearchResultsPage goToSearchResultsPage() {
        searchFieldGoogle.click();
        searchFieldGoogle.clear();
        searchFieldGoogle.sendKeys("rozetka");
        searchFieldGoogle.submit();
        return new SearchResultsPage(driver);
    }
}
