package framework.webdriver.elements;

import framework.webdriver.waitings.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBox extends BaseElement{

    public TextBox(final By locator, final String name) {
        super(locator, name);
    }

    public TextBox(WebElement element) {
        super(element);
    }

    public TextBox setText(String text){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        getElement().clear();
        getElement().sendKeys(text);
        return this;
    }

    public void enter(){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        getElement().sendKeys(Keys.ENTER);
    }

    public void setTextByChar(String text){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        getElement().clear();
        for (int i = 0; i < text.length(); i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = String.valueOf(text.charAt(i));
            getElement().sendKeys(s);
        }
    }
}