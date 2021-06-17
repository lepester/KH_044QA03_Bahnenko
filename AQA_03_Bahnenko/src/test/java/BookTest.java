import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.GoogleHomePage;
import pageObject.RozetkaHomePage;

import java.util.concurrent.TimeUnit;

public class BookTest {
    public WebDriver driver;

    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Test
    public void bookTest() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.goToSearchResultsPage()
                .goToRozetkaHomePage();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://rozetka.com.ua/");
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.goToSearchResultsRozetka()
                .goToFooter();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}
