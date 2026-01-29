package ca.bcit.comp2522.fantasycreature;

/**
 * Models an Orc that can go berserk.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */

public class Orc extends Creature
{
    private static final int MAX_RAGE          = 30;
    private static final int MIN_RAGE          = 0;
    private static final int NORMAL_RAGE_DEALT = 15;
    private static final int DOUBLE_RAGE_DEALT = 30;
    private static final int RAGE_GAINED       = 5;
    private static final int MIN_RAGE_REQUIRED = 5;
    private static final int RAGE_FOR_DOUBLE   = 20;

    private int rage;

    /**
     * Constructs an Orc.
     *
     * @param name        The name of this Orc
     * @param dateOfBirth The date of birth of this Orc
     * @param health      The amount of health this Orc has
     * @param rage        The amount of rage this Orc has
     */
    public Orc(final String name,
               final Date dateOfBirth,
               final int health,
               final int rage)
    {
        super(name, dateOfBirth, health);

        validateRage(rage);

        this.rage = rage;
    }

    /**
     * Validates the rage.
     *
     * @param rage the rage to be validated
     */
    private static void validateRage(final int rage)
    {
        if (rage < MIN_RAGE || rage > MAX_RAGE)
        {
            throw new IllegalArgumentException("Invalid rage: " + rage);
        }
    }

    /**
     * Prints the details of the Orc, including the
     * name, date of birth, age, health, and rage.
     */
    @Override
    public void getDetails()
    {
        final StringBuilder builder;
        builder = new StringBuilder();
        builder.append("\nCreature:\nName : ");
        builder.append(getName());
        builder.append("\nDOB: ");
        builder.append(getBirthMonth());
        builder.append(" ");
        builder.append(getBirthDay());
        builder.append(", ");
        builder.append(getBirthYear());
        builder.append("\nAge: ");
        builder.append(getAgeYears());
        builder.append(" year(s) old\nHealth: ");
        builder.append(getHealth());
        builder.append("\nRage: ");
        builder.append(rage);

        System.out.println(builder.toString());
    }

    /**
     * Increases {@code rage} by {@code RAGE_GAINED} and deals
     * {@code DOUBLE_RAGE_DEALT} to another Creature if {@code rage}
     * exceeds 20, otherwise it deals {@code NORMAL_RAGE_DEALT} instead.
     * If the {@code rage} is less than {@code MIN_RAGE_REQUIRED},
     * then a LowRageException is thrown.
     */
    public int berserk()
    {
        if (rage < MIN_RAGE_REQUIRED)
        {
            throw new LowRageException("Not enough rage: " + rage);
        }

        rage += RAGE_GAINED;
        if (rage > MAX_RAGE)
        {
            rage = MAX_RAGE;
        }

        if (rage > RAGE_FOR_DOUBLE)
        {
            return DOUBLE_RAGE_DEALT;
        }
        else
        {
            return NORMAL_RAGE_DEALT;
        }
    }
}
