package Code.PokemonCardGame;

//Imports the random class and the ArrayList class for use in the NestBall class.
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Professor Hoy
 * @author edits - Mia Watts
 * Implements the NestBall trainer card.
 */

public class NestBall extends Trainer {
    //Declares the bench Card ArrayList.
    private ArrayList <Card> bench;

    /**
     * Initializes the bench Card ArrayList.
     * @param bench - ArrayList parameter that is updated within the constructor.
     */
    public NestBall(ArrayList<Card> bench) {
        this.bench = bench;
    }

    /**
     * Method that performs functions NestBall trainer cards would perform in the actual game.
     * Locates all basic Pokemon cards in the deck, adds a random one to the bench, then reshuffles cards.
     * @param gameState - Represents the current deck state based on where the game is.
     */
    @Override
    public void playable(PokemonCardGame gameState) {
        ArrayList <Card> deck = gameState.getDeck();

        //Finds all Pokemon in a deck and adds them to a temporary Pokemon deck.
        ArrayList<Card> tempPokemon = new ArrayList<>();
        int i = 0;
        while(i < deck.size()){
            if(deck.get(i) instanceof Pokemon){
                tempPokemon.add(deck.get(i));
                deck.remove(i);
            } else{
                i++;
            }
        }
        //Prints out how many Pokemon were found in the deck.
        System.out.println("Pokemon found so far: " + tempPokemon);
        System.out.println("Count: " + tempPokemon.size());

        //Selects a random basic Pokemon from the deck and adds it to the bench.
        Random rng = new Random();
        int saveRandomNumber = rng.nextInt(tempPokemon.size());
        bench.add(tempPokemon.get(saveRandomNumber));
        tempPokemon.remove(saveRandomNumber);

        //Adds Pokemon back to the deck.
        for(int j = 0; j < tempPokemon.size(); i++){
            deck.add(tempPokemon.get(i));
        }
    }
}
