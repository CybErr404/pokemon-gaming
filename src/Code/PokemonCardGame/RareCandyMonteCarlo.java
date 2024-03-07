package Code.PokemonCardGame;

import java.util.ArrayList;
import java.util.Random;

public class RareCandyMonteCarlo {
    private ArrayList<Card> deck;
    private ArrayList <Card> hand;
    private ArrayList <Card> prizePile;

    public RareCandyMonteCarlo() {
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        prizePile = new ArrayList<Card>();
    }

    //add rare candy to prize pile as well.
    //do you have a candy in your main hand and your prize pile?

    //conditional probability can be used to determine the amount of rare candies in
    //deck and prize pile.
    public void newDeckMultipleCandies(int candyCount) {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;

        for(int i = 1; i <= candyCount; i++) {
            deck.add(new RareCandy());
        }
        for(int i = 1; i <= 15; i++) {
            deck.add(new Energy());
        }
        for(int i = 1; i <= 15; i++) {
            deck.add(new Pokemon());
        }
        newDeckSize = newDeckSize - candyCount - 30;
        for(int i = 1; i <= newDeckSize; i++) {
            deck.add(new Trainer());
        }
    }

    public boolean evaulateOpeningHand() {
        for(int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if(currentCard instanceof Pokemon) { //instanceof is asking "is the card of type Pokemon?"
                return true;
            }
        }
        return false;
    }

    public boolean evaluatePrizePile() {
        for(int i = 0; i < prizePile.size(); i++) {
            Card currentCard = prizePile.get(i);
            if(currentCard instanceof RareCandy) { //instanceof is asking "is the card of type rareCandy?"
                return true;
            }
        }
        return false;
    }

    public void drawHand() {
        for(int i = 0; i < 7; i++) { //We're counting to 7.
            hand.add(drawCard());
        }
    }

    public void drawPrizePile() {
        for(int i = 0; i < 6; i++) {
            prizePile.add(drawCard());
        }
    }

    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card.
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public void run(double userAmountRun) {
        for(int i = 1; i <= 4; i++) {
            int candyCount = 0;
            for(int j = 1; j <= userAmountRun; j++) {
                newDeckMultipleCandies(i);
                drawHand();
                drawPrizePile();
                if(evaulateOpeningHand()) {
                    continue;
                } //else drawHand();
                if(evaluatePrizePile()) {
                    candyCount = candyCount + 1;
                }
            }

            System.out.println("Number of prize piles with candies: " + (candyCount) +
                    ", percentage of prize piles with all candies: " +
                    (candyCount / userAmountRun) + "%");
        }
    }
}
