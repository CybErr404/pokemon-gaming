package Code.PokemonCardGame;

public class Pikachu extends PokemonInheritance implements Attackable {
    private int hp;

    public Pikachu() {
        setHp(70);
    }


    public void attackOne(PokemonInheritance unfortunatePokemon){
        //deal 10 damage.
        int currentHp = unfortunatePokemon.getHp();
        int resultingHp = currentHp - 10;
        unfortunatePokemon.setHp(resultingHp);
    }

    public void attackTwo(PokemonInheritance unfortunatePokemon){
        //deal 60 damage.
    }
}