package ua.energy.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Calendar getCurrentCalendar() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static String getStringCurrentDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return ((day <= 9) ? "0" + day : day) + "." + ((month <= 9) ? "0" + month : month) + "." + year;
    }

    public static String getStringDate(int year, int month, int day) {
        month++;
        return ((day <= 9) ? "0" + day : day) + "." + ((month <= 9) ? "0" + month : month) + "." + year;
    }
}
