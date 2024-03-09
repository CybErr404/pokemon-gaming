package Code.PokemonCardGame;

//Imports the ArrayList for drawing cards until a condition is met.
import java.util.ArrayList;

/**
 * @author Mia Watts
 * This class implements Lillie, who, when her trainer card is played, allows the player
 * to continue to draw cards until their hand reaches 8 cards if it's the first turn and otherwise
 * draw cards until their hand reaches 6 cards.
 */
public class TrainerLillie extends Trainer {
    //Declares hand and turnCount.
    private ArrayList<Card> hand;
    private int turnCount;

    /**
     * Method that determines the turn count, and if it's the first turn, the player can draw cards until
     * they have 8 cards in their hand. If it's not the first turn, the player can draw cards until they have
     * 6 cards in their hand.
     * The method makes sure the player's hand has less than the card amount they are supposed to draw.
     */
    public void Lillie() {
        if(hand.size() < 6) {
            int size = hand.size();
            for(int i = size; i <= 6; i++) {
                hand.add(drawCard());
            }
        } else if (turnCount == 1) {
            if(hand.size() < 8) {
                int size = hand.size();
                for(int i = size; i <= 8; i++) {
                    hand.add(drawCard());
                }
            }
        }
    }

    /**
     * Playable method that comes from the TrainerActions interface.
     * @param gameState - PokemonCardGame object that is used to determine the current state
     *                  of the game for future use or changes.
     */
    public void playable(PokemonCardGame gameState) {

    }
}
