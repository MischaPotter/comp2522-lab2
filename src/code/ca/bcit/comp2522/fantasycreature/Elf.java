package ca.bcit.comp2522.fantasycreature;

/**
 * Models an Elf that can cast spells.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */

public class Elf extends Creature
{
    private static final int MAX_MANA          = 50;
    private static final int MIN_MANA          = 0;
    private static final int DAMAGE_DEALT      = 10;
    private static final int MANA_LOST         = 5;
    private static final int MIN_MANA_REQUIRED = 5;
    private static final int NO_DAMAGE_DEALT   = 0;

    private int mana;

    /**
     * Constructs an Elf.
     *
     * @param name        The name of this Elf
     * @param dateOfBirth The date of birth of this Elf
     * @param health      The amount of health this Elf has
     * @param mana        The amount of mana this Elf has
     */
    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);

        validateMana(mana);

        this.mana = mana;
    }

    /*
     * Validates the mana.
     *
     * @param mana the mana to be validated
     */
    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("Invalid mana: " + mana);
        }
    }

    /**
     * Prints the details of the Elf, including the
     * name, date of birth, age, health, and mana.
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
        builder.append("\nMana: ");
        builder.append(mana);

        System.out.println(builder.toString());
    }

    /**
     * Reduces {@code mana} by {@code MANA_LOST} and deals {@code MANA_DEALT}
     * to another Creature. If the {@code mana} is less than {@code MIN_MANA_REQUIRED},
     * then a LowManaException is thrown.
     *
     * @throws LowManaException if there isn't enough mana to cast a spell
     */
    public int castSpell() throws LowManaException
    {
        try
        {
            if (mana < MIN_MANA_REQUIRED)
            {
                throw new LowManaException("Not enough mana to cast a spell: " + mana);
            }
            mana -= MANA_LOST;
            return DAMAGE_DEALT;
        }
        catch (LowManaException e)
        {
            System.out.println(e.getMessage());
            return NO_DAMAGE_DEALT;
        }
    }

    /**
     * Adds the amount of {@code amount} to {@code mana}. If the amount
     * added to {@code mana} surpasses {@code MAX_MANA}, an
     * {@code IllegalArgumentException} is thrown.
     *
     * @param amount the amount of mana to be added to the total mana
     */
    public void restoreMana(final int amount)
    {
        if ((mana + amount) > MAX_MANA)
        {
            throw new IllegalArgumentException("Total amount added to mana cannot exceed it past 50: " + amount);
        }

        mana += amount;
    }
}
