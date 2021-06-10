package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;

    public void clickableWaiter(WebElement wait) {
        WebDriverWait pageLoading = new WebDriverWait(driver, 5);
        pageLoading.until(ExpectedConditions.elementToBeClickable(wait));
    }

    public void visibilityWaiter(WebElement wait) {
        WebDriverWait pageLoading = new WebDriverWait(driver, 5);
        pageLoading.until(ExpectedConditions.visibilityOf(wait));
    }
}
