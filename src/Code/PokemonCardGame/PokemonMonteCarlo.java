package Code.PokemonCardGame;

import java.util.ArrayList;
import java.util.Random;

public class PokemonMonteCarlo {
    private ArrayList<Card> deck;
    private ArrayList <Card> hand;

    public PokemonMonteCarlo() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
    }

    public boolean evaluateOpeningHand() {
        //boolean havePokemon = false;
        for(int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if(currentCard instanceof Pokemon) { //instanceof is asking "is the card of type Pokemon?"
                return true;
            }
        }
        return false;
    }

    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card.
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public void drawHand() {
        for(int i = 0; i < 7; i++) { //We're counting to 7.
            hand.add(drawCard());
        }
    }

    public void newDeckMultiplePokemon(int pokemonCount) {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;

        for(int i = 1; i <= pokemonCount; i++) {
            deck.add(new Pokemon());
        }

        for(int i = pokemonCount; i <= newDeckSize; i++) {
            deck.add(new Energy());
        }
    }

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
