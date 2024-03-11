package Code.PokemonCardGame;

//Imports the ArrayList class for all Card items a player would have in a Pokemon game.
import java.util.ArrayList;
import java.util.Collections;

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
    }

    /**
     * Builds the deck with Pokemon, Trainer cards, and Energy cards.
     *
     * @return
     */
    public ArrayList<Card> buildDeck(){
        deck.clear();
        PokemonInheritance[] pokemon = {new Pikachu(), new Bulbasaur(), new Fennekin(), new Chimchar()};
        Trainer[] trainer = {new NestBall(), new ProfessorsResearch(), new TrainerLillie(), new TrainerLeon()};

        //Adds Pokemon cards.
        Collections.addAll(deck, pokemon);

        //Adds Trainer cards.
        Collections.addAll(deck, trainer);

        //Adds 20 generic Energy cards.
        for(int i = 0; i < 20; i++){
            deck.add(new Energy());
        }

        //Adds 16 generic Trainer cards.
        for(int i = 0; i < 16; i++){
            deck.add(new Trainer());
        }

        //Adds 16 generic Pokemon cards.
        for(int i = 0; i < 16; i++){
            deck.add(new Pokemon());
        }
        return null;
    }

    public void buildHand() {
        PokemonInheritance[] pokemon = {new Pikachu(), new Bulbasaur(), new Fennekin(), new Chimchar()};
        for(int i = 0; i < hand.size(); i++) {
            hand.add(pokemon[i]);
        }
        hand.add(new TrainerLillie());
        hand.add(new TrainerLeon());
        hand.add(new ProfessorsResearch());
    }

    public ArrayList<Card> buildSimpleHand1() {
        hand.clear();
        hand.add(new Fennekin());
        hand.add(new TrainerLillie());
        hand.add(new TrainerLeon());
        hand.add(new ProfessorsResearch());
        hand.add(new Pokemon());
        hand.add(new Energy());
        hand.add(new Trainer());
        return null;
    }

    public ArrayList<Card> buildSimpleHand2() {
        hand.clear();
        hand.add(new Bulbasaur());
        hand.add(new TrainerLillie());
        hand.add(new TrainerLeon());
        hand.add(new ProfessorsResearch());
        hand.add(new Pokemon());
        hand.add(new Energy());
        hand.add(new Trainer());
        return null;
    }

    public ArrayList<Card> buildPrizePile() {
        for(int i = 0; i < 6; i++) {
            prizePile.add(new Pokemon());
            prizePile.add(new Energy());
            prizePile.add(new Trainer());
        }
        return null;
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
