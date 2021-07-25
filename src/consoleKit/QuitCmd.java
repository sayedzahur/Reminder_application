package consoleKit;

public class QuitCmd extends Object implements MenuItem
{

    public void execute()
    {
        System.exit(0);
    }
  
    @Override
    public String toString()
    {
        return "Quit";
    }  
}
