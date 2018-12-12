package booking.flights.pages.forms;

import framework.utils.CustomCalendar;

public class SingleCalendarForm extends FlightsCalendarForm {

    public void setDate(int CheckInYear, int CheckInMonth, int CheckInDay){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth(), CustomCalendar.getCurrentDay()
                , CheckInYear, CheckInMonth, CheckInDay);
        clickOnMonthDay(CheckInDay);
    }
}