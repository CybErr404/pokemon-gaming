package Code.PokemonCardGame;

//Imports the ArrayList class for all Card items a player would have in a Pokemon game.
import java.util.ArrayList;

/**
 * @author Mia Watts
 */

public class Player {
    //Declares a deck, hand, prize, bench, active Pokemon, and discard pile that a player has during a game.
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    ArrayList<Card> prizePile;
    private ArrayList<Card> bench;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> activePokemon;

    /**
     * Player constructor that initializes each pile the player would have and adds cards to their
     * respective piles.
     */
    public Player() {
        //Initializes the deck, hand, prize, bench, and discard piles.
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        prizePile = new ArrayList<>();
        bench = new ArrayList<>();
        discardPile = new ArrayList<>();

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
            prizePile.add(new Pokemon());
            prizePile.add(new Trainer());
            prizePile.add(new Energy());
        }
    }

    /**
     * Setter method for the deck.
     * @param newDeck - New deck that the old deck will be initialized to.
     */
    public void setDeck(ArrayList<Card> newDeck) {
        for(int i = 0; i < deck.size(); i++) {
            deck.remove(i);
        }
        deck.addAll(newDeck);
    }

    /**
     * Getter method for returning the player's deck.
     * @return The player's deck.
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Setter method for the prize pile.
     * @param newPrizePile - New prize pile that the old prize pile will be initialized to.
     */
    public void setPrizePile(ArrayList<Card> newPrizePile) {
        for(int i = 0; i < prizePile.size(); i++) {
            prizePile.remove(i);
        }
        prizePile.addAll(newPrizePile);
    }

    /**
     * Getter method for returning the player's prize pile.
     * @return The player's prize pile.
     */
    public ArrayList<Card> getPrizePile() {
        return prizePile;
    }

    /**
     * Setter method for the discard pile.
     * @param newDiscard - New discard pile that the old discard pile will be initialized to.
     */
    public void setDiscardPile(ArrayList<Card> newDiscard) {
        for(int i = 0; i < discardPile.size(); i++) {
            discardPile.remove(i);
        }
        discardPile.addAll(newDiscard);
    }

    /**
     * Getter method for the discard pile.
     * @return The player's discard pile.
     */
    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    /**
     * Setter method for the hand.
     * @param newHand - New hand that the old hand will be initialized to.
     */
    public void setHand(ArrayList<Card> newHand) {
        for(int i = 0; i < hand.size(); i++) {
            hand.remove(i);
        }
        hand.addAll(newHand);
    }

    /**
     * Setter method for the hand.
     * @return The player's hand.
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Setter method for the bench.
     * @param newBench - New bench that the old bench will be initialized to.
     */
    public void setBench(ArrayList<Card> newBench) {
        for(int i = 0; i < bench.size(); i++) {
            bench.remove(i);
        }
        bench.addAll(newBench);
    }

    /**
     * Getter method for the bench.
     * @return The player's bench.
     */
    public ArrayList<Card> getBench() {
        return bench;
    }

    /**
     * Setter method for the active Pokemon.
     * @param newActive - New active Pokemon that the old active Pokemon will be changed to.
     */
    public void setActive(ArrayList<Card> newActive) {
        for(int i = 0; i < activePokemon.size(); i++) {
            activePokemon.remove(i);
        }
        activePokemon.addAll(newActive);
    }

    /**
     * Getter method for the active Pokemon.
     * @return The player's current active Pokemon.
     */
    public ArrayList<Card> getActive() {
        return activePokemon;
    }
}
