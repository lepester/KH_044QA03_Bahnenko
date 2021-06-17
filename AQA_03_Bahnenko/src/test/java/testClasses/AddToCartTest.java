package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import pageObject.RozetkaSearchResults;
import testClasses.BaseTest;

public class AddToCartTest extends BaseTest {


    @Test(groups = {"exclude-group"})
    public void addToCartTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        RozetkaSearchResults rozetkaSearchResults = new RozetkaSearchResults(driver);

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://rozetka.com.ua/");
        rozetkaHomePage.goToRozetkaSearchResults("монитор");
        rozetkaSearchResults.goToFirstProductPage()
                            .clickToCheckout();
    }


}
