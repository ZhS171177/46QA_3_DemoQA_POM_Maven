package demoqa.widgest;

import demoqa.core.TestBase;
import demoqa.pages.AutoCompletePage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectAutoCompleteMenu().hideAds();


    }
    @Test
    public  void AutoCompleteSingleTest(){
        new AutoCompletePage(app.driver)
                .autoComplete("m")
                .verifyAutoComplete("Magenta")
                ;
    }

    @Test
    public  void AutoCompleteArrayTest(){
        String[] autoCompleteArray={"m","b"};
        String[] autoCompleteArrayVerify={"Magenta","Black"};
        new AutoCompletePage(app.driver)
                .autoCompleteArray(autoCompleteArray)
                .verifyAutoCompleteArray(autoCompleteArrayVerify);

    }
}
