package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * Runs the actual Pokemon game! This class creates Player objects and a test PokemonCardGame
 * object, running the "play game" method to start the card game.
 */
public class TestPokemonCardGame {

    public static void main(String[] args) {
        //Creates an object of type PokemonCardGame which will be used to test or run the game.
        PokemonCardGame test = new PokemonCardGame();
        //Plays the 2-player game using the "playGame" method.
        test.playGame();
    }
}
