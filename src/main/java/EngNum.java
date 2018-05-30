import java.util.Arrays;

/**
 * Created by CBR on 2018. 5. 30..
 */
public class EngNum
{
    public String sort(final String input)
    {
        if (input.isEmpty())
        {
            throw new IllegalArgumentException("not empty");
        }

        if (!input.matches("[a-zA-Z0-9]*"))
        {
            throw new IllegalArgumentException("only english or number");
        }

        StringBuilder output = new StringBuilder();
        char[] strings = input.replaceAll("[^a-zA-Z]*", "").toCharArray();
        Arrays.sort(strings);
        String sortedString = new String(strings);

        char[] numbers = input.replaceAll("[^\\d]*", "").toCharArray();
        Arrays.sort(numbers);
        String sortedNumber = new String(numbers);

        for (int i = 0; i < input.length(); i++)
        {
            if (i > sortedString.length()-1 && i > sortedNumber.length()-1)
            {
                break;
            }

            if (i < sortedString.length())
            {
                output.append(sortedString.charAt(i));
            }
            if (i < sortedNumber.length())
            {
                output.append(sortedNumber.charAt(i));
            }
        }

        return output.toString();
    }
}
