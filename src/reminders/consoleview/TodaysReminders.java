package reminders.consoleview;

import consoleKit.MenuItem;
import java.util.Calendar;
import reminders.model.AllReminders;
import reminders.model.Reminder;

public final class TodaysReminders extends Object implements MenuItem
{
    private final AllReminders all;
    
    public TodaysReminders(AllReminders all)
    {
    	this.all = all;
    }
        
    // Display a list of today's reminders with their alert times, if present
    public void execute()
    {
        for (Reminder rem: all.getTodays())
        {
            System.out.print(rem.getDesc());
            Calendar alert = rem.getAlertTime();
            
            if (alert != null)
                System.out.println(String.format(" %1$tH:%1$tM", alert));
            else
            	System.out.println();
        }
    }
    
    @Override
    public String toString()
    {
        return "List today's reminders";
    }
}
