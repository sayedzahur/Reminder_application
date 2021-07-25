package consoleKit;

public class ReturnFromMenu extends Object implements MenuItem
{
    protected final String msg;
    private final MenuStack menus;
    
    //Initialize msg and menus variables
    public ReturnFromMenu(String prevMenuName, MenuStack menus)
    {
        msg = prevMenuName;
        this.menus = menus;
    }
    
    //Return to the previous Menu
    public void execute()
    {
        menus.toPreviousMenu();
    }
    
    //Return the string to display on the menu
    @Override
    public String toString()
    {
        return "Return to main menu";
    }
    
}
