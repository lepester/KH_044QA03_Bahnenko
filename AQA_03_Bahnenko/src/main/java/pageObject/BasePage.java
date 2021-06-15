package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    public WebDriverWait pageLoading() {
        return new WebDriverWait(driver, 10);
    }


    public void clickableWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.elementToBeClickable(wait));
    }

    public void visibilityWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.visibilityOf(wait));
    }
}
