import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import pageObject.RozetkaSearchResults;
import testClasses.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.sun.deploy.cache.Cache.copyFile;

public class AddToCartTest extends BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setProps() {
        System.setProperty(setProperties, driverPath);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
    }

    @Test(groups = {"exclude-group"})
    public void addToCartTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        RozetkaSearchResults rozetkaSearchResults = new RozetkaSearchResults(driver);

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://rozetka.com.ua/");
        rozetkaHomePage.goToSearchResultsRozetka("монитор");
        rozetkaSearchResults.goToProductPage()
                .clickToCheckout();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess())
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                copyFile(scrFile, new File(result.getName() +"["+ LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));

            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        driver.quit();
    }
}
