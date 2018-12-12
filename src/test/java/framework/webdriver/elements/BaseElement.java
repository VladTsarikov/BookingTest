package framework.webdriver.elements;

import framework.enums.LogType;
import framework.utils.Logger;
import framework.webdriver.BaseEntity;
import framework.webdriver.Browser;
import framework.webdriver.waitings.Waiting;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BaseElement extends BaseEntity {

    protected String name;
    protected WebElement element;
    protected By locator;

    protected BaseElement(WebElement element) {
        this.element = element;
        name = "element";
    }

    protected BaseElement(final By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click(){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        Waiting.waitFor(ExpectedConditions.elementToBeClickable(getElement()));
        assertIsPresent();
        Logger.log(String.format("Clicking on %s", name));
        getElement().click();
    }

    public void clickAndWait(){
        click();
        Waiting.waitForPageIsReady();
    }

    public void clickByActions(){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        Waiting.waitFor(ExpectedConditions.elementToBeClickable(getElement()));
        new Actions(driver).moveToElement(getElement()).build().perform();
    }

    public void clickViaJS() {
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.elementToBeClickable(getElement()));
        assertIsPresent();
        Logger.log(String.format("Clicking on %s", name));
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", getElement());
    }

    public String getText(){
        Waiting.waitForPageIsReady();
        Logger.log(String.format("Getting text of %s", name));
        return getElement().getText();
    }

    public boolean isSelected(){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        return getElement().isSelected();
    }

   public List<WebElement> getChildren(By locator){
       assertIsPresent();
       return getElement().findElements(locator);
   }

    public String getAttribute(String attributeName){
        assertIsPresent();
        Logger.log(String.format("Getting attribute '%s' of %s", attributeName, name));
        return getElement().getAttribute(attributeName);
    }

    public boolean isPresent() {
        boolean status = false;
        try{
            if(getElement().isEnabled()){
                status = true;
            }
        }catch (Exception e){
            status = false;
            Logger.log(LogType.DEBUG,e);
        }
        return status;
    }

    private void assertIsPresent(){
        assertTrue(isPresent(),String.format("Element '%s' has not found", name));
    }

    WebElement getElement(){
        if(element == null){
            return driver.findElement(locator);
        }else{
            return element;
        }
    }
}