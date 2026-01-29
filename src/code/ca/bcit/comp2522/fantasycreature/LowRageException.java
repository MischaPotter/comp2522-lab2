package ca.bcit.comp2522.fantasycreature;

/**
 * Models an unchecked exception that is thrown to indicate that an Orc
 * does not have enough rage to go berserk.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class LowRageException extends RuntimeException
{
    /**
     * Constructs a {@code LowRageException} with the given message.
     *
     * @param message the given message explaining the cause of the exception
     */
    public LowRageException(final String message)
    {
        super(message);
    }
}

