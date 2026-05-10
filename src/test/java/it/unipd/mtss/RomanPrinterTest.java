////////////////////////////////////////////////////////////////////
// Dorde Blagojevic 2116424
// Leonardo Soligo 2111042
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RomanPrinterTest {
    private static final String NL = System.lineSeparator();
    private static final String[] I = {
        " _____ ",
        "|_   _|",
        "  | |  ",
        "  | |  ",
        " _| |_ ",
        "|_____|"
    };
    private static final String[] V = {
        "__      __",
        "\\ \\    / /",
        " \\ \\  / / ",
        "  \\ \\/ /  ",
        "   \\  /   ",
        "    \\/    "
    };
    private static final String[] X = {
        "__   __",
        "\\ \\ / /",
        " \\ V / ",
        "  > <  ",
        " / . \\ ",
        "/_/ \\_\\"
    };
    private static final String[] L = {
        " _      ",
        "| |     ",
        "| |     ",
        "| |     ",
        "| |____ ",
        "|______|"
    };
    private static final String[] C = {
        " _____ ",
        "/ ____|",
        "| |    ",
        "| |    ",
        "| |____",
        " \\____|"
    };
    private static final String[] D = {
        " _____  ",
        "|  __ \\ ",
        "| |  | |",
        "| |  | |",
        "| |__| |",
        "|_____/ "
    };
    private static final String[] M = {
        " __  __",
        "|  \\/  |",
        "| \\  / |",
        "| |\\/| |",
        "| |  | |",
        "|_|  |_|"
    };

    @Test
    public void printShouldReturnAsciiArtForSingleRomanSymbols() {
        assertEquals(asciiArt(I), RomanPrinter.print(1));
        assertEquals(asciiArt(V), RomanPrinter.print(5));
        assertEquals(asciiArt(X), RomanPrinter.print(10));
        assertEquals(asciiArt(L), RomanPrinter.print(50));
        assertEquals(asciiArt(C), RomanPrinter.print(100));
        assertEquals(asciiArt(D), RomanPrinter.print(500));
        assertEquals(asciiArt(M), RomanPrinter.print(1000));
    }

    @Test
    public void printShouldReturnAsciiArtForCompositeRomanNumber() {
        String expectedAsciiArt = asciiArt(I, V);

        String actualAsciiArt = RomanPrinter.print(4);

        assertEquals(expectedAsciiArt, actualAsciiArt);
    }

    @Test
    public void printShouldThrowExceptionWhenNumberIsOutOfRange() {
        try {
            RomanPrinter.print(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("Number must be between 1 and 1000", exception.getMessage());
        }
    }

    private static String asciiArt(String[]... symbols) {
        StringBuilder asciiArt = new StringBuilder();

        for (int row = 0; row < I.length; row++) {
            if (row > 0) {
                asciiArt.append(NL);
            }

            for (int symbol = 0; symbol < symbols.length; symbol++) {
                if (symbol > 0) {
                    asciiArt.append(" ");
                }
                asciiArt.append(symbols[symbol][row]);
            }
        }

        return asciiArt.toString();
    }
}
