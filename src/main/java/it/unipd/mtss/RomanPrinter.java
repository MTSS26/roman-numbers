////////////////////////////////////////////////////////////////////
// Dorde Blagojevic 2116424
// Leonardo Soligo 2111042
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

/**
 * Utility class for rendering Roman numerals as ASCII art.
 */
public class RomanPrinter {
    private static final int ASCII_HEIGHT = 6;
    private static final String SYMBOL_SEPARATOR = " ";

    private RomanPrinter() {
        // Private constructor: prevent instantiation
    }

    /**
     * Converts an Arabic integer to a Roman numeral and renders it as ASCII art.
     *
     * @param num the integer to convert and print
     * @return the ASCII art representation of the Roman numeral
     * @throws IllegalArgumentException if the number is outside the supported range
     */
    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) {
        StringBuilder[] asciiRows = new StringBuilder[ASCII_HEIGHT];

        for (int row = 0; row < ASCII_HEIGHT; row++) {
            asciiRows[row] = new StringBuilder();
        }

        for (int i = 0; i < romanNumber.length(); i++) {
            String[] symbolRows = getAsciiSymbol(romanNumber.charAt(i));

            for (int row = 0; row < ASCII_HEIGHT; row++) {
                if (i > 0) {
                    asciiRows[row].append(SYMBOL_SEPARATOR);
                }
                asciiRows[row].append(symbolRows[row]);
            }
        }

        StringBuilder asciiArt = new StringBuilder();

        for (int row = 0; row < ASCII_HEIGHT; row++) {
            asciiArt.append(asciiRows[row]);
            if (row < ASCII_HEIGHT - 1) {
                asciiArt.append(System.lineSeparator());
            }
        }

        return asciiArt.toString();
    }

    private static String[] getAsciiSymbol(char symbol) {
        switch (symbol) {
            case 'I':
                return new String[] {
                    " _____ ",
                    "|_   _|",
                    "  | |  ",
                    "  | |  ",
                    " _| |_ ",
                    "|_____|"
                };
            case 'V':
                return new String[] {
                    "__      __",
                    "\\ \\    / /",
                    " \\ \\  / / ",
                    "  \\ \\/ /  ",
                    "   \\  /   ",
                    "    \\/    "
                };
            case 'X':
                return new String[] {
                    "__   __",
                    "\\ \\ / /",
                    " \\ V / ",
                    "  > <  ",
                    " / . \\ ",
                    "/_/ \\_\\"
                };
            case 'L':
                return new String[] {
                    " _      ",
                    "| |     ",
                    "| |     ",
                    "| |     ",
                    "| |____ ",
                    "|______|"
                };
            case 'C':
                return new String[] {
                    " _____ ",
                    "/ ____|",
                    "| |    ",
                    "| |    ",
                    "| |____",
                    " \\____|"
                };
            case 'D':
                return new String[] {
                    " _____  ",
                    "|  __ \\ ",
                    "| |  | |",
                    "| |  | |",
                    "| |__| |",
                    "|_____/ "
                };
            case 'M':
                return new String[] {
                    " __  __",
                    "|  \\/  |",
                    "| \\  / |",
                    "| |\\/| |",
                    "| |  | |",
                    "|_|  |_|"
                };
            default:
                throw new IllegalArgumentException("Invalid Roman symbol: " + symbol);
        }
    }
}
