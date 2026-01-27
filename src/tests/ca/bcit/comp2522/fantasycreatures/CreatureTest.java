package ca.bcit.comp2522.fantasycreatures;

/**
 * This is the test class which will be used to instantiate new
 * creatures and have them fight against each other with their
 * special abilities.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class CreatureTest
{
    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args)
    {
        final Date dragonBirthDate;
        final Creature dragon;

        dragonBirthDate = new Date(1650, 3, 19);
        dragon          = new Dragon("Bob", dragonBirthDate, 90, 50);
    }
}
