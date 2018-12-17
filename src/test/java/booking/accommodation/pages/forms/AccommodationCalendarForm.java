package booking.accommodation.pages.forms;

import booking.common.entities.Date;
import booking.common.forms.BaseCalendarForm;
import framework.utils.CustomCalendar;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccommodationCalendarForm extends BaseCalendarForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'calendar-body')]";
    private final static String formatDayLocator = "(//span[contains(@class,'day-inner')][contains(text(),'%s')])[%s]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@class,'button-further')]") Button nextMnthButtonElement;

    public AccommodationCalendarForm() {
        super(By.xpath(MAIN_LOCATOR),"Accommodation Calendar Form");
    }

    public void setCheckInDate(Date date){
        int monthIndex = goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth()
                 , date.getYear(), date.getMonthIndex());
        clickOnCurrentMonthDay(date.getDay(),monthIndex);
    }

    public void setCheckOutDate(Date date){
        int monthIndex = goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth()
                , date.getYear(), date.getMonthIndex());
        int firstMonthIndex = 16;
        clickOnCurrentMonthDay(date.getDay(),monthIndex + firstMonthIndex);
    }

    private void clickOnCurrentMonthDay(int day,int monthIndex){
        new Label(By.xpath(String.format(formatDayLocator, day, monthIndex)),"Accommodation Calendar Day Label")
                .click();
    }

    @Override
    protected void clickGoToNextMonthButton() {
        nextMnthButtonElement.click();
    }
}