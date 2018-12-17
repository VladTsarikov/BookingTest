package booking.flights.pages.forms;

import booking.common.entities.Date;
import framework.utils.CustomCalendar;

public class SingleCalendarForm extends FlightsCalendarForm {

    public void setDate(Date date){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth()
                , date.getYear(), date.getMonthIndex());
        clickOnMonthDay(date.getDay());
    }
}