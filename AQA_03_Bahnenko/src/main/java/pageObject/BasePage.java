package pageObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    public WebDriverWait pageLoading(){
        return new WebDriverWait(driver, 10);
    }

    public void clickableWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.elementToBeClickable(wait));
    }

    public void visibilityWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.visibilityOf(wait));
    }


}