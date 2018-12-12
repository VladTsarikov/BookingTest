package framework.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement {

    public CheckBox(final By locator, final String name) {
        super(locator, name);
    }

    public CheckBox(WebElement element) {
        super(element);
    }
}