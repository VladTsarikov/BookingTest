package booking.flights.pages.forms;

import booking.common.forms.BaseCalendarForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightsCalendarForm extends BaseCalendarForm {

    private final static String MAIN_LOCATOR = "//div[@class='contentContainer']";
    private final static String formatDayLocator = "(//div[contains(@class,'col-day')]//div[contains(text(),'%s')])[%s]";
    private static  @FindBy(how = How.XPATH, using = " //div[contains(@id,'next')]") Button nextMonthButton;

    public FlightsCalendarForm() {
        super(By.xpath(MAIN_LOCATOR),"Calendar Form");
    }

    protected void clickGoToNextMonthButton() {
        nextMonthButton.click();
    }

    protected void clickOnMonthDay(int day){
        int currentMonthIndex = 2;
        new Label(By.xpath(String.format(formatDayLocator,day,currentMonthIndex)),"Day Locator").click();
    }
}