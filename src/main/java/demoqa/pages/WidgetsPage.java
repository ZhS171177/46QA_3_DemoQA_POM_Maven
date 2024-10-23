package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    // Old Style Select Menu
    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        shouldHaveText(oldSelectMenu, color, 5000);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;
// Multiselect

    @FindBy(css = "html")
    WebElement space;

    public WidgetsPage multiSelect(String[] colors) {
        for (String color : colors) {
            if (color != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);
        }
        return this;
    }

    @FindBy(className = "css-12jo7m5")
    List<WebElement> selectedColorsElements;


    public boolean areColorsSelected(String[] colors) {
        List<String> selectedText = new ArrayList<>();
        for (WebElement element : selectedColorsElements) {
            selectedText.add(element.getText());
        }
        for (String color : colors) {
            if (!selectedText.contains(color)) {
                return false;
            }
        }
        return true;
    }


    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage carsSelect(String car) {
        Select select = new Select(cars);
        select.selectByVisibleText(car);
        shouldHaveText(cars, car, 5000);
        return this;
    }


    public WidgetsPage multyCarsSelect(String[] carss) {
        Select select = new Select(cars);
        for (String car : carss) {
            if (car != null) {
                select.selectByVisibleText(car);
            }
            shouldHaveText(cars, car, 5000);
        }
        return this;
    }

    public boolean areCarsSelected(String[] expectedCars) {
        List<String> selectedText = new ArrayList<>();
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement element : selectedOptions) {
            selectedText.add(element.getText());
        }
        for (String car : expectedCars) {
            if (!selectedText.contains(car)) {
                return false;
            }
        }
        return true;

    }
    // выбор автомобилей по индексу

    //    @FindBy(id = "cars")
//    WebElement carsI;
    public WidgetsPage standardMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }
        List<WebElement> options = select.getOptions();
        String selectedText = options.get(index).getText();
        //System.out.println(select.getOptions().get(index).getText());// извлекаем текст
        System.out.println(selectedText);// извлекаем текст
        return this;
    }


    public WidgetsPage verifyByIndex(int index) {

        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        String selectedText = options.get(index).getText();
        boolean textFound = false;
        //Проходим по всем выбранным элементам списка
        for (WebElement element : selectedOptions) {
            if (element.getText().equals(selectedText)) {
                textFound = true;
                break;
            }

        }
        System.out.println(selectedText);
        Assert.assertTrue(textFound);
        return this;

    }

    public WidgetsPage standardMultiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            for (String element : car) {

                select.selectByVisibleText(element);
            }
        }

        return this;
    }

    public WidgetsPage verifyMultiSelectByCars(String[] expected) {
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedText = new ArrayList<>();
        for (WebElement option : selectedOptions) {
            selectedText.add(option.getText());
        }
        List<String>expectedText= Arrays.asList(expected);
        assert new HashSet<>(selectedText).containsAll(expectedText);// метод containsAll сделает за нас все срвнение даже без циклов

        return this;
    }


}
