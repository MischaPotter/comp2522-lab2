package ca.bcit.comp2522.fantasycreature;

/**
 * Instantiates new creatures and makes them fight against
 * each other with their special abilities.
 *
 * @author Mischa Potter Set D
 * @author Abdullah Munawar Set D
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
        final Date elfBirthDate;
        final Date orcBirthDate;
        final Creature dragon;
        final Creature elf;
        final Creature orc;

        dragonBirthDate = new Date(1650, 3, 19);
        dragon          = new Dragon("Bob", dragonBirthDate, 90, 50);

        orcBirthDate = new Date(1567, 12, 26);
        orc          = new Orc("Grok", orcBirthDate, 75, 15);

        elfBirthDate = new Date(1789, 7, 1);
        elf          = new Elf("Gandalf", elfBirthDate, 65, 40);

        // getDetails() for each
        dragon.getDetails();
        orc.getDetails();
        elf.getDetails();

        // instanceof and .getClass()
        Creature creatureArr[] = {dragon, orc, elf};
        for (Creature c : creatureArr)
        {
            System.out.println("This is a " + c.getClass());
            if (c instanceof Creature)
            {
                System.out.println(c.getClass() + " is a Creature.");
            }
            else
            {
                System.out.println(c.getClass() + " is not a Creature.");
            }

            if (c instanceof Dragon)
            {
                System.out.println(c.getClass() + " is a Dragon.");
            }
            else
            {
                System.out.println(c.getClass() + " is not a Dragon.");
            }

            if (c instanceof Elf)
            {
                System.out.println(c.getClass() + " is an Elf.");
            }
            else
            {
                System.out.println(c.getClass() + " is not an Elf.");
            }

            if (c instanceof Orc)
            {
                System.out.println(c.getClass() + " is an Orc.");
            }
            else
            {
                System.out.println(c.getClass() + " is not an Orc.");
            }
        }

        // Creatures fighting each other
        try
        {
            orc.takeDamage(((Dragon) dragon).breatheFire());
            System.out.println("Dragon health: " + dragon.getHealth());
        }
        catch (LowFirePowerException e)
        {
            System.out.println(e.getMessage());
        }

        elf.takeDamage(((Orc) orc).berserk());
        System.out.println("Orc health: " + orc.getHealth());

        try
        {
            dragon.takeDamage(((Elf) elf).castSpell());
            System.out.println("Elf health: " + elf.getHealth());
        }
        catch (LowManaException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
