package testClasses;

import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class LogInTest extends BaseTest {

    @Test(groups = { "include-group" })
    public void logInTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openFatMenu()
                .openSideMenu()
                .logIn( "Дмитро",
                        "Гордон",
                        "097124654",
                        "dmitrogordon@gmail.com",
                        "ptaShineMoloko12AE");
    }

}
