package Code.PokemonCardGame;

// Chimchar class added by Garret Chmielewski during the GitHub classmate editing assignment.
// This code was written by Garret!

/**
 * @author Garret Chmielewski
 */
public class Chimchar extends PokemonInheritance implements Attackable
{
    /**
     * Main constructor used to set Chimchar's HP to 50.
     */
    public Chimchar()
    {
        setHp(50);
    }

    /**
     * Attackable interface method that deals 10 damage to the unfortunate Pokemon parameter.
     * Represents Chimchar's SCRATCH! attack.
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackOne(PokemonInheritance unfortunatePokemon)
    {
        //Deals 10 damage to the target Pokemon (unfortunatePokemon).
        int currentHP = unfortunatePokemon.getHp();
        int newHP = currentHP-10;
        setHp(newHP);
    }

    /**
     * Unused attack method carried over from the Attackable interface since Chimchar only has
     * one attack in this case.
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackTwo(PokemonInheritance unfortunatePokemon)
    {

    }
}
