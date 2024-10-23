package demoqa.pages;

import demoqa.core.BasePage;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalDate(String name, String surName, String email, String number) {
        type(firstName, name);
        type(lastName, surName);
        type(userEmail, email);
        type(userNumber, number);
        return this;
    }
// //label[contains(text(),'Female')]
// //label[contains(text(),'Male')]
// //label[contains(text(),'Other')]


    public PracticeFormPage selectGender(String gender) {
        try {
            String xpathGender = "//label[contains(text(),'" + gender + "')]";
            WebElement genderLokator = driver.findElement(By.xpath(xpathGender));
            click(genderLokator);
        } catch (NoSuchElementException e) {
            System.out.println(" Gender element not found");
            throw new java.util.NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error select gender" + gender);
            throw new RuntimeException(e);
        }


        return this;
    }

    // react-datepicker__month-select
    // react-datepicker__year-select
    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthSelect;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearSelect;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;


    public PracticeFormPage chooseDate(String day, String month, String year) {
        click(dateOfBirthInput);
        new Select(monthSelect).selectByVisibleText(month);
        new Select(yearSelect).selectByVisibleText(year);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();


        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage enterSubject(String[] subjects) {
        for (String subject : subjects) {
            if (subject != null) {
                type(subjectsInput, subject);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }

        return this;
    }

    public PracticeFormPage chooseHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            try {
                driver.findElement(By.xpath("//label[.='" + hobby + "']")).click();
            } catch (Exception e) {
                System.out.println("Error select hobbies");
                throw new RuntimeException(e);
            }
        }
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadPicture(String imgPath) {
        uploadPicture.sendKeys(imgPath);


        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        type(currentAddress, address);
        return this;
    }


    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage enterState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    @FindBy(id="city")
    WebElement cityContainer;
    public PracticeFormPage enterCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submitButton;

    public PracticeFormPage submitForm() {
        click(submitButton);
        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement registrationModal;

    public PracticeFormPage veryfySuccesRegistration(String textToFind) {
        shouldHaveText(registrationModal, textToFind, 500);
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement inputAsStringDateOfBirth;

    public PracticeFormPage chooseDateAsString(String data) throws AWTException {
        inputAsStringDateOfBirth.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        inputAsStringDateOfBirth.sendKeys(data);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        return this;
    }
// реализация метода от Тимофея
    public PracticeFormPage chooseDateAsString1(String data){
        click(inputAsStringDateOfBirth);
        String os=System.getProperty("os.name");
        if(os.contains("Mac")) {
            inputAsStringDateOfBirth.sendKeys(Keys.COMMAND, "a");
        }else {
            inputAsStringDateOfBirth.sendKeys(Keys.CONTROL, "a");
        }
            inputAsStringDateOfBirth.sendKeys(data);
            inputAsStringDateOfBirth.sendKeys(Keys.ENTER);

        return this;
    }

}
