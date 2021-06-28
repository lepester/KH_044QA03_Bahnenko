package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//input[@formcontrolname='surname']")
    private WebElement surnameInput;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@formcontrolname='phone']")
    private WebElement phoneInput;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage enterUserData(String surname, String name, String phone) {
        surnameInput.sendKeys(surname);
        nameInput.sendKeys(name);
        phoneInput.sendKeys(phone);
        return this;
    }
}