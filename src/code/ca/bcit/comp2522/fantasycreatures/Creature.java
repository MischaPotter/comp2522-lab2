package ca.bcit.comp2522.fantasycreatures;

/**
 *
 *
 * @author Mischa Potter
 * @author Abdullah Munawar
 * @version 1.0
 */
public class Creature
{
    private final String name;
    private final Date dateOfBirth;
    private final int health;

    private static final int MIN_HEALTH = 1;
    private static final int MAX_HEALTH = 100;

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

    private static void validateName(final String name)
            throws IllegalArgumentException
    {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    private static void validateDate(final Date dateOfBirth)
            throws IllegalArgumentException
    {
        if(dateOfBirth == null)
        {
            throw new IllegalArgumentException("The date cannot be null");
        }
    }

    private static void validateHealth(final int health)
            throws IllegalArgumentException
    {
        if(health < MIN_HEALTH || health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between 1 and 100");
        }
    }

    public boolean isAlive()
    {
        return health > MIN_HEALTH;
    }

    public void takeDamage(final int damage)
    {
        if(damage < 0)
        {
            throw new DamageException("Damage cannot be negative");
        }

        health -= damage;
        if(health < MIN_HEALTH)
        {
            health = 0;
        }
    }

    public void heal(final int healAmount)
    {
        if(healAmount < 0)
        {
            throw new HealingException("Healing amount cannot be negative");
        }

        health += healAmount;
        if(health > MAX_HEALTH)
        {
            health = 100;
        }
    }
}
