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
    @FindBy(css = "button.header__button")
    private WebElement hamburgerButton;
    @FindBy(css = "button.side-menu__auth-button")
    private WebElement logInButton;
    @FindBy(id = "registerUserName")
    private WebElement name;
    @FindBy(id = "registerUserSurname")
    private WebElement surname;
    @FindBy(id = "registerUserPhone")
    private WebElement phone;
    @FindBy(id = "registerUserEmail")
    private WebElement email;
    @FindBy(id = "registerUserPassword")
    private WebElement password;
    @FindBy(css = "a.auth-modal__register-link")
    private WebElement registerButton;

    public RozetkaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaHomePage openPage() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public RozetkaDisplaysPage openCatalog() {
        catalog.click();
        displaySection.click();
        return new RozetkaDisplaysPage(driver);
    }

    public RozetkaHomePage openSideMenu() {
        hamburgerButton.click();
        logInButton.click();
        return this;
    }

    public RozetkaHomePage logIn() {
        registerButton.click();
        name.sendKeys("Дмитрий");
        surname.sendKeys("Гордон");
        phone.sendKeys("123 456 78 90");
        email.sendKeys("gordondmitro@gmail.com");
        password.sendKeys("ptashineMoLoKo5123");
        return this;
    }

    public RozetkaSearchResults goToSearchResultsRozetka(String searchText) {
        searchFieldRozetka.clear();
        searchFieldRozetka.sendKeys(searchText);
        searchButtonSubmit.click();
        return new RozetkaSearchResults(driver);
    }
}
