package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getForms().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();
    }


    @Test
    public void practiceFormTest() throws AWTException {
        new PracticeFormPage(app.driver)
                .enterPersonalDate("Mary", "Bon", "email@gmail.com", "12615372548")
                .selectGender("Female")
                .chooseDateAsString1("04 May 1965")
//               .chooseDate("4","May","1965")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/tolka/Pictures/2024-05-02/002.jpg")
                .enterCurrentAddress("TTT, DDD,FFF")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .veryfySuccesRegistration("Thanks for submitting the form")
        ;
    }
//"Mary", "Bon", "email@gmail.com", "12615372548"
    @Test
    @Parameters({"firstName", "lastName", "email", "phone"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String phone)
            throws AWTException {
        new PracticeFormPage(app.driver)
                .enterPersonalDate(firstName, lastName, email, phone)
                .selectGender("Female")
                .chooseDateAsString1("04 May 1965")
//               .chooseDate("4","May","1965")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/tolka/Pictures/2024-05-02/002.jpg")
                .enterCurrentAddress("TTT, DDD,FFF")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .veryfySuccesRegistration("Thanks for submitting the form")
        ;
    }
}
