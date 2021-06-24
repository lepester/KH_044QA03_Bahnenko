package testClasses;

import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SellerFilterTest extends BaseTest {

    @Test(groups = {"exclude-group"})
    public void sellerFilterTest() {
        String[] filtersArray = new String[]{"Rozetka", "Другие продавцы"};
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openPage()
                .goToRozetkaSearchResults("монитор")
                .ChooseSellerFilter(filtersArray);


    }
}