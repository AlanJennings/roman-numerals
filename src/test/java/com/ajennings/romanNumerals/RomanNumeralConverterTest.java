package com.ajennings.romanNumerals;


import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverterTest = new RomanNumeralConverter();

    @Test
    public void test_canTranslateSimpleNumberToRomanNumeral()
    {
        //Given
        int one = 1;
        int four = 4;
        int nine = 9;

        //When
        String resultFromOne = romanNumeralConverterTest.parseIntToNumeral(one);
        String resultFromFour = romanNumeralConverterTest.parseIntToNumeral(four);
        String resultFromNine = romanNumeralConverterTest.parseIntToNumeral(nine);

        //Then
        assertEquals("1 return I", "I", resultFromOne);
        assertEquals("4 return IV", "IV", resultFromFour);
        assertEquals("9 return IX", "IX", resultFromNine);

    }

    @Test
    public void test_comprehensiveNumbers()
    {
        //Given
        int big = 1756;
        int bigger = 1993;
        int biggest = 3248;

        //When
        String resultFromOne = romanNumeralConverterTest.parseIntToNumeral(big);
        String resultFromFour = romanNumeralConverterTest.parseIntToNumeral(bigger);
        String resultFromNine = romanNumeralConverterTest.parseIntToNumeral(biggest);

        //Then
        assertEquals("1756 return MDCCLVI", "MDCCLVI", resultFromOne);
        assertEquals("1993 return MCMXCIII", "MCMXCIII", resultFromFour);
        assertEquals("3248 return MMMCCXLVIII", "MMMCCXLVIII", resultFromNine);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_negativeReturnsError()
    {
        //Given
        int negative = -1;

        //When
        String resultFromNegative = romanNumeralConverterTest.parseIntToNumeral(negative);

        //Then - should not be hit
        assertEquals("-1 returns error", "should not reach", resultFromNegative);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_beyondNumeralLimitReturnError()
    {
        //Given
        int beyondNumeralLimit = 4000;

        //When
        String resultFromBeyondRomanNumeralLimit = romanNumeralConverterTest.parseIntToNumeral(beyondNumeralLimit);

        //Then - should not be hit
        assertEquals("4000 returns error", "should not reach", resultFromBeyondRomanNumeralLimit);
    }
}
