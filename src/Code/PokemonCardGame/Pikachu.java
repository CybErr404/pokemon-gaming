package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * Represents Pikachu! Extends PokemonInheritance and implements the Attackable interface.
 */
public class Pikachu extends PokemonInheritance implements Attackable {

    /**
     * Constructor that sets Pikachu's HP to 70.
     */
    public Pikachu() {
        setHp(70);
    }

    /**
     * Deals 10 damage to the target Pokemon using the attackOne method from the Attackable interface.
     * Represents Pikachu's QUICK ATTACK! attack.
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackOne(PokemonInheritance unfortunatePokemon){
        //Deals 10 damage.
        int currentHp = unfortunatePokemon.getHp();
        int resultingHp = currentHp - 10;
        unfortunatePokemon.setHp(resultingHp);
    }

    /**
     * Deals 60 damage to the target Pokemon using the attackTwo method from the Attackable interface.
     * Represents Pikachu's ELECTRO BALL! attack.
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackTwo(PokemonInheritance unfortunatePokemon){
        //Deals 60 damage.
        int currentHp = unfortunatePokemon.getHp();
        int resultingHp = currentHp - 60;
        unfortunatePokemon.setHp(resultingHp);
    }
}