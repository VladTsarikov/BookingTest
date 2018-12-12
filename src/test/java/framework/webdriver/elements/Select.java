package framework.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Select extends BaseElement {

    public Select(By locator, String name) {
        super(locator, name);
    }

    public Select(WebElement element) {
        super(element);
    }

    public void selectByText(String value){
        new org.openqa.selenium.support.ui.Select(getElement()).selectByVisibleText(value);
    }

    public void selectByIndex(int index){
        new org.openqa.selenium.support.ui.Select(getElement()).selectByIndex(index);
    }

    public void selectByValue(String value){
        new org.openqa.selenium.support.ui.Select(getElement()).selectByValue(value);
    }
}