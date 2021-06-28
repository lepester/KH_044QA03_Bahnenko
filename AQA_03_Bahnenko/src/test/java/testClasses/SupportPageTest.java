package testClasses;

import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SupportPageTest extends BaseTest {

    @Test
    public void supportPageTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openPage()
                .goToSupportPage()
                .enterQuery("авторизация");
    }
}