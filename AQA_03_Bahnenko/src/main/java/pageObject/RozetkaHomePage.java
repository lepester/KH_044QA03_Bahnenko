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
    @FindBy(css = "main.content_type_main")
    private WebElement sidebar;
    @FindBy(css = "button.menu__toggle")
    private WebElement catalog;
    @FindBy(xpath = "//a[@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    private WebElement displaySection;

    public RozetkaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaDisplaysPage openFatMenu() {
        catalog.click();
        displaySection.click();
        return new RozetkaDisplaysPage(driver);
    }

    public RozetkaSearchResults goToSearchResultsRozetka(String searchInput) {
        searchFieldRozetka.clear();
        searchFieldRozetka.sendKeys(searchInput);
        searchButtonSubmit.click();
        return new RozetkaSearchResults(driver);
    }
}
