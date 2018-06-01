import org.junit.Assert;
import org.junit.Test;

/**
 * Created by CBR on 2018. 5. 30..
 */
public class EngNumTest
{
    /**
     * 영어+숫자, 오름차순
     * abzb09 --> a0b9bz
     * 1098 --> 0189
     * zyca --> acyz
     * 79az0b --> a0b7z9
     */

    @Test
    public void execute()
    {
        EngNum engNum = new EngNum();
        Assert.assertEquals("a0b9bz", engNum.sort("abzb09"));
        Assert.assertEquals("0189", engNum.sort("1098"));
        Assert.assertEquals("acyz", engNum.sort("zyca"));
        Assert.assertEquals("a0b7z9", engNum.sort("79az0b"));

        Assert.assertEquals("aadeffiijjosww", engNum.sort("sadfjaiwfjioew"));
        Assert.assertEquals("00111222333999", engNum.sort("12391023901293"));
        Assert.assertEquals("a0d2d3e3k4k9o9opsvw", engNum.sort("dovkwpoek3093249asd"));
        Assert.assertEquals("a0a0a0a0a0a0a0d0e0e2e2e2f2f2f2f3f3f3f3i3i3i3i4i4j8j8j9j9j9j9k9l9l9o9o9qqrrsswwww",
                engNum.sort("sdlkfjalsjfiweajfioawejfoiae9230482390483902rqj0a9fjaw09302390932ir09q23if09awef"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void nullException()
    {
        EngNum engNum = new EngNum();
        engNum.sort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyException()
    {
        EngNum engNum = new EngNum();
        engNum.sort("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void onlyEngNumberException()
    {
        EngNum engNum = new EngNum();
        engNum.sort("a0bㅇㅇ9bz");
    }
}
