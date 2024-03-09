package Code.PokemonCardGame;

//Imports the ArrayList class for all Card items a player would have in a Pokemon game.
import java.util.ArrayList;

/**
 * @author Mia Watts
 */

public class Player {
    //Declares a deck, hand, prize, bench, and discard pile that a player has during a game.
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prize;
    private ArrayList<PokemonInheritance> bench;
    private ArrayList<Card> discard;

    /**
     * Player constructor that initializes each pile the player would have and adds cards to their
     * respective piles.
     */
    public Player() {
        //Initializes the deck, hand, prize, bench, and discard piles.
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        prize = new ArrayList<>();
        bench = new ArrayList<>();
        discard = new ArrayList<>();

        //Loop that adds Pokemon, Energy, and Trainer cards to the deck until the deck size
        //of 60 is reached.
        for (int i = 0; i < 60; i++) {
            deck.add(new Pokemon());
            deck.add(new Energy());
            deck.add(new Trainer());
            deck.add(new RareCandy());
        }

        //Loop that adds Pokemon, Energy, and Trainer cards to the player's hand
        //until the hand size of 7 is reached.
        for(int i = 0; i < 7; i++) {
            hand.add(new Energy());
            hand.add(new Pokemon());
            hand.add(new Trainer());
        }

        //Loop that adds Pokemon, Energy, Trainer, and Rare Candy cards to the
        //player's prize pile.
        for(int i = 0; i < 6; i++) {
            prize.add(new Pokemon());
            prize.add(new Trainer());
            prize.add(new Energy());
        }
    }
}
