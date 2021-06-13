import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import testNG.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.sun.deploy.cache.Cache.copyFile;

public class SellerFilterTest extends BaseTest {

    @BeforeSuite
    public void setProps() {
        System.setProperty(setProperties, driverPath);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void sellerFilterTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openPage().openCatalog().chooseRozetkaSeller();
    }

}
