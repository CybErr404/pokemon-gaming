package Code.PokemonCardGame;

//Import statements for the ArrayList, Arrays, and Random classes.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Mia Watts and Jake Cubernot
 * DISCLAIMER:
 * Jake Cubernot helped with figuring out how to properly run the Rare Candy Monte Carlo.
 * Code that was created with his assistance will have his name above it to show his contributions.
 * Thanks, Jake! :)
 */
public class RareCandyMonteCarlo {
    //Declares the deck, hand, and prizePile card lists.
    private ArrayList<Card> deck;
    private ArrayList <Card> hand;
    private ArrayList <Card> prizePile;

    /**
     * Initializes the deck, hand, and prizePile card lists. All are of type Card.
     */
    public RareCandyMonteCarlo() {
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        prizePile = new ArrayList<Card>();
    }

    /**
     * This method is similar to the newDeckMultiplePokemon method.
     * The difference between this one and that one is that the items added are Rare Candies instead of
     * Pokemon, adding a certain amount of RareCandy to the deck based on how many are specified.
     * @param candyCount - Value that represents how many candies will be added to the deck.
     */
    public void newDeckMultipleCandies(int candyCount) {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;

        //Adds as many Rare Candies as is specified in the parameter value.
        for(int i = 1; i <= candyCount; i++) {
            deck.add(new RareCandy());
        }

        //Adds 15 Energy cards to the deck.
        for(int i = 1; i <= 15; i++) {
            deck.add(new Energy());
        }

        //Adds 15 Pokemon cards to the deck.
        for(int i = 1; i <= 15; i++) {
            deck.add(new Pokemon());
        }

        //Creates a newDeckSize variable that contains the remaining deck space.
        newDeckSize = newDeckSize - candyCount - 30;
        //Fills the remaining deck space with Trainer cards.
        for(int i = 1; i <= newDeckSize; i++) {
            deck.add(new Trainer());
        }
    }

    /**
     * Evaluates the hand and determines if the card drawn is of type Rare Candy.
     * @return True if the card is a Rare Candy, and false otherwise.
     */
    public boolean evaluateOpeningHand() {
        for(int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if(currentCard instanceof RareCandy) {
                return true;
            }
        }
        return false;
    }

    /**
     * Evaluates the prize pile and determines if the card drawn is of type Rare Candy.
     * @return True if the card is a Rare Candy, and false otherwise.
     */
    public boolean evaluatePrizePile() {
        for(int i = 0; i < prizePile.size(); i++) {
            Card currentCard = prizePile.get(i);
            if(currentCard instanceof RareCandy) {
                return true;
            }
        }
        return false;
    }

    /**
     * Draws 7 cards out of the deck and adds them to the current hand.
     */
    public void drawHand() {
        for(int i = 0; i < 7; i++) {
            hand.add(drawCard());
        }
    }

    /**
     * Draws 6 cards out of the deck and adds them to the prize pile.
     */
    public void drawPrizePile() {
        for(int i = 0; i < 6; i++) {
            prizePile.add(drawCard());
        }
    }

    /**
     * Draws a random card from the deck.
     * @return The card that was randomly drawn from the deck.
     */
    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card.
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    /**
     * This method runs the actual simulation and prints the results one-by-one.
     * @param userAmountRun - Specifies a double value that represents the amount of times the
     *                      program will be repeated to produce results.
     */
    //This run method was mostly written by me, Mia Watts, but the openingHand and isCandyBricked methods
    //were methods that Jake Cubernot helped with during the implementation process of this simulation.
    public void run(double userAmountRun) {
        //Loops through i values of 1, 2, 3, and 4, each representing the amount of candy added
        //to the deck.
        for(int i = 1; i <= 4; i++) {
            int candyCount = 0;
            //Repeats the simulation as many times as the parameter says to.
            for(int j = 0; j < userAmountRun; j++) {
                RareCandyMonteCarlo candyDeck = new RareCandyMonteCarlo();
                candyDeck.newDeckMultipleCandies(i);
                openingHand(candyDeck);
                if(!isCandyBricked(candyDeck)) {
                    candyCount++;
                }
            }
            //Prints the results of the simulation.
            System.out.println("Candy count: " + i + ", Number of prize piles with all candies: " + (candyCount) +
                    ", percentage of prize piles with all candies: " +
                    ((candyCount / userAmountRun) * 100) + "%");
            System.out.println("Percent chance of not getting a bricked deck: "
                    + (100 - ((candyCount / userAmountRun) * 100)) + "%" + "\n");
        }
    }

    /**
     * JAKE CUBERNOT HELPED WITH THIS METHOD!
     *
     * This method redraws hands until there are Pokemon in them because otherwise the hand isn't proper.
     * @param candyDeck - Represents the RareCandyMonteCarlo object that, when passed within
     *                  the run method, is the candy deck, hence the name.
     */
    public void openingHand(RareCandyMonteCarlo candyDeck) {
        candyDeck.drawHand();
        boolean isReady = false;
        while (!isReady) {
            if (!candyDeck.evaluateOpeningHand()) {
                candyDeck.restartOpeningHand();
                candyDeck.drawHand();
            } else {
                isReady = true;
            }
        }
        candyDeck.drawPrizePile();
    }

    /**
     * JAKE CUBERNOT IS THE AUTHOR OF THIS METHOD AND HELPED ME CREATE IT!
     *
     * This method restarts the opening hand by adding all contents of the hand into the deck, clearing
     * the hand, and shuffling the deck.
     */
    public void restartOpeningHand() {
        deck.addAll(hand);
        hand.clear();
        Collections.shuffle(deck);
    }

    /**
     * JAKE CUBERNOT HELPED WITH THIS METHOD!
     *
     * This method determines whether the game is bricked based on whether there are candies
     * in the prize pile or not.
     * @param candyDeck - represents the RareCandyMonteCarlo object. In the run method, the
     *                  object is the deck with the candies, so I called it candyDeck.
     * @return True if the prize pile didn't brick the game because it doesn't contain the rare candies
     * and false if the prize pile does make the game bricked because it contains the rare candies.
     */
    private boolean isCandyBricked(RareCandyMonteCarlo candyDeck) {
        for (int i = 0; i < candyDeck.prizePile.size(); i++) {
            if (candyDeck.prizePile.get(i) instanceof RareCandy) {
                return false;
            }
        } return true;
    }
}
