import java.util.Arrays;

/**
 * Created by CBR on 2018. 5. 30..
 */
public class EngNum
{
    public String sort(final String input)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("do not null");
        }

        if (input.isEmpty())
        {
            throw new IllegalArgumentException("do not empty");
        }

        if (!input.matches("[a-zA-Z0-9]*"))
        {
            throw new IllegalArgumentException("only english or number");
        }

        String sortedEng = sortByPattern(input, "[^a-zA-Z]*");
        String sortedNum = sortByPattern(input, "[^\\d]*");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++)
        {
            if (i > sortedEng.length()-1 && i > sortedNum.length()-1)
            {
                break;
            }

            if (i < sortedEng.length())
            {
                output.append(sortedEng.charAt(i));
            }
            if (i < sortedNum.length())
            {
                output.append(sortedNum.charAt(i));
            }
        }
        return output.toString();
    }

    private String sortByPattern(final String input, final String pattern)
    {
        char[] strings = input.replaceAll(pattern, "").toCharArray();
        Arrays.sort(strings);
        return new String(strings);
    }
}
