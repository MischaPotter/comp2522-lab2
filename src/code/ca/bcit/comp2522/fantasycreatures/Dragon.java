package ca.bcit.comp2522.fantasycreatures;

/**
 * Models a Dragon that can breathe fire.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */

public class Dragon extends Creature
{
    private static final int MAX_FIREPOWER          = 100;
    private static final int MIN_FIREPOWER          = 0;
    private static final int FIREPOWER_DEALT        = 20;
    private static final int FIREPOWER_LOST         = 10;
    private static final int MIN_FIREPOWER_REQUIRED = 10;
    private static final int NO_DAMAGE_DEALT        = 0;

    private int firePower;

    /**
     * Constructs a Dragon.
     *
     * @param name        The name of this Dragon
     * @param dateOfBirth The date of birth of this Dragon
     * @param health      The amount of health this Dragon has
     * @param firePower   The amount of firepower this Dragon has
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name, dateOfBirth, health);

        validateFirePower(firePower);

        this.firePower = firePower;
    }

    /**
     * Validates the firepower.
     *
     * @param firePower the firepower to be validated
     */
    private static void validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIREPOWER ||
            firePower > MAX_FIREPOWER)
        {
            throw new IllegalArgumentException("Invalid firepower: " + firePower);
        }
    }

    /**
     * Prints the details of the Dragon, including the
     * name, date of birth, age, health, and firepower.
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
        builder.append("\nFirepower: ");
        builder.append(firePower);

        System.out.println(builder.toString());
    }

    /**
     * Reduces {@code firePower} by {@code FIREPOWER_LOST} and deals {@code FIREPOWER_DEALT}
     * to another Creature. If the {@code firePower} is less than {@code MIN_FIREPOWER_REQUIRED},
     * then a LowFirePowerException is thrown.
     *
     * @throws LowFirePowerException if there isn't enough firepower to breathe firepower
     */
    public int breatheFire() throws LowFirePowerException
    {
        try
        {
            if (firePower < MIN_FIREPOWER_REQUIRED)
            {
                throw new LowFirePowerException("Not enough firepower to breathe fire: " + firePower);
            }
            firePower -= FIREPOWER_LOST;
            return FIREPOWER_DEALT;
        }
        catch (LowFirePowerException e)
        {
            System.out.println(e.getMessage());
            return NO_DAMAGE_DEALT;
        }
    }

    /**
     * Adds the amount of {@code amount} to {@code firePower}. If the amount added to {@code firePower} surpasses {@code
     * MAX_FIREPOWER}, an {@code IllegalArgumentException} is thrown.
     *
     * @param amount the amount of firePower to be added to the total firepower
     */
    public void restoreFirePower(final int amount)
    {
        if ((firePower + amount) > MAX_FIREPOWER)
        {
            throw new IllegalArgumentException("Total amount added to firePower cannot exceed 100: " + amount);
        }

        firePower += amount;
    }
}
