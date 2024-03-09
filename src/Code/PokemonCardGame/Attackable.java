package Code.PokemonCardGame;

//This is the interface used for the Pokemon cards that require attacks,
//namely Pikachu, Bulbasaur, Chimchar, and Fennekin. It makes it so each of the Pokemon have to
//implement both of these methods even if they do not have two attacks.
public interface Attackable
{
    //These two variable declarations and initializations assign each attack name. These can be
    //changed based on which attack the Pokemon can do.
    final String attackOneName = "";
    final String attackTwoName = "";

    //This is the first attack method that must be implemented. It takes a parameter of
    //type PokemonInheritance because the Pokemon object will be attacked using this method.
    /**
     * This is a method that must be implemented in all PokemonInheritance objects called attackOne.
     * @param target - PokemonInheritance object that will be the subject of attacks.
     */
    void attackOne(PokemonInheritance target);

    //This is the second attack method that also takes a parameter of type PokemonInheritence.
    //This method is not always used because not every Pokemon has two attacks.
    /**
     * Method that must be implemented called attackTwo.
     * @param target - PokemonInheritance object that will be the subject of attacks.
     */
    void attackTwo(PokemonInheritance target);
}