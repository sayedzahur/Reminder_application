package reminders.consoleview;

import consoleKit.Console;
import static consoleKit.Console.sc;
import consoleKit.IO;
import consoleKit.MenuItem;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import reminders.model.AllReminders;
import reminders.model.Reminder;
import reminders.model.ReminderList;
import utils.dates.Dates;

public final class AddReminder extends Object implements MenuItem 
{
    // how many years in advance we can set a reminder alert
    private static final int MAX_ADVANCE = 100;
    private final ReminderList remList;
    private final AllReminders allrems;
    // The alert for the reminder
    private final Alert alarm;

    // get list to work with
    public AddReminder(ReminderList remList, AllReminders allrems)
    {
        this.remList = remList;
        alarm = new Alert();
        this.allrems = allrems;
    }

    // Get values and add a reminder to the list
    public void execute()
    {
        String desc;
        System.out.println("Enter the description of the reminder: ");
        do 
        {
            desc = sc.nextLine();
        }while (desc.trim().equals(""));
        
        System.out.print("Do you want to set an alert for the reminder (y/n)? ");
        String setAlert = sc.next();
        if (setAlert.toLowerCase().equals("y"))
        {
            int yr, mo, day, hr, min;
            int thisyr = Dates.getThisYear();
            yr = Console.intInRange("Enter a year:", thisyr, thisyr + MAX_ADVANCE);
            mo = Console.intInRange("Enter a month:", Calendar.JANUARY+1, Calendar.DECEMBER+1) - 1;
            day = Console.intInRange("Enter a day:", 1, 31);
            hr = Console.intInRange("Enter an hour:", 0, 23);
            min = Console.intInRange("Enter a minute:", 0, 59);
            GregorianCalendar alert = new GregorianCalendar(yr, mo, day, hr, min);
            Reminder temp = new Reminder(desc, alert);
            remList.add(temp);
            alarm.set(temp);
        }
        else
        	remList.add(new Reminder(desc));
        
        try
        {
            IO.writeToFile(allrems);
        } 
        catch (IOException ex)
        {
        	 System.out.println("Please enter the correct file name");
        }
    }

    @Override
    public String toString()
    {
        return "Add a reminder";
    }    
}
