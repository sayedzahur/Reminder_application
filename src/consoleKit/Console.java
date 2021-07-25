package consoleKit;

import java.util.List;
import java.util.Scanner;

public final class Console
{
    public final static Scanner sc = new Scanner(System.in);
    
    // Prompt for integer in a range and return input number
    public static int intInRange(String text, int min, int max)
    {
        StringBuffer prompt = new StringBuffer(text);
        prompt.append(" (");
        prompt.append(min);
        prompt.append('-');
        prompt.append(max);
        prompt.append("): ");
        System.out.print(prompt);
        return sc.nextInt();
    }

    // Display options and return index of selected option
    public static <T> int getChoice(List<T> options)
    {
        System.out.println("\nOptions:");
        for (int choice = 0; choice < options.size(); choice++)
        {
            System.out.println(choice + ". " + options.get(choice));
        }
        return Console.intInRange("Enter an option", 0, options.size() - 1);
    }
}
