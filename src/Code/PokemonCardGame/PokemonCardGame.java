package Code.PokemonCardGame;

//Imports the ArrayList and Random classes for card use.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mia Watts
 * This class houses methods pertaining to the actual Pokemon game with 2 players along with
 * all methods associated with deck setup, building the deck, and printing instructions.
 */
public class PokemonCardGame {

    //Declares the deck, hand, prizePile, discardPile, activePokemon, and bench hands/cards.
    //Each one is an ArrayList that can be added to eventually.
    private ArrayList <Card> deck;
    private ArrayList <Card> hand;
    private ArrayList <Card> prizePile;
    private ArrayList <Card> discardPile;
    private ArrayList <Card> activePokemon1;
    private ArrayList <Card> activePokemon2;
    private ArrayList <Card> bench;

    //Adds player objects to the game.
    Player player1 = new Player();
    Player player2 = new Player();

    private int damage;

    /**
     * This constructor initializes each of the private variables as new ArrayLists of type Card.
     */
    public PokemonCardGame() {
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        bench = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        prizePile = new ArrayList<Card>();
        activePokemon1 = new ArrayList<Card>();
        activePokemon2 = new ArrayList<Card>();
    }

    /**
     * Returns the current deck.
     * @return ArrayList deck object.
     */
    public ArrayList<Card> getDeck(){
        return deck;
    }

    /**
     * Returns the current hand.
     * @return ArrayList hand object.
     */
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * Returns the player's prize pile.
     * @return ArrayList prize pile object.
     */
    public ArrayList<Card> getPrizePile() { return prizePile; }

    /**
     * Returns the player's discard pile.
     * @return ArrayList discard pile object.
     */
    public ArrayList<Card> getDiscardPile() { return discardPile; }

    /**
     * Returns the player's current bench.
     * @return ArrayList bench object.
     */
    public ArrayList<Card> getBench() { return bench; }

    /**
     * Returns the first player's active Pokemon.
     * @return ArrayList active Pokemon object.
     */
    public ArrayList<Card> getActivePokemon1() { return activePokemon1; }

    /**
     * Returns the second player's active Pokemon.
     * @return ArrayList active Pokemon object.
     */
    public ArrayList<Card> getActivePokemon2() { return activePokemon2; }

    /**
     * Builds the deck with Pokemon, Trainer cards, and Energy cards.
     */
    public void buildDeck(){
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
    }

    /**
     * Plays the NestBall card by finding all Pokemon, putting one on the bench, and reshuffling them.
     */
    public void playNestBall() {
        //Declares and initializes a temporary deck which will be eventually filled with Pokemon.
        ArrayList<Card> tempPokemon = new ArrayList<>();

        //Collects all Pokemon from the deck and puts them in the temporary deck.
        int i = 0;
        while(i < deck.size()){
            if(deck.get(i) instanceof Pokemon){
                tempPokemon.add(deck.get(i));
                deck.remove(i);
            } else{
                i++;
            }
        }

        //Prints out the current count of Pokemon found in the deck.
        System.out.println("Pokemon found so far: " + tempPokemon);
        System.out.println("Count: " + tempPokemon.size());

        //Randomly selects a Pokemon to be placed on the bench.
        Random rng = new Random();
        int saveRandomNumber = rng.nextInt(tempPokemon.size());
        bench.add(tempPokemon.get(saveRandomNumber));
        tempPokemon.remove(saveRandomNumber);

        //Reshuffles the Pokemon back into the deck.
        for(int j = 0; j < tempPokemon.size(); i++){
            deck.add(tempPokemon.get(i));
        }
    }

    /**
     * Builds a deck and then plays a NestBall trainer card.
     */
    public void nestPlay() {
        buildDeck();
        playNestBall();
    }

    /**
     * Setter method that sets the damage done by a Pokemon.
     * This value is used in the Trainer classes where the damage done by a Pokemon can be increased.
     * @param userInputDamage - Integer value that sets the damage done by the Pokemon
     *                        to whatever the value is.
     */
    public void setDamage(int userInputDamage) {
        damage = userInputDamage;
    }

    /**
     * Getter method that returns the damage.
     * @return Returns the damage done by the Pokemon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Takes a deck ArrayList parameter and converts instances of different Pokemon, Trainers,
     * or Energies into readable String language.
     * @param deck - ArrayList deck object that is used to convert the objects into
     *             String values so the items in the deck can be understood.
     * @return The result array which contains the String values of the deck.
     */
    public ArrayList<String> printDeck(ArrayList<Card> deck) {
        ArrayList<String> resultArray = new ArrayList<>();
        //Iterates through the deck and checks which instance it belongs to, then adds
        //a String identifier to the result array.
        for (Card currentCard : deck) {
            if (currentCard instanceof Pokemon) {
                resultArray.add("Pokemon");
            } else if (currentCard instanceof Trainer) {
                resultArray.add("Trainer");
            } else if (currentCard instanceof RareCandy) {
                resultArray.add("Rare Candy");
            } else {
                resultArray.add("Energy");
            }
        }
        return resultArray;
    }

    /**
     * Takes a hand ArrayList parameter and converts instances of Pokemon, Trainers, or Energies
     * into readable String language.
     * @param hand - ArrayList hand object that is used to convert the objects into
     *             String values so the items in the hand can be understood.
     * @return The result array which contains the String values of the deck.
     */
    public ArrayList<String> printHand(ArrayList<Card> hand) {
        ArrayList<String> resultArray = new ArrayList<>();
        //Iterates through the hand to determine what types of cards are there.
        for (Card currentCard : hand) {
            if (currentCard instanceof Pokemon) {
                resultArray.add("Pokemon");
            } else if (currentCard instanceof Trainer) {
                resultArray.add("Trainer");
            } else if (currentCard instanceof RareCandy) {
                resultArray.add("Rare Candy");
            } else {
                resultArray.add("Energy");
            }
        }
        return resultArray;
    }

    /**
     * String method called printInstructions that prints the instructions for the game.
     * @return A String that contains the instructions for the game.
     */
    public String printInstructions() {
        return "Select an attack to use. If you faint your opponent's Pokemon or run out of prize " +
                "cards, you win!";
    }

    /**
     * Originally used for the Monte Carlo simulation. The method clears the deck and hand, then
     * adds one Pokemon to the deck, leaving the rest of the space for Energy cards. (59 Energy,
     * 1 Pokemon).
     */
    public void newDeckOnePokemon() {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;

        //Adds 1 Pokemon.
        deck.add(new Pokemon());

        //Adds 59 Energy cards.
        for(int i = 1; i <= newDeckSize; i++) {
            deck.add(new Energy());
        }
    }

    /**
     * Takes a parameter and adds that many Pokemon to the deck based on whatever the parameter number is.
     * @param pokemonCount - Integer value that represents how many Pokemon should be added
     *                     to the deck.
     */
    public void newDeckMultiplePokemon(int pokemonCount) {
        deck.clear();
        hand.clear();
        int newDeckSize = 60;

        //Adds as many Pokemon as is specified in the parameter pokemonCount.
        for(int i = 1; i <= pokemonCount; i++) {
            deck.add(new Pokemon());
        }

        //Adds Energies into the remaining deck space.
        for(int i = pokemonCount; i <= newDeckSize; i++) {
            deck.add(new Energy());
        }
    }

    /**
     * This method uses the Random class to randomly draw and select a card from the deck,
     * returning the chosen card.
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
     * Method that checks whether a current card is of type Pokemon or any Pokemon types implemented
     * in the card game.
     * @return true if the current card in the deck is of type Pokemon and false otherwise.
     */
    public boolean evaluateOpeningHand() {
        for (Card currentCard : hand) {
            if (currentCard instanceof Pokemon || currentCard instanceof Fennekin ||
                    currentCard instanceof Bulbasaur || currentCard instanceof Chimchar || currentCard
                    instanceof Pikachu) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks whether a current card is of type Pokemon or any Pokemon types implemented
     * in the card game.
     * @return true if the current card in the bench is of type Pokemon and false otherwise.
     */
    public boolean evaluateBench() {
        for (Card currentCard : bench) {
            if (currentCard instanceof Pokemon || currentCard instanceof Fennekin ||
                    currentCard instanceof Bulbasaur || currentCard instanceof Chimchar || currentCard
                    instanceof Pikachu) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks whether a current card is of type Pokemon or any Pokemon types implemented
     * in the card game.
     * @return true if the current card in the active position is of type Pokemon and false otherwise.
     */
    public boolean evaluateActive() {
        for (Card currentCard : activePokemon1) {
            if (currentCard instanceof Pokemon || currentCard instanceof Fennekin ||
                    currentCard instanceof Bulbasaur || currentCard instanceof Chimchar || currentCard
                    instanceof Pikachu) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks whether a current card is of type Pokemon or any Pokemon types implemented
     * in the card game.
     * @return true if the current card in the active position is of type Pokemon and false otherwise.
     */
    public boolean evaluateActive2() {
        for (Card currentCard : activePokemon2) {
            if (currentCard instanceof Pokemon || currentCard instanceof Fennekin ||
                    currentCard instanceof Bulbasaur || currentCard instanceof Chimchar || currentCard
                    instanceof Pikachu) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the current player is the winner based on whether their Pokemon has fainted or not.
     * @return true if the player has won and has fainted their opponent's Pokemon and false otherwise.
     */
    public boolean checkIfWinner() {
        return chimchar.getHp() <= 0 || fennekin.getHp() <= 0;
    }

    /**
     * Plays the 2-player Pokemon Card Game.
     */
    public void playGame() {
        System.out.println(printInstructions());
        boolean keepPlaying = true;
        while(keepPlaying) {
            player1Turn();
            if(checkIfWinner()) {
                keepPlaying = false;
                break;
            }
            player2Turn();
            if(checkIfWinner()) {
                keepPlaying = false;
            }
        }
    }

    //Declares and initializes the Pokemon used for the simple game methods.
    Fennekin fennekin = new Fennekin();
    Chimchar chimchar = new Chimchar();

    /**
     * Represents a single turn done by player 1 in which the player can attack which ends their turn,
     * then see how much damage they've done.
     */
    public void player1Turn() {
        //Creates and initializes cards belonging to the first player.
        ArrayList<Card> deck1 = new ArrayList<>();
        player1.buildDeck(deck1);
        ArrayList<Card> hand1 = new ArrayList<>();
        player1.buildSimpleHand1(hand1);
        ArrayList<Card> prize1 = new ArrayList<>();
        player1.buildPrizePile(prize1);
        //Prints instructions.
        System.out.println("Player 1's Turn! What do you want to do? Enter a number that matches" +
                " your desired action.");
        System.out.println("[1] - Fennekin attacks using Live Coal!");
        System.out.println("[2] - Fennekin attacks using Rear Kick!");
//      System.out.println("[2] - Use Energy!");
//      System.out.println("[3] - Use a Trainer card!");
        //Creates a scanner to read user input.
        Scanner input = new Scanner(System.in);
        int userInput = Integer.parseInt(input.nextLine());
        //Checks to see if the user has entered the correct number. If so, the LIVE COAL attack
        //is used against the opponent's Chimchar.
        if (userInput == 1) {
            System.out.println("Fennekin, USE LIVE COAL!");
            fennekin.attackOne(chimchar);
            System.out.println("Fennekin's HP: " + fennekin.getHp() + ", Chimchar's HP: " + chimchar.getHp() + "\n");
            if(chimchar.getHp() <= 0) {
                System.out.println("Chimchar has fainted.");
                System.out.println("Player 1 wins!");
            }
        }
        //Checks to see if the user has entered the correct number. If so, the REAR KICK attack is used
        //against the opponent's Chimchar.
        if (userInput == 2) {
            System.out.println("Fennekin, USE REAR KICK!");
            fennekin.attackTwo(chimchar);
            System.out.println("Fennekin's HP: " + fennekin.getHp() + ", Chimchar's HP: " + chimchar.getHp()  + "\n");
            if (chimchar.getHp() <= 0) {
                System.out.println("Chimchar has fainted.");
                System.out.println("Player 1 wins!");
            }
        }
        //Adds a prize pile card to the hand and removes a card from the hand.
        hand1.add(prize1.get(0));
        for(int i = 0; i < hand1.size(); i++) {
            if(!(hand1.get(i) instanceof Fennekin)) {
                hand1.remove(i);
                break;
            }
        }
        //Removes a card from the prize pile.
        prize1.remove(0);
    }

    /**
     * Implements player 2's turn in which everything from player 1's turn is implemented a second
     * time minus the deck, hand, and prize pile which are unique to the second player.
     */
    public void player2Turn() {
        //Creates and initializes what cards belong to the second player.
        ArrayList<Card> deck2 = new ArrayList<>();
        player2.buildDeck(deck2);
        ArrayList<Card> hand2 = new ArrayList<>();
        player2.buildSimpleHand2(hand2);
        ArrayList<Card> prize2 = new ArrayList<>();
        player2.buildPrizePile(prize2);
        //Gives instructions.
        System.out.println("Player 2's Turn! What do you want to do? Enter a number that matches" +
                " your desired action.");
        System.out.println("[1] - Chimchar attacks using Scratch!");
//      System.out.println("[2] - Use Energy!");
//      System.out.println("[3] - Use a Trainer card!");
        //Uses a scanner to read user input to determine which attack to use.
        Scanner input = new Scanner(System.in);
        int userInput = Integer.parseInt(input.nextLine());
        //Makes sure the user entered a 1. If not, the program throws an error.
        //If the user entered a 1, Chimchar's SCRATCH attack is used against Player 1's Fennekin.
        //The results are printed along with the attack used. If the player wins, the program prints a
        //statement saying they've won.
        if (userInput == 1) {
            System.out.println("Chimchar, USE SCRATCH!");
            chimchar.attackOne(fennekin);
            System.out.println("Chimchar's HP: " + chimchar.getHp() + ", Fennekin's HP: " + fennekin.getHp() + "\n");

            if (fennekin.getHp() <= 0) {
                System.out.println("Fennekin has fainted.");
                System.out.println("Player 2 wins!");
            }
        }
        //Adds a card from the prize pile to the hand and removes a card from the hand.
        hand2.add(prize2.get(0));
        for(int i = 0; i < hand2.size(); i++) {
            if(!(hand2.get(i) instanceof Fennekin)) {
                hand2.remove(i);
                break;
            }
        }
        //Removes a card from the prize pile.
        prize2.remove(0);
    }
}