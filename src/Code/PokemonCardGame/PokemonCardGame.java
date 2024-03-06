package Code.PokemonCardGame;//60, there's a catch, in order to take a turn you needed to have a basic pokemon card in your hand.

//Let's write a Monte Carlo simulation. That means, using raw, brute force, to try to figure out something interesting.

//What if your deck had exactly 1 pokemon? How many times would you expect to have to "mulligan," or pick again,
//in order to have your only pokemon in your hand?

//What if your deck had 2? Etc.

//Write a simulation that shows the expected mulligans at 1-60 pokemon in your deck.

//DO THIS 1000 TIMES AND FIND OUT WHAT THE ODDS ARE FOR DRAWING A POKEMON WHEN THERE'S 1 POKEMON

//The result should be 60 data points that you can plot into Excel to determine the ideal Pokemon count
//so that you can consistently draw a Pokemon in your first hand.
import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import java.util.Collections;

public class PokemonCardGame {
    //A deck of cards!
    private ArrayList <Card> deck; //This is the constructor's job. = new Card[];
    private ArrayList <Card> hand;
    private ArrayList <Card> prizePile;
    private ArrayList <Card> discardPile;
    private ArrayList <Card> pokemonBench;
    private ArrayList <Card> activePokemon;
    private ArrayList <Card> bench;

    public PokemonCardGame() {
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        bench = new ArrayList<Card>();

        //int deckSize = 60;
        //deck.add(new Pokemon());
        //for(int i = 1; i < deckSize; i++) {
        //deck.add(new Energy());
        //}
    }


    //new stuff added class 2/6
    public void buildDeck(){
        for(int i = 0; i < 10; i++){
            deck.add(new Pokemon());
        }

        for(int i = 0; i < 30; i++){
            deck.add(new Trainer());
        }

        for(int i = 0; i < 20; i++){
            deck.add(new Energy());
        }
    }

    public void playNestBall() {
        //ArrayList <Card> deck = gameState.getDeck();

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


    //nest ball - search your deck for a basic Pokemon and put it onto bench. Shuffle deck.
    public void runAgain() {
        buildDeck();
        playNestBall();
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }


    public void newDeckOnePokemon() {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;
        deck.add(new Pokemon());

        for(int i = 1; i <= newDeckSize; i++) {
            deck.add(new Energy());
        }
    }

    //M.W. - Method that accepts parameter of how many Pokemon user wants in deck.
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

    public void gameDeck() {

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

    public boolean evaulateOpeningHand() {
        //boolean havePokemon = false;
        for(int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if(currentCard instanceof Pokemon) { //instanceof is asking "is the card of type Pokemon?"
                return true;
            }
        }
        return false;
    }

    //Make engine for program!
    public void run(double userAmountRun) {
        //double trueCount = 0;
        int deckSize = 60;

        //IRRELEVANT CODE:
        //for(int i = 0; i <= userAmountRun; i++) {
        //newDeckOnePokemon();
        //drawHand();
        //if(evaulateOpeningHand() == true) {
        //trueCount =+ 1;
        //}
        //}

        for(int i = 1; i <= deckSize; i++) {
            double trueCount = 0;
            for(int j = 1; j <= userAmountRun; j++) {
                newDeckMultiplePokemon(i);
                drawHand();
                if(evaulateOpeningHand()) {
                    trueCount += 1;
                }
            }

            System.out.println("Number of hands with pokemon: "+ (trueCount) + ", percentage of hands with Pokemon: "
                    + (trueCount / userAmountRun) + "%");

        }

        //ORIGINAL CODE FROM BEFORE:
        //drawHand();
        //System.out.println("Has Pokemon: " + evaluateOpeningHand());
    }
}