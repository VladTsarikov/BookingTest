package framework.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComboBox extends BaseElement{

    public ComboBox(By locator, String name) {
        super(locator, name);
    }

    public ComboBox(WebElement element) {
        super(element);
    }
}