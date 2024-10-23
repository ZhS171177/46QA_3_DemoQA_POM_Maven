package demoqa.widgest;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectSelectMenu().hideAds();


    }

    @Test
    public void oldStyleSelectMenuTest(){
        new WidgetsPage(app.driver)
                .selectOldStyle("Indigo");
    }
    @Test
    public void multiSelectTest(){
        String[] colorsSelect={"Green", "Blue"};
        WidgetsPage page=new WidgetsPage(app.driver);
        page.multiSelect(colorsSelect);
        assertTrue(page.areColorsSelected(colorsSelect));

    }

    @Test
    public void standardMultiCarSelectTest(){
        new WidgetsPage(app.driver).carsSelect("Opel");

    }

    @Test
    public void standardMultiCarsSelectTest(){
        String[] carsSelect={"Volvo","Saab","Opel"};
        WidgetsPage page= new WidgetsPage(app.driver);
                page.multyCarsSelect(carsSelect);
        assertTrue(page.areCarsSelected(carsSelect));
    }

    @Test
    public void standardMultiSelectByIndexTest(){
        new WidgetsPage(app.driver).standardMultiSelectByIndex(2)
                .verifyByIndex(2);

    }


    @Test
    public void standardMultiSelectByCarsTest(){
        String[] cars={"Volvo","Opel","Saab"};
        new WidgetsPage(app.driver)
                .standardMultiSelectByCars(cars)
                .verifyMultiSelectByCars(cars);

    }
}
