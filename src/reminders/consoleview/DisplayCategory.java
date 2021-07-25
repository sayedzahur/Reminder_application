package reminders.consoleview;

import consoleKit.MenuItem;
import reminders.model.Reminder;
import reminders.model.ReminderList;

public class DisplayCategory extends Object implements MenuItem 
{
    private ReminderList remList;

    public DisplayCategory(ReminderList chosenList)
    {
        remList = chosenList;
    }

    public void execute()
    {
        for (Reminder rem: remList.getReminders())
        {
            String time = rem.getAlertTime().getTime().toString();
            System.out.print(rem.getDesc() + " " + time);
        }
    }
    
    @Override
    public String toString()
    {
        return "List all reminders";
    }
}
