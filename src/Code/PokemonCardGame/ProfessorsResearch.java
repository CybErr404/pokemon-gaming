package Code.PokemonCardGame;

//Imports the ArrayList class for the hand that is put away and redrawn.
import java.util.ArrayList;

/**
 * @author Mia Watts
 */
//Implements the Professor's Research trainer card in which the player's hand must be put back
//and redrawn if played.
public class ProfessorsResearch extends Trainer {
    //Declares the hand that will be redrawn.
    private ArrayList<Card> hand;

    //Initializes the hand that will be redrawn.
    public ProfessorsResearch() {
        hand = new ArrayList<>();
    }

    /**
     * The playable method takes the current state of the hand and redraws it, as per
     * the instructions associated with the Professor's Research card.
     * @param gameState - PokemonCardGame object that will be cleared and redrawn.
     */
    public void playable(PokemonCardGame gameState) {
        gameState.getHand().clear();
        drawHand();
    }
}
