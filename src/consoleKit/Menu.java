package consoleKit;

import static consoleKit.Console.getChoice;
import java.util.ArrayList;
import java.util.List;

public class Menu extends Object implements MenuItem
{
    private final String name;
    private final List<MenuItem> options;
    public MenuStack menus;

    public Menu(String name, MenuStack menus)
    {
        this.name = name;
        this.menus = menus;
        menus.add(this);
        options = new ArrayList<>();
    }
    

    public void add(MenuItem option)
    {
        options.add(option);
    }

    public void execute()
    {
        options.get(getChoice(options)).execute();
    }

    @Override
    public String toString()
    {
        return name;
    }
}
