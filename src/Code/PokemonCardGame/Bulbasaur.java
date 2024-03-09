package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * Rewrote the attack method so Bulbasaur cannot heal if its HP is greater than 50.
 */
public class Bulbasaur extends PokemonInheritance implements Attackable
{
    /**
     * Sets the HP of Bulbasaur to 70 using the setHp method within the constructor.
     */
    public Bulbasaur() {
        setHp(70);
    }

    /**
     * attackOne comes from the Attackable interface. LEECH SEED!
     * This particular method deals 20 damage to a target Pokemon and heals Bulbasaur if
     * its HP is lower than 50 (heals with the amount of damage dealt).
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackOne(PokemonInheritance unfortunatePokemon) {
        //Deals 20 damage to the target Pokemon.
        int currentHp = unfortunatePokemon.getHp();
        int resultingHp = currentHp - 20;

        //Heals itself with 20 HP if Bulbasaur's HP is less than 50 (can't heal if the HP
        //will be greater than 70 when finished).
        int thisCurrentHp = this.getHp();
        if(thisCurrentHp <= 50) {
            this.setHp(thisCurrentHp + 20);
        }
        unfortunatePokemon.setHp(resultingHp);
    }

    //Implemented attackTwo method that is not used since Bulbasaur in this case only has
    //the Leech Seed attack.

    /**
     * Attackable interface implementation that is not used since Bulbasaur only has one attack.
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackTwo(PokemonInheritance unfortunatePokemon) {
    }
}
