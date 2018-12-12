package booking.common.forms;

import framework.utils.CustomCalendar;
import framework.webdriver.BaseForm;
import org.openqa.selenium.By;

public abstract class BaseCalendarForm extends BaseForm {

    protected BaseCalendarForm(By locator, String formTitle) {
        super(locator, formTitle);
    }

    protected int goToMonth(int currentYear, int currentMonth, int currentDay, int year, int month, int day){
        int monthDifference = CustomCalendar.getMonthDifference(currentYear, currentMonth,currentDay,year, month, day);
        int monthIndex = monthDifference+1;
        while(monthDifference>0){
            clickGoToNextMonthButton();
            monthDifference--;
        }
        return monthIndex;
    }

    protected abstract void clickGoToNextMonthButton();
}