package PokemonCardGame;

// Chimchar class added by Garret Chmielewski during GitHub classmate editing assignment.
// This code was written by Garret!
public class Chimchar extends PokemonInheritance implements Attackable
{

    public Chimchar()
    {
        setHp(50);
    }

    public void attackOne(PokemonInheritance unfortunatePokemon)
    {
        int currentHP = unfortunatePokemon.getHp();
        int newHP = currentHP-10;
        setHp(newHP);
    }

    public void attackTwo(PokemonInheritance unfortunatePokemon)
    {

    }
}
