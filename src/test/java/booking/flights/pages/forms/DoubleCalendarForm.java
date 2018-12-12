package booking.flights.pages.forms;

import booking.common.entities.Date;
import framework.utils.CustomCalendar;

public class DoubleCalendarForm extends FlightsCalendarForm {

    public void setDates(Date firstDate, Date secondDate){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth(), CustomCalendar.getCurrentDay()
                , firstDate.getYear(), firstDate.getMonthIndex(), firstDate.getDay());
        clickOnMonthDay(firstDate.getDay());
        goToMonth(firstDate.getYear(), firstDate.getMonthIndex(), firstDate.getDay(), secondDate.getYear()
                , secondDate.getMonthIndex(), secondDate.getDay());
        clickOnMonthDay(secondDate.getDay());
    }
}