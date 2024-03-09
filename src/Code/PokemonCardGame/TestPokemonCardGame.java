package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * Runs the actual Pokemon game!
 */
public class TestPokemonCardGame {

    public static void main(String[] args) {
        //Creates an object of type PokemonCardGame which will be used to test or run the game.
        PokemonCardGame test = new PokemonCardGame();
        //Prints game instructions.
        System.out.println(test.printInstructions());
        //Declares and initializes two player objects that will be able to play the game together.
        Player player1 = new Player();
        Player player2 = new Player();

    }
}
