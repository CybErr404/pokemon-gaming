package Code.PokemonCardGame;
//Imports Random and ArrayList classes for later use.
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mia Watts
 * This class extends Card and implements TrainerActions. It represents the Trainer cards used in
 * a game of Pokemon.
 */
public class Trainer extends Card implements TrainerActions {
    //Declares damage, hand, deck, and bench variables, the first being an integer value
    //and the last three being card ArrayLists.
    private int damage;
    private ArrayList <Card> hand;
    private ArrayList <Card> deck;
    private ArrayList <Card> bench;

    /**
     * Draws a random card from the deck and returns it.
     * @return the drawn card.
     */
    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size());
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    /**
     * Draws 7 cards from the deck and puts them into the player's hand.
     */
    public void drawHand() {
        for(int i = 0; i < 7; i++) {
            hand.add(drawCard());
        }
    }

    /**
     * Consists of the playable interface method that is used to run the Trainer cards.
     * @param gameState - PokemonCardGame object that is used to determine the current state
     *                  of the game for future use or changes.
     */
    public void playable(PokemonCardGame gameState){
        return;
    };
}