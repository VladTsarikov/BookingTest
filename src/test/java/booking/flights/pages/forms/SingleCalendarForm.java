package booking.flights.pages.forms;

import booking.common.entities.Date;
import framework.utils.CustomCalendar;

public class SingleCalendarForm extends FlightsCalendarForm {

    public void setDate(Date date){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth(), CustomCalendar.getCurrentDay()
                , date.getYear(), date.getMonthIndex(), date.getDay());
        clickOnMonthDay(date.getDay());
    }
}