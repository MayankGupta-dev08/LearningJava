package dev.mayankg.clean_coding.unit2.simple.design.business.text;

import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.text.TextHelper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextHelperTest {

    TextHelper helper = new TextHelper();

    @Test
    @Disabled
    public void testSwapLastTwoCharacters() {
        assertEquals("", helper.swapLastTwoCharacters(""));
        assertEquals("A", helper.swapLastTwoCharacters("A"));
        assertEquals("BA", helper.swapLastTwoCharacters("AB"));
        assertEquals("RANI", helper.swapLastTwoCharacters("RAIN"));
    }

    @Test
    @Disabled
    public void testTruncateAInFirst2Positions() {
        assertEquals("", helper.truncateAInFirst2Positions(""));
        assertEquals("BCD", helper.truncateAInFirst2Positions("ABCD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("BCD", helper.truncateAInFirst2Positions("BACD"));
        assertEquals("BBAA", helper.truncateAInFirst2Positions("BBAA"));
    }
}