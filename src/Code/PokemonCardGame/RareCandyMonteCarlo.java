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
 * Thanks, Jake!
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

//    public String[][] pokemonRareCandiesSimulation() {
//        String[][] resultMatrix = new String[5][2];
//        resultMatrix[0][0] = "Number of Rare Candies in a Deck of 60";
//        resultMatrix[0][1] = "Chance (%) of Not Bricking";
//        int testCount = 1000000;
//        for (int i = 1; i <= 4; i++) {
//            int candyInPrizeCount = 0;
//            for (int j = 0; j < testCount; j++) {
//                PokemonCardGame testDeck = new PokemonCardGame();
//                testDeck.buildDeck(20, 40 - i, i);
//                openingHand(testDeck);
//                if(!isCandyBricked(testDeck)) {
//                    candyInPrizeCount++;
//                }
//            }
//            double rareCandiesProbability = ((double) candyInPrizeCount / testCount) * 100.0;
//            resultMatrix[i][0] = String.valueOf(i);
//            resultMatrix[i][1] = String.valueOf(rareCandiesProbability + "%");
//        }
//        return resultMatrix;
//    }

    public void run(double userAmountRun) {
        for(int i = 1; i <= 4; i++) {
            int candyCount = 0;
            for(int j = 0; j < userAmountRun; j++) {
                RareCandyMonteCarlo candyDeck = new RareCandyMonteCarlo();
                candyDeck.newDeckMultipleCandies(i);
                openingHand(candyDeck);
                if(!isCandyBricked(candyDeck)) {
                    candyCount++;
                }
            }
            System.out.println("Candy count: " + i + ", Number of prize piles with all candies: " + (candyCount) +
                    ", percentage of prize piles with all candies: " +
                    ((candyCount / userAmountRun) * 100) + "%");
            System.out.println("Percent chance of not getting a bricked deck: "
                    + (100 - ((candyCount / userAmountRun) * 100)) + "%" + "\n");
        }
    }

    public void openingHand(RareCandyMonteCarlo candyDeck) {
        candyDeck.drawHand();
        boolean openingHandsReady = false;
        while (!openingHandsReady) {
            if (!candyDeck.evaluateOpeningHand()) {
                candyDeck.restartOpeningHand();
                candyDeck.drawHand();
            } else {
                openingHandsReady = true;
            }
        }
        candyDeck.drawPrizePile();
    }

    public void restartOpeningHand() {
        deck.addAll(hand);
        hand.clear();
        Collections.shuffle(deck);
    }

    private boolean isCandyBricked(RareCandyMonteCarlo candyDeck) {
        for (int i = 0; i < candyDeck.prizePile.size(); i++) {
            if (candyDeck.prizePile.get(i) instanceof RareCandy) {
                return false;
            }
        } return true;
    }
}
