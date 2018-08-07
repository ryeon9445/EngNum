import java.util.Arrays;

/**
 * Created by CBR on 2018. 5. 30..
 */
class EngNum
{
    private static final String MATCH_INPUT  = "[a-zA-Z0-9]*";
    private static final String MATCH_ENG    = "[^a-zA-Z]*";
    private static final String MATCH_NUM    = "[^\\d]*";

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

        if (!input.matches(MATCH_INPUT))
        {
            throw new IllegalArgumentException("only english or number");
        }

        char[] charInput = input.toCharArray();
        Arrays.sort(charInput);
        String sortedInput = new String(charInput);

        String splitEng = splitByPattern(sortedInput, MATCH_ENG);
        String splitNum = splitByPattern(sortedInput, MATCH_NUM);

        StringBuilder output = new StringBuilder();
        int range = Math.max(splitEng.length(), splitNum.length());
        for (int i = 0; i < range; i++)
        {
            if (i < splitEng.length())
            {
                output.append(splitEng.charAt(i));
            }
            if (i < splitNum.length())
            {
                output.append(splitNum.charAt(i));
            }
        }
        return output.toString();
    }

    private String splitByPattern(final String sortedInput, final String pattern)
    {
        return sortedInput.replaceAll(pattern, "");
    }
}
