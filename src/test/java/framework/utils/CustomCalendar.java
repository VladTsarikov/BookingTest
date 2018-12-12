package framework.utils;

import booking.common.enums.TimeName;
import booking.flights.enums.Chars;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class CustomCalendar {

    public static int getCurrentMonth(){
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getCurrentDay(){
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonthDifference(int firstYear, int firstMonth, int firstDay
            , int secondYear, int secondMonth, int secondDay){
        int monthCount = 12;
        int monthDifference = 0;
        if(firstYear <= secondYear && secondDay<getMaxMonthDaysCount(secondYear,secondMonth)){
            int switchCount = (secondYear - firstYear) * monthCount;
            if(firstMonth < secondMonth){
                monthDifference = (secondMonth - firstMonth + switchCount);
            }
            if(firstMonth > secondMonth && firstYear < secondYear){
                if((secondYear-firstYear) == 1){
                    monthDifference = ((monthCount-firstMonth) + secondMonth);
                }else{
                    monthDifference = ((monthCount-firstMonth) + secondMonth) + switchCount;
                }
            }
            if(firstMonth == secondMonth){
                if(firstDay < secondDay){
                    monthDifference = (secondMonth - firstMonth + switchCount);
                }
            }
        }
        return monthDifference;
    }

    public static int getMaxMonthDaysCount(int year, int monthIndex){
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,monthIndex);
        return calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
    }

    public static HashMap<String, String> splitTimeString(String time){
        int hoursIndex = 0;
        int minutesIndex = 1;
        String[] hoursAndMinutes = time.split(Chars.COLON.getCharacter());
        HashMap<String,String> hoursAndMinutesMap = new HashMap();
        hoursAndMinutesMap.put(TimeName.HOUR.getName(),hoursAndMinutes[hoursIndex]);
        hoursAndMinutesMap.put(TimeName.MINUTE.getName(),hoursAndMinutes[minutesIndex]);
        return hoursAndMinutesMap;
    }
}