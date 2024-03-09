package Code.PokemonCardGame;

//Imports the Random class and the ArrayList class for later use.
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mia Watts
 * Creates methods used for the first Monte Carlo assignment in which we were determining the
 * probability of drawing a Pokemon in our hand depending on how many Pokemon were added to the deck.
 */
public class PokemonMonteCarlo {
    //Declares the deck and hand card ArrayLists.
    private ArrayList<Card> deck;
    private ArrayList <Card> hand;

    //Initializes the deck and hand card ArrayLists.
    public PokemonMonteCarlo() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
    }

    /**
     * Evaluation method that determines whether a specific instance in the hand is of type Pokemon.
     * @return True if the card is of type Pokemon and false otherwise.
     */
    public boolean evaluateOpeningHand() {
        //Iterates through the hand and determines whether the card is of type Pokemon.
        for(int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if(currentCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    /**
     * Draws a single card from the deck using the Random class.
     * @return the card that was randomly drawn from the deck.
     */
    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card.
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    /**
     * Draws a hand of 7 cards from the deck.
     */
    public void drawHand() {
        for(int i = 0; i < 7; i++) {
            hand.add(drawCard());
        }
    }

    /**
     * Actual usage of the newDeckMultiplePokemon method is found here.
     * The method adds cards to a deck based on how many Pokemon should be added from the parameter number.
     * @param pokemonCount - The amount of Pokemon that will be added to the deck.
     */
    public void newDeckMultiplePokemon(int pokemonCount) {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;

        //Adds as many Pokemon as the parameter requires.
        for(int i = 1; i <= pokemonCount; i++) {
            deck.add(new Pokemon());
        }

        //Fills the rest of the deck with Energy cards.
        for(int i = pokemonCount; i <= newDeckSize; i++) {
            deck.add(new Energy());
        }
    }

    /**
     * This method represents the Monte Carlo simulation.
     * A parameter determines how many times the run method is executed with the method calculating
     * the total amount of Pokemon that were drawn successfully from the deck and into the hand. Returns
     * a print statement that represents the number of hands with Pokemon along with the percentage
     * calculated as to how many hands had Pokemon compared to the total hands drawn.
     * @param userAmountRun - How many times we'd like to run the simulation.
     */
    public void run(double userAmountRun) {
        int deckSize = 60;
        for(int i = 1; i <= deckSize; i++) {
            double trueCount = 0;
            for(int j = 1; j <= userAmountRun; j++) {
                newDeckMultiplePokemon(i);
                drawHand();
                if(evaluateOpeningHand()) {
                    trueCount += 1;
                }
            }
            System.out.println("Number of hands with pokemon: "+ (trueCount) + ", percentage of hands with Pokemon: "
                    + (trueCount / userAmountRun) + "%");
        }
    }
}
