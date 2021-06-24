package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResults extends BasePage {

    @FindBy(css = "#rso a h3")
    private WebElement targetLink;

    public GoogleSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaHomePage goToRozetkaHomePage() {
        targetLink.click();
        return new RozetkaHomePage(driver);
    }

}
