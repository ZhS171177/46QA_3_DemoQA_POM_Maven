package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "userName")
    WebElement username;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;


    public TextBoxPage enterPersonalData(String name, String email, String address) {
        type(username, name);
        type(userEmail, email);
        type(currentAddress, address);


        return this;
    }

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    @FindBy(id = "submit")
    WebElement submitButton;

    public TextBoxPage keyboardEvent() {
        copyPast(currentAddress, permanentAddress);
        click(submitButton);
        return this;
    }

    @FindBy(xpath = "//p[@id='name']")
    WebElement nameS;
    @FindBy(xpath = "//p[@id='email']")
    WebElement emailS;
    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement cAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement pAddress;

    public TextBoxPage verifyCopyPasteAddress(String name, String email,
                                              String currentAddress) {
        SoftAssert softAssert = new SoftAssert();
        String nameToFind = "Name:" + name;
        String emailToFind = "Email:" + email;
        String currentAddressToFind = "Current Address :" + currentAddress;
        String permananetAddressToFind = "Permananet Address :" + currentAddress;
        softAssert.assertEquals(nameS.getText(), nameToFind);
        softAssert.assertEquals(emailS.getText(), emailToFind);
        softAssert.assertEquals(cAddress.getText(), currentAddressToFind);
        softAssert.assertEquals(pAddress.getText(), permananetAddressToFind);
        softAssert.assertAll();
        return this;
    }





// реализация метода от Тимофея
    public TextBoxPage keyboardEvent1() throws AWTException {
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);


        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);



        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);


        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;
    }
    @FindBy(css = "#currentAddress")
    WebElement current1;
    @FindBy(css = "#permanentAddress")
    WebElement pemanent;


    public TextBoxPage verifyCopyPasteAddress1(){
        String[] current=current1.getText().split(":");
        String[] permanent=pemanent.getText().split(":");
        Assert.assertEquals(current[1],permanent[1]);
        return this;
    }

}
