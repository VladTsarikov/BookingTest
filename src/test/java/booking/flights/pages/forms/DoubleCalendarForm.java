package booking.flights.pages.forms;

import booking.common.entities.Date;
import framework.utils.CustomCalendar;

public class DoubleCalendarForm extends FlightsCalendarForm {

    public void setDates(Date firstDate, Date secondDate){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth()
                , firstDate.getYear(), firstDate.getMonthIndex());
        clickOnMonthDay(firstDate.getDay());
        goToMonth(firstDate.getYear(), firstDate.getMonthIndex(), secondDate.getYear()
                , secondDate.getMonthIndex());
        clickOnMonthDay(secondDate.getDay());
    }
}