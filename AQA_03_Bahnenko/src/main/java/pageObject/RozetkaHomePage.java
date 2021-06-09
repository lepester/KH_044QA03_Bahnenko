package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaHomePage extends BasePage {

    @FindBy(css = "input.search-form__input")
    private WebElement searchFieldRozetka;
    @FindBy(css = "button.search-form__submit")
    private WebElement searchButtonSubmit;

    public RozetkaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsRozetka goToSearchResultsRozetka() {
        searchFieldRozetka.clear();
        searchFieldRozetka.sendKeys("book");
        searchButtonSubmit.click();
        return new SearchResultsRozetka(driver);
    }
}
