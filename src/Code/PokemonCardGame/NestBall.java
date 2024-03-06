package Code.PokemonCardGame;

import java.util.ArrayList;
import java.util.Random;

public class NestBall extends Trainer {
    private ArrayList <Card> bench;
    @Override
    public void playable(PokemonCardGame gameState) {
        ArrayList <Card> deck = gameState.getDeck();

        //find all pokemon
        ArrayList<Card> tempPokemon = new ArrayList<>();
        int i = 0;
        while(i < deck.size()){
            if(deck.get(i) instanceof Pokemon){
                tempPokemon.add(deck.get(i)); //add this to found pokemon so far
                deck.remove(i);
            } else{
                i++;
            }
        }
        System.out.println("Pokemon found so far: " + tempPokemon);
        System.out.println("Count: " + tempPokemon.size());

        Random rng = new Random();
        int saveRandomNumber = rng.nextInt(tempPokemon.size());
        bench.add(tempPokemon.get(saveRandomNumber));
        tempPokemon.remove(saveRandomNumber);

        for(int j = 0; j < tempPokemon.size(); i++){
            deck.add(tempPokemon.get(i));
        }
    }
}
