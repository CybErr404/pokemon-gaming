package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * I couldn't forget my favorite Pokemon! Fun fact: This class is a representation of Fennekin,
 * who was my first ever starter Pokemon when I started playing my first Pokemon game, Pokemon X.
 */
public class Fennekin extends PokemonInheritance implements Attackable {

    /**
     * Sets Fennekin's HP to 70.
     */
    public Fennekin()
    {
        setHp(70);
    }

    /**
     * Attackable interface method that deals 10 damage to the target Pokemon.
     * Represents Fennekin's LIVE COAL! attack. Ouch!
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackOne(PokemonInheritance unfortunatePokemon)
    {
        //Deals 10 damage to the unfortunate Pokemon being attacked.
        int currentHP = unfortunatePokemon.getHp();
        int newHP = currentHP - 10;
        unfortunatePokemon.setHp(newHP);
    }

    /**
     * Second Attackable interface method that deals 20 damage to the target Pokemon.
     * Represents Fennekin's REAR KICK! attack.
     * @param unfortunatePokemon - PokemonInheritance object that will be the subject of attacks.
     */
    public void attackTwo(PokemonInheritance unfortunatePokemon)
    {
        //Deals 20 damage to the unfortunate Pokemon being attacked.
        int currentHP = unfortunatePokemon.getHp();
        int newHP = currentHP - 20;
        unfortunatePokemon.setHp(newHP);
    }
}
