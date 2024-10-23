package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }
// .top-card:nth-child(6)

    @FindBy(css=".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePage getBookStore() {
        click(bookStore);
       // scrollToElement(bookStore);

        //clickWitJS(bookStore, 0,500);
        return new SidePage(driver);
    }
    @FindBy(css=".top-card:nth-child(3)")
    WebElement alertsFrameWindows;
    public BasePage getAlertsFrameWindows() {
        click(alertsFrameWindows);
        return new SidePage(driver);
    }
    @FindBy(css=".top-card:nth-child(4)")
    WebElement widgets;

    public SidePage getWidgets() {
        click(widgets);
        //clickWitJS(widgets,0,500);
        return new SidePage(driver);
    }



    @FindBy(css=".top-card:nth-child(1)")
    WebElement elements;
    public BasePage getElements() {
        click(elements);
        return new SidePage(driver);
    }


    @FindBy(css=".top-card:nth-child(2)")
    WebElement forms;
    public BasePage getForms() {
        click(forms);
        return new SidePage(driver);
    }
}
