package reminders.consoleview;

import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import reminders.model.Reminder;

public class Alert
{
   private final ScheduledExecutorService scheduler;
   public Alert() 
   {
       scheduler = Executors.newScheduledThreadPool(1);
   }
   
   //Set up the alert for the reminder
   public void set(Reminder rem)
   {
       Calendar date = rem.getAlertTime();
       int hr = date.get(HOUR_OF_DAY);
       int min = date.get(MINUTE);
       Runnable alert = () -> System.out.println(rem.getDesc() + " " + hr + ":" + min);
       scheduler.schedule(alert, date.getTimeInMillis() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);  
   }
}