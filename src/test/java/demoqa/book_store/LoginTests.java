package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    // username  janna
    // password Qwerty@1

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver).getBookStore();
        new SidePage(app.driver).selectLogin();


    }

    @Test(invocationCount = 1)
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("janna", "Qwerty@1")
                .clickLoginButton()
                .verifyUserName("janna");

    }
}
