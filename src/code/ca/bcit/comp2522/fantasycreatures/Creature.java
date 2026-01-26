package ca.bcit.comp2522.fantasycreatures;

/**
 * This class models the creatures of a fantasy world.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * 
 * @version 1.0
 */
public class Creature
{
    private final String name;
    private final Date dateOfBirth;
    private int health;

    private static final int MIN_HEALTH = 1;
    private static final int MAX_HEALTH = 100;
    private static final int BASE_VALUE = 0;

    /**
     * Constructs a creature of a fantasy world.
     *
     * @param name The name of the creature
     * @param dateOfBirth The date of birth of the creature
     * @param health The amount of health the creature has
     * @throws IllegalArgumentException if any parameter is invalid
     */
    Creature(final String name,
            final Date dateOfBirth,
            final int health)
            throws IllegalArgumentException
    {
        validateName(name);
        validateDate(dateOfBirth);
        validateHealth(health);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    /**
     * Checks if the creature's name is null or blank or just whitespace.
     *
     * @param name The creature's name to validate
     */
    private static void validateName(final String name)
            throws IllegalArgumentException
    {
        if(name == null ||
            name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /**
     * Checks if the creature's date of birth is null.
     *
     * @param dateOfBirth The creature's date of birth to validate
     */
    private static void validateDate(final Date dateOfBirth)
            throws IllegalArgumentException
    {
        if(dateOfBirth == null)
        {
            throw new IllegalArgumentException("The date cannot be null");
        }
    }

    /**
     * Checks if the creature's health is outside the range of 1-100.
     *
     * @param health The creature's health amount to validate
     */
    private static void validateHealth(final int health)
            throws IllegalArgumentException
    {
        if(health < MIN_HEALTH ||
            health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between 1 and 100");
        }
    }

    /**
     * Returns whether the creature is alive or not.
     *
     * @return whether the creature is alive or not
     */
    public boolean isAlive()
    {
        return health >= MIN_HEALTH;
    }

    /**
     * Reduces the creature's health by the given damage amount.
     *
     * @param damage the amount of damage the creature takes
     * @throws DamageException if {@code damage} is less than 0
     */
    public void takeDamage(final int damage)
            throws DamageException
    {
        if(damage < BASE_VALUE)
        {
            throw new DamageException("Damage cannot be negative");
        }

        health -= damage;
        if(health < MIN_HEALTH)
        {
            health = MIN_HEALTH;
        }
    }

    /**
     * Heals the creature's health by the given healing amount.
     *
     * @param healAmount the amount of healing the creature takes
     * @throws HealingException if {@code healAmount} is less than 0
     */
    public void heal(final int healAmount)
            throws HealingException
    {
        if(healAmount < BASE_VALUE)
        {
            throw new HealingException("Healing amount cannot be negative");
        }

        health += healAmount;
        if(health > MAX_HEALTH)
        {
            health = MAX_HEALTH;
        }
    }

    /**
     * Returns the age of the creature in years.
     *
     * @return the age of the creature in years
     */
    public int getAgeYears()
    {
        final int tempYear = dateOfBirth.year;
        final int tempMonth = dateOfBirth.month;
        final int tempDay;
        
        if (dateOfBirth.month == Date.getFebruaryMonthNum() &&
            dateOfBirth.day == Date.getLongFebMonthTotal())
        {
            tempDay = Date.getShortFebMonthTotal();
        }
        else
        {
            tempDay = dateOfBirth.day;
        }

        if (Date.getCurrentYear() == tempYear)
        {
            return BASE_VALUE;
        }

        int ageInYears;
        ageInYears = Date.getCurrentYear() - tempYear;

        if (Date.getCurrentMonth() < tempMonth ||
            (Date.getCurrentMonth() == tempMonth &&
            Date.getCurrentDay() < tempDay))
        {
            ageInYears--;
        }

        return ageInYears;
    }

    /**
     * Prints the details of the creature, such as:
     * name, date of birth, age, and health.
     */
    public void getDetails()
    {
        System.out.println("\nCreature:\nName : " +
                name +
                "\nDOB: " +
                dateOfBirth.getMonth() +
                " " +
                dateOfBirth.getDay() +
                ", " +
                dateOfBirth.getYear() +
                "\nAge: "
                + getAgeYears() +
                " year(s) old" +
                "\nHealth: " +
                health);
    }
}
