////////////////////////////////////////////////////////////////////
// Dorde Blagojevic 2116424
// Leonardo Soligo 2111042
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class IntegerToRomanTest {
    @Test
    public void convertShouldReturnRomanSymbolsForBaseValues() {
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("V", IntegerToRoman.convert(5));
        assertEquals("X", IntegerToRoman.convert(10));
        assertEquals("L", IntegerToRoman.convert(50));
        assertEquals("C", IntegerToRoman.convert(100));
        assertEquals("D", IntegerToRoman.convert(500));
        assertEquals("M", IntegerToRoman.convert(1000));
    }

    @Test
    public void convertShouldReturnRepeatedSymbolsForAdditiveValues() {
        assertEquals("II", IntegerToRoman.convert(2));
        assertEquals("III", IntegerToRoman.convert(3));
        assertEquals("VI", IntegerToRoman.convert(6));
        assertEquals("VIII", IntegerToRoman.convert(8));
        assertEquals("XX", IntegerToRoman.convert(20));
        assertEquals("XXX", IntegerToRoman.convert(30));
    }

    @Test
    public void convertShouldReturnSubtractiveNotationValues() {
        assertEquals("IV", IntegerToRoman.convert(4));
        assertEquals("IX", IntegerToRoman.convert(9));
        assertEquals("XL", IntegerToRoman.convert(40));
        assertEquals("XC", IntegerToRoman.convert(90));
        assertEquals("CD", IntegerToRoman.convert(400));
        assertEquals("CM", IntegerToRoman.convert(900));
    }

    @Test
    public void convertShouldReturnCompositeRomanNumbers() {
        assertEquals("XIX", IntegerToRoman.convert(19));
        assertEquals("XLIX", IntegerToRoman.convert(49));
        assertEquals("LVIII", IntegerToRoman.convert(58));
        assertEquals("XCIX", IntegerToRoman.convert(99));
        assertEquals("CXCIX", IntegerToRoman.convert(199));
        assertEquals("CMXLIV", IntegerToRoman.convert(944));
    }

    @Test
    public void convertShouldThrowExceptionWhenNumberIsZero() {
        try {
            IntegerToRoman.convert(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("Number must be between 1 and 1000", exception.getMessage());
        }
    }

    @Test
    public void convertShouldThrowExceptionWhenNumberIsNegative() {
        try {
            IntegerToRoman.convert(-1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("Number must be between 1 and 1000", exception.getMessage());
        }
    }

    @Test
    public void convertShouldThrowExceptionWhenNumberIsGreaterThanLimit() {
        try {
            IntegerToRoman.convert(1001);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("Number must be between 1 and 1000", exception.getMessage());
        }
    }
}
