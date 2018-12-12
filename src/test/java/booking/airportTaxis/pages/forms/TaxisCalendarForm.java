package booking.airportTaxis.pages.forms;

import booking.common.forms.BaseCalendarForm;
import framework.utils.CustomCalendar;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TaxisCalendarForm extends BaseCalendarForm {

    private final static String MAIN_LOCATOR = "//table[contains(@class,'calendar')]";
    private final static String formatDayLocator = "//a[contains(text(),'%s')]";
    private static  @FindBy(how = How.XPATH, using = "//a[contains(@class,'next-month')]") Button btnNextMnoth;

    public TaxisCalendarForm() {
        super(By.xpath(MAIN_LOCATOR),"Calendar Form");
    }

    @Override
    protected void clickGoToNextMonthButton() {
        btnNextMnoth.click();
    }

    protected void clickOnMonthDay(int day){
        new Label(By.xpath(String.format(formatDayLocator,day)),"Day Locator").clickViaJS();
    }

    public void setDate(int year, int month, int day){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth(), CustomCalendar.getCurrentDay()
                , year, month, day);
        clickOnMonthDay(day);
    }
}