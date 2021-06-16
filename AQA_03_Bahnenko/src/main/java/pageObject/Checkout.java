package pageObject;

import com.sun.xml.internal.ws.api.server.WSEndpoint;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends BasePage {
    @FindBy(xpath = "//div[@class='preloader']")
    private WebElement preloaderLine;
    @FindBy(xpath = "//input[@formcontrolname='surname']")
    private WebElement surnameInput;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@formcontrolname='phone']")
    private WebElement phoneInput;


    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        preloaderLine.isDisplayed();
    }

    public Checkout enterData(String surname, String name, String phone) {
        surnameInput.sendKeys(surname);
        nameInput.sendKeys(name);
        phoneInput.sendKeys(phone);
        return this;
    }
}