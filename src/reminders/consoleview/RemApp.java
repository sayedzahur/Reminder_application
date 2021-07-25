package reminders.consoleview;

import consoleKit.IO;
import consoleKit.Menu;
import consoleKit.MenuStack;
import consoleKit.QuitCmd;
import java.io.IOException;
import reminders.model.AllReminders;

public class RemApp
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        MenuStack menus = new MenuStack();
        AllReminders allrems;

        try
        {
        	allrems = IO.readFromFile();
        } 
        catch (ClassNotFoundException | IOException | NullPointerException o)
        {
            allrems = new AllReminders();
            allrems.addCategory("Personal");
        }
        
        Menu mainMenu = new Menu("main menu", menus);
        mainMenu.add(new QuitCmd());
        mainMenu.add(new TodaysReminders(allrems));
        mainMenu.add(new AddCategory(allrems));
        mainMenu.add(new ChooseCategory(allrems, mainMenu, menus));
        
        System.out.println("Reminder Application");
        while (true)
            menus.run(); 
    } 
}
