package com.ajennings.romanNumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static LinkedHashMap<Integer, String> romanNumerals = new LinkedHashMap<>();

    static {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    protected String parseIntToNumeral(int number)
    {
        checkValidIntegerForRomanNumeral(number);

        StringBuilder text = new StringBuilder();

        getIntegerForRomanNumeral(number, text);

        return text.toString();
    }

    private void checkValidIntegerForRomanNumeral(int number)
    {
        if (number < 1 || number > 3999)
        {
            throw new IllegalArgumentException("Invalid Roman Numeral");
        }
    }

    private int getIntegerForRomanNumeral(int number, StringBuilder text)
    {

        for (Map.Entry<Integer,String> set: romanNumerals.entrySet())
        {
            if (number >= set.getKey())
            {
                text.append(set.getValue());
                number -= set.getKey();
                break;
            }
        }

        if (number > 0)
        {
            getIntegerForRomanNumeral(number, text);
        }

        return number;
    }
}
