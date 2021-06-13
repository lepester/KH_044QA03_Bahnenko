package testNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.RozetkaHomePage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class DataProviderTest extends BaseTest {

    @BeforeSuite
    public void setProps() {
        System.setProperty(setProperties, driverPath);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider(name = "searchText")
    public static Object[][] searchText() {
        return new Object[][] {
                {"кофе"},
                {"мягкие игрушки"},
                {"кружка"}
        };
    }

    @Test(dataProvider = "searchText")
    public void dataProviderTest(String searchText) {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openPage()
                       .goToSearchResultsRozetka(searchText)
                       .goToProductPage();
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

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
