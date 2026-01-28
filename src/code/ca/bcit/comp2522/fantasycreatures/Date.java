package ca.bcit.comp2522.fantasycreatures;

/**
 * Models the birth date of a fantasy creature.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class Date
{
    private static final int CURRENT_YEAR  = 2026;
    private static final int CURRENT_MONTH = 1;
    private static final int CURRENT_DAY   = 25;

    private static final int JANUARY_MONTH_NUM   = 1;
    private static final int FEBRUARY_MONTH_NUM  = 2;
    private static final int MARCH_MONTH_NUM     = 3;
    private static final int APRIL_MONTH_NUM     = 4;
    private static final int MAY_MONTH_NUM       = 5;
    private static final int JUNE_MONTH_NUM      = 6;
    private static final int JULY_MONTH_NUM      = 7;
    private static final int AUGUST_MONTH_NUM    = 8;
    private static final int SEPTEMBER_MONTH_NUM = 9;
    private static final int OCTOBER_MONTH_NUM   = 10;
    private static final int NOVEMBER_MONTH_NUM  = 11;
    private static final int DECEMBER_MONTH_NUM  = 12;

    private static final int DAY_ONE                    = 1;
    private static final int SHORT_FEBRUARY_MONTH_TOTAL = 28;
    private static final int LONG_FEBRUARY_MONTH_TOTAL  = 29;
    private static final int SHORT_MONTH                = 30;
    private static final int LONG_MONTH                 = 31;
    private static final int YEAR_EVERY_LEAP_YEAR       = 4;
    private static final int YEAR_EVERY_CENTURY         = 100;
    private static final int YEAR_EVERY_FOUR_CENTURY    = 400;
    private static final int DIVISIBLE                  = 0;

    public final int year;
    public final int month;
    public final int day;

    /**
     * Constructs the birth date of a fantasy creature.
     *
     * @param year  This is the first parameter for a year
     * @param month This is the second parameter for a month
     * @param day   This is the third parameter for a day
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Date(final int year,
                final int month,
                final int day)
        throws IllegalArgumentException
    {
        validateYear(year);
        validateMonth(month, year);
        validateDay(day, month, year);

        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    /**
     * Checks if the year is greater than CURRENT_YEAR
     *
     * @param year The year to validate
     */
    private static void validateYear(final int year)
        throws IllegalArgumentException
    {
        if (year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year cannot be in the future");
        }
    }

    /**
     * Checks if the month, represented as an int, is less than 1
     * (JANUARY_MONTH_NUM) OR greater than 12 (DECEMBER_MONTH_NUM).
     * If the birth year is the same as the current year, it also
     * checks if the birth month is ahead of the current month.
     *
     * @param month The month of the year to validate
     * @param year  The year value
     */
    private static void validateMonth(final int month,
                                      final int year)
        throws IllegalArgumentException
    {
        if (month < JANUARY_MONTH_NUM ||
            month > DECEMBER_MONTH_NUM)
        {
            throw new IllegalArgumentException("Month is out of range");
        }
        else if (year == CURRENT_YEAR &&
                 month > CURRENT_MONTH)
        {
            throw new IllegalArgumentException("Month cannot be in the future");
        }
    }

    /**
     * Checks if the day is within the valid range for the specific month and
     * year. If the birth year and month are the same as the current year and
     * month, it also checks if the birth day is ahead of the current day.
     *
     * @param day   The day of the month to validate
     * @param month The month value
     * @param year  The year value
     */
    private static void validateDay(final int day,
                                    final int month,
                                    final int year)
        throws IllegalArgumentException
    {
        if (day < DAY_ONE)
        {
            throw new IllegalArgumentException("Day is out of range");
        }

        if (month == JANUARY_MONTH_NUM ||
            month == MARCH_MONTH_NUM ||
            month == MAY_MONTH_NUM ||
            month == JULY_MONTH_NUM ||
            month == AUGUST_MONTH_NUM ||
            month == OCTOBER_MONTH_NUM ||
            month == DECEMBER_MONTH_NUM)
        {
            if (day > LONG_MONTH)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else if (month == APRIL_MONTH_NUM ||
                 month == JUNE_MONTH_NUM ||
                 month == SEPTEMBER_MONTH_NUM ||
                 month == NOVEMBER_MONTH_NUM)
        {
            if (day > SHORT_MONTH)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else
        {
            if (year % YEAR_EVERY_LEAP_YEAR == DIVISIBLE &&
                year % YEAR_EVERY_CENTURY != DIVISIBLE)
            {
                if (day > LONG_FEBRUARY_MONTH_TOTAL)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
            else if (year % YEAR_EVERY_FOUR_CENTURY == DIVISIBLE)
            {
                if (day > LONG_FEBRUARY_MONTH_TOTAL)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
            else
            {
                if (day > SHORT_FEBRUARY_MONTH_TOTAL)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
        }

        if (year == CURRENT_YEAR &&
            month == CURRENT_MONTH &&
            day > CURRENT_DAY)
        {
            throw new IllegalArgumentException("Day cannot be in the future");
        }
    }

    /**
     * Returns the date's day.
     *
     * @return the date's day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the date's month in String form.
     *
     * @return the date's month in String form
     */
    public String getMonthString()
    {
        return switch (month)
        {
            case JANUARY_MONTH_NUM -> "January";
            case FEBRUARY_MONTH_NUM -> "February";
            case MARCH_MONTH_NUM -> "March";
            case APRIL_MONTH_NUM -> "April";
            case MAY_MONTH_NUM -> "May";
            case JUNE_MONTH_NUM -> "June";
            case JULY_MONTH_NUM -> "July";
            case AUGUST_MONTH_NUM -> "August";
            case SEPTEMBER_MONTH_NUM -> "September";
            case OCTOBER_MONTH_NUM -> "October";
            case NOVEMBER_MONTH_NUM -> "November";
            case DECEMBER_MONTH_NUM -> "December";
            default -> throw new IllegalStateException("An error occurred");
        };
    }

    /**
     * Gets the date's month as an int.
     *
     * @return the date's month as an int
     */
    public int getMonthInt()
    {
        return month;
    }

    /**
     * Returns the date's year.
     *
     * @return the date's year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the current year.
     *
     * @return the current year
     */
    public static int getCurrentYear()
    {
        return CURRENT_YEAR;
    }

    /**
     * Returns the current month.
     *
     * @return the current month
     */
    public static int getCurrentMonth()
    {
        return CURRENT_MONTH;
    }

    /**
     * Returns the current day.
     *
     * @return the current day
     */
    public static int getCurrentDay()
    {
        return CURRENT_DAY;
    }

    /**
     * Returns February's month number.
     *
     * @return February's month number
     */
    public static int getFebruaryMonthNum()
    {
        return FEBRUARY_MONTH_NUM;
    }

    /**
     * Returns the number of days in February during a leap year.
     *
     * @return the number of days in February during a leap year
     */
    public static int getLongFebMonthTotal()
    {
        return LONG_FEBRUARY_MONTH_TOTAL;
    }

    /**
     * Returns the number of days in February during a regular year.
     *
     * @return the number of days in February during a regular year
     */
    public static int getShortFebMonthTotal()
    {
        return SHORT_FEBRUARY_MONTH_TOTAL;
    }
}
