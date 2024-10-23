package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.ButtonsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectButtons().hideAds();


    }

    @Test
    @Parameters()// можно передавать исходные для теста, например имя, фамиля....
    public void doubleClickButtonsTests() {
        new ButtonsPage(app.driver)
                .doubleClick()
                .verifyDoubleClickMessage("You have done a double click");


    }

    @Test
    public void rightClickButtonsTests() throws InterruptedException {
        new ButtonsPage(app.driver)
                .rightClickButton()
                .verifyRightClickMessage("You have done a right click");

    }

    @Test(invocationCount =2 )
    public void dynamicClickButtonTests() {
        new ButtonsPage(app.driver)
                .dynamicClickButton()
                .verifyDynamicClickMessage("You have done a dynamic click");

    }



}
