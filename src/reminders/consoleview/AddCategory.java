package reminders.consoleview;

import static consoleKit.Console.sc;
import consoleKit.IO;
import consoleKit.MenuItem;
import java.io.IOException;
import reminders.model.AllReminders;

public class AddCategory extends Object implements MenuItem 
{
    private AllReminders all;

    public AddCategory(AllReminders allrems)
    {
        all = allrems;
    }

    // Get name of new category and add it
    public void execute()
    {
        System.out.print("Enter the name of the new category: ");
        String name = sc.next();
        all.addCategory(name);
        
        //Write to file
        try
        {
            IO.writeToFile(all);
        }
        catch (IOException ex)
        {
            System.out.println("Please enter the correct file name");
        }
    }

    // Description of this command
    @Override
    public String toString() 
    {
        return "Add a new category of reminders";
    }    
}
