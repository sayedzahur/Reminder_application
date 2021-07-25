package consoleKit;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import reminders.consoleview.Alert;
import reminders.model.AllReminders;
import reminders.model.Reminder;
import reminders.model.ReminderList;

public class IO 
{
    public static void writeToFile(AllReminders allrems) throws IOException 
    {
        FileOutputStream f = new FileOutputStream("tmp");
        ObjectOutput s = new ObjectOutputStream(f);
        //Store course
        s.writeObject(allrems);
        s.flush();
        s.close();
        f.close();
        System.out.println("Successfully written to file!");
    }
    
    // Read saved data from file. This method is run at the beginning of the program
    public static AllReminders readFromFile() throws IOException, ClassNotFoundException
    {
        Alert alert = new Alert();
        FileInputStream in = new FileInputStream("tmp");
        ObjectInputStream s = new ObjectInputStream(in);
        AllReminders allrems = (AllReminders) s.readObject();
        s.close();
        in.close();
        System.out.println("Successfully loaded from file!");
        
        //Resetting the alerts
        List<ReminderList> catList = allrems.getCategories();
        for (ReminderList remListObj : catList)
        {
            List<Reminder> remList = remListObj.getReminders();
            for (Reminder rem : remList)
            {
                alert.set(rem);
            }
        }
        return allrems;
    }
}
