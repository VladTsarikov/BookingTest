package booking.flights.pages.forms;

import framework.utils.CustomCalendar;

public class DoubleCalendarForm extends FlightsCalendarForm {

    public void setDates(int CheckInYear, int CheckInMonth, int CheckInDay
            , int CheckOutYear, int CheckOutMonth, int CheckOutDay){
        goToMonth(CustomCalendar.getCurrentYear(), CustomCalendar.getCurrentMonth(), CustomCalendar.getCurrentDay()
                , CheckInYear, CheckInMonth, CheckInDay);
        clickOnMonthDay(CheckInDay);
        goToMonth(CheckInYear, CheckInMonth, CheckInDay, CheckOutYear, CheckOutMonth, CheckOutDay);
        clickOnMonthDay(CheckOutDay);
    }
}