package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement userPassword;

    public LoginPage enterPersonalData(String user, String password) {
        type(userName, user);
        type(userPassword, password);

        return this;
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage clickLoginButton() {
        click(loginButton);
        //clickWitJS(loginButton, 0, 100);
        return new ProfilePage(driver);
    }
}
