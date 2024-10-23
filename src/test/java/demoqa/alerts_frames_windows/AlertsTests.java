package demoqa.alerts_frames_windows;

import demoqa.core.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver).getAlertsFrameWindows().hideAds();
        new SidePage(app.driver).selectAlerts().hideAds();
    }

    @Test
    public void waitAlertsTest() {
        new AlertsPage(app.driver).clickAlertsWithtimer();
    }

    @Test
    public void alertsWithSelectText() {
        new AlertsPage(app.driver)
                .clickOnConfirmbutton()
                .selectResult("OK")
                .verifyResult("Ok");

    }

    @Test
    public void sendMessageToAlert() {
        new AlertsPage(app.driver)
                .clickOnPromtButton()
                .sendTextToAlert("Hello")
                .verifyAlertText("Hello");
    }
}
