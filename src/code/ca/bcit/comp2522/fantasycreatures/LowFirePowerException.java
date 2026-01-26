package ca.bcit.comp2522.fantasycreatures;

/**
 * Models a checked exception that is thrown to indicate that a Dragon
 * does not have enough firepower to breathe fire.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class LowFirePowerException extends Exception
{
    /**
     * Constructs a {@code LowFirePowerException} with the given message.
     *
     * @param message the given message explaining the cause of the exception
     */
    public LowFirePowerException(String message)
    {
        super(message);
    }
}
