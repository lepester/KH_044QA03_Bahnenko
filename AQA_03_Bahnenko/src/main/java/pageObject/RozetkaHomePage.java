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
    @FindBy(css = "button.menu__toggle")
    private WebElement fatMenu;
    @FindBy(xpath = "//a[@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    private WebElement displaySection;
    @FindBy(css = "button.header__button")
    private WebElement hamburgerButton;
    @FindBy(css = "button.side-menu__auth-button")
    private WebElement logInButton;
    @FindBy(id = "registerUserName")
    private WebElement nameInput;
    @FindBy(id = "registerUserSurname")
    private WebElement surnameInput;
    @FindBy(id = "registerUserPhone")
    private WebElement phoneInput;
    @FindBy(id = "registerUserEmail")
    private WebElement emailInput;
    @FindBy(id = "registerUserPassword")
    private WebElement passwordInput;
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

    public RozetkaSearchResults openFatMenu() {
        fatMenu.click();
        displaySection.click();
        return new RozetkaSearchResults(driver);
    }

    public RozetkaHomePage openSideMenu() {
        hamburgerButton.click();
        visibilityWaiter(logInButton);
        logInButton.click();
        clickableWaiter(registerButton);
        return this;
    }

    public RozetkaHomePage logIn(String name, String surname, String phone, String email, String password) {
        registerButton.click();
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        return this;
    }

    public RozetkaSearchResults goToRozetkaSearchResults(String searchText) {
        searchFieldRozetka.clear();
        searchFieldRozetka.sendKeys(searchText);
        searchButtonSubmit.click();
        return new RozetkaSearchResults(driver);
    }
}
