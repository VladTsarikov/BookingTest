package framework.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement{

    public Label(final By locator, final String name) {
        super(locator, name);
    }

    public Label(WebElement element) {
        super(element);
    }
}