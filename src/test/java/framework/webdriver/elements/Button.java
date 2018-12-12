package framework.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement{

    public Button(WebElement element) {
        super(element);
    }

    public Button(final By locator, final String name) {
        super(locator, name);
    }
}