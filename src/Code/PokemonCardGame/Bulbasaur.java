package PokemonCardGame;

public class Bulbasaur extends PokemonInheritance implements Attackable
{
    public Bulbasaur() {
        setHp(70);
    }

    public void attackOne(PokemonInheritance unfortunatePokemon) {
        //Deals 20 damage and heals itself.
        int currentHp = unfortunatePokemon.getHp();
        int resultingHp = currentHp - 20;

        //We're missing a line of code to make sure that this Pokemon can heal (has missing life to heal).
        //The HP cannot go past 70.
        int thisCurrentHp = this.getHp();
        this.setHp(thisCurrentHp + 20);

        unfortunatePokemon.setHp(resultingHp);
    }

    public void attackTwo(PokemonInheritance unfortunatePokemon) {
        //Does nothing, just here
    }
}

