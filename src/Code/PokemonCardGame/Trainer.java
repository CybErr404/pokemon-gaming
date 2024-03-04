package PokemonCardGame;

import java.util.ArrayList;
import java.util.Random;
public class Trainer extends Card implements TrainerActions {
    private ArrayList <Card> hand;
    private ArrayList <Card> deck;
    private ArrayList <Card> bench;

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

    public void playable(PokemonCardGame gameState){
        return;
    };
}