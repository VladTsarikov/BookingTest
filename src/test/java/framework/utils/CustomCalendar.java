package framework.utils;

import booking.common.enums.TimeName;
import booking.common.enums.Chars;
import java.util.Calendar;
import java.util.HashMap;

public class CustomCalendar {

    public static int getCurrentMonth(){
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMonthDifference(int firstYear, int firstMonth, int secondYear, int secondMonth){
        int monthCount = 12;
        int monthDifference = 0;
        int switchCount = (secondYear - firstYear) * monthCount;
        if(firstYear <= secondYear){
            if(firstMonth < secondMonth){
                monthDifference = (secondMonth - firstMonth + switchCount);
            }
            if(firstMonth > secondMonth && firstYear < secondYear){
                monthDifference = (monthCount - firstMonth + secondMonth) + (switchCount - monthCount);
            }
            if(firstMonth == secondMonth){
                monthDifference = (secondMonth - firstMonth + switchCount);
            }
        }
        return monthDifference;
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