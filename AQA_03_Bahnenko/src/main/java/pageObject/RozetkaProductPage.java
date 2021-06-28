package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaProductPage extends BasePage {
    @FindBy(css = "span.buy-button__label")
    private WebElement buyButton;
    @FindBy(css = "a.button_size_large")
    private WebElement acceptButton;

    public RozetkaProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage clickToCheckout() {
        BasePage.logger.info("All is good!");
        Actions actions = new Actions(driver);
        clickableWaiter(buyButton);
        actions.moveToElement(buyButton).perform();
        buyButton.click();
        clickableWaiter(acceptButton);
        acceptButton.click();
        return new CheckoutPage(driver);
    }
}
