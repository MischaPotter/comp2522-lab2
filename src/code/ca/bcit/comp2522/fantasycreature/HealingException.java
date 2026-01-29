package ca.bcit.comp2522.fantasycreature;

/**
 * Models an unchecked exception that is thrown to
 * indicate that an invalid healing amount was provided.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class HealingException extends RuntimeException
{
    /**
     * Constructs a {@code HealingException} with the given message.
     *
     * @param message the given message explaining the cause of the exception
     */
    public HealingException(final String message)
    {
        super(message);
    }
}

