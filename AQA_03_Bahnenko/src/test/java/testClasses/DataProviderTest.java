package testClasses;

import org.testng.annotations.*;
import pageObject.RozetkaHomePage;

public class DataProviderTest extends BaseTest {

    @DataProvider(name = "searchText")
    public static Object[][] searchText() {
        return new Object[][] {
                {"кофе"},
                {"мягкие игрушки"},
                {"кружка"}
        };
    }

    @Test(groups = { "exclude-group" }, dataProvider = "searchText")
    public void dataProviderTest(String searchText) {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openFatMenu()
                       .goToSearchResultsRozetka(searchText);
    }
}
