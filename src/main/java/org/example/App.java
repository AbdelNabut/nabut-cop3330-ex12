package org.example;
import java.math.RoundingMode;
import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;

public class App 
{
    public static void main( String[] args )
    {
        // Switched from primitive data types to the BigDecimal class to handle currencies with precision.
        BigDecimal principle, years;
        BigDecimal rate, percentRate, value;
        Scanner input = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.print( "Enter the principle: " );
        principle = input.nextBigDecimal();
        System.out.print( "Enter the % rate of interest : " );
        percentRate = input.nextBigDecimal();
        rate = percentRate.divide(BigDecimal.valueOf(100));
        System.out.print( "Enter the number of years: " );
        years = input.nextBigDecimal();
        value = principle
                .multiply((BigDecimal.valueOf(1).add((rate.multiply(years)))))
                .setScale(2, RoundingMode.HALF_UP);;
        System.out.println("After " + years + " years at " + percentRate
                + "%, the investment will be worth " + formatter.format(value));


    }
}
