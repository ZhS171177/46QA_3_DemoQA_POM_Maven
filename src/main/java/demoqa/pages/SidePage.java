package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {


    public SidePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement login;

    public LoginPage selectLogin() {
       click(login);
       // clickWitJS(login,0,500);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement alerts;
    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);

    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;
    public  WidgetsPage selectSelectMenu(){
        click(selectMenu);
        return  new WidgetsPage(driver);
    }
    //* BrowserWindows
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BasePage selectBrowserWindows() {
        click(browserWindows);
        return this;
    }

    //* Buttons
    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;
    public ButtonsPage selectButtons() {
        click(buttons);
        return new ButtonsPage(driver);
    }
@FindBy(xpath = " //span[.='Text Box']")
WebElement textBoxButton;
    public TextBoxPage selectTextBox() {
        click(textBoxButton);
        return new TextBoxPage(driver);
    }
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;
    public BasePage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement pautoCompleteMenu;

    public BasePage selectAutoCompleteMenu() {
        click(pautoCompleteMenu);
        return  new AutoCompletePage(driver);
    }


@FindBy(xpath="//span[.='Broken Links - Images']")
WebElement brokenLinksImages;

    public BasePage selectBrokenLinksImages() {
        click(brokenLinksImages);
        return new BrokenLinksImagesPage(driver);
    }
}
