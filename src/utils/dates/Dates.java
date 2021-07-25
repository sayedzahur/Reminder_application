package utils.dates;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Dates
{
    // Get today's date
    public static Calendar getToday()
    {
        return new GregorianCalendar();
    }
    
    // Get today's year
    public static int getThisYear()
    {
        return getToday().get(Calendar.YEAR);
    }
}
