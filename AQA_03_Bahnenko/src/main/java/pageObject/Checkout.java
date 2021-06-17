package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends BasePage {
    @FindBy(css = "div.modal__holder")
    private WebElement modalHolder;
    @FindBy(xpath = "//div[@class='preloader']")
    private WebElement preloaderLine;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        preloaderLine.isDisplayed();
    }
}