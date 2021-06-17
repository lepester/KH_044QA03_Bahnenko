package testClasses;

import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import testClasses.BaseTest;

public class SellerFilterTest extends BaseTest {

    @Test(groups = {"exclude-group"})
    public void sellerFilterTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .openPage()
                .openFatMenu()
                .chooseRozetkaSeller();

    }

}
