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
    private final Date   dateOfBirth;
    private       int    health;

    private static final int MIN_HEALTH        = 1;
    private static final int MAX_HEALTH        = 100;
    private static final int BASE_VALUE        = 0;
    private static final int MIN_HEAL_AMOUNT   = 0;
    private static final int MIN_DAMAGE_AMOUNT = 0;

    /**
     * Constructs a creature of a fantasy world.
     *
     * @param name        The name of the creature
     * @param dateOfBirth The date of birth of the creature
     * @param health      The amount of health the creature has
     */
    Creature(final String name,
             final Date dateOfBirth,
             final int health)
    {
        validateName(name);
        validateDate(dateOfBirth);
        validateHealth(health);

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.health      = health;
    }

    /**
     * Checks if the creature's name is null or blank or just whitespace.
     *
     * @param name The creature's name to validate
     */
    private static void validateName(final String name)
    {
        if (name == null ||
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
    {
        if (dateOfBirth == null)
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
    {
        if (health < MIN_HEALTH ||
            health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between 1 and 100: " + health);
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
     */
    public void takeDamage(final int damage)
    {
        if (damage < MIN_DAMAGE_AMOUNT)
        {
            throw new DamageException("Damage cannot be negative: " + damage);
        }

        health -= damage;
        if (health < MIN_HEALTH)
        {
            health = MIN_HEALTH;
        }
    }

    /**
     * Heals the creature's health by the given healing amount.
     *
     * @param healAmount the amount of healing the creature takes
     */
    public void heal(final int healAmount)

    {
        if (healAmount < MIN_HEAL_AMOUNT)
        {
            throw new HealingException("Healing amount cannot be negative: " + healAmount);
        }

        health += healAmount;
        if (health > MAX_HEALTH)
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
        final int tempYear = dateOfBirth.getYear();
        final int tempMonth = dateOfBirth.getMonthInt();
        final int tempDay;

        if (dateOfBirth.month == Date.getFebruaryMonthNum() &&
            dateOfBirth.day == Date.getLongFebMonthTotal())
        {
            tempDay = Date.getShortFebMonthTotal();
        }
        else
        {
            tempDay = dateOfBirth.getDay();
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
     * Gets this Creature's name.
     *
     * @return this Creature's name
     */
    protected String getName()
    {
        return name;
    }

    /**
     * Gets this Creature's birth month.
     *
     * @return the birth month of this Creature
     */
    protected String getBirthMonth()
    {
        return dateOfBirth.getMonthString();
    }

    /**
     * Gets this Creature's birth day.
     *
     * @return the birth day of this Creature
     */
    protected int getBirthDay()
    {
        return dateOfBirth.getDay();
    }

    /**
     * Gets this Creature's birth year.
     *
     * @return the birth year of this Creature
     */
    protected int getBirthYear()
    {
        return dateOfBirth.getYear();
    }

    /**
     * Gets this Creature's health.
     *
     * @return the health of this Creature
     */
    protected int getHealth()
    {
        return health;
    }

    /**
     * Prints the details of the creature, such as:
     * name, date of birth, age, and health.
     */
    public void getDetails()
    {
        final StringBuilder builder;
        builder = new StringBuilder();
        builder.append("\nCreature:\nName : ");
        builder.append(name);
        builder.append("\nDOB: ");
        builder.append(dateOfBirth.getMonthString());
        builder.append(" ");
        builder.append(dateOfBirth.getDay());
        builder.append(", ");
        builder.append(dateOfBirth.getYear());
        builder.append("\nAge: ");
        builder.append(getAgeYears());
        builder.append(" year(s) old\nHealth: ");
        builder.append(health);

        System.out.println(builder.toString());
    }
}
