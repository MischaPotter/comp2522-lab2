package ca.bcit.comp2522.fantasycreature;

/**
 * Models a checked exception that is thrown to indicate that an Elf
 * does not have enough mana to cast a spell.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class LowManaException extends Exception
{
    /**
     * Constructs a {@code LowManaException} with the given message.
     *
     * @param message the given message explaining the cause of the exception
     */
    public LowManaException(String message)
    {
        super(message);
    }
}
