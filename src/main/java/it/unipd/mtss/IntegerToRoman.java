////////////////////////////////////////////////////////////////////
// Dorde Blagojevic 2116424
// Leonardo Soligo 2111042
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

/**
 * Utility class for converting Arabic integers to Roman numerals.
 */
public class IntegerToRoman {
    private static final int[] ARABIC_VALUES = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    private static final String[] ROMAN_SYMBOLS = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private IntegerToRoman() {
        // Private constructor: prevent instantiation
    }

    /**
     * Converts an Arabic integer between 1 and 1000 to its Roman numeral representation.
     *
     * @param number the integer to convert
     * @return the Roman numeral representation of the input number
     * @throws IllegalArgumentException if the number is outside the supported range
     */
    public static String convert(int number) {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        StringBuilder romanNumber = new StringBuilder();
        int remainingNumber = number;

        for (int i = 0; i < ARABIC_VALUES.length; i++) {
            while (remainingNumber >= ARABIC_VALUES[i]) {
                romanNumber.append(ROMAN_SYMBOLS[i]);
                remainingNumber -= ARABIC_VALUES[i];
            }
        }

        return romanNumber.toString();
    }
}
