package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * This class is a tester class that runs the second Monte Carlo simulation (the Rare Candy
 * Monte Carlo simulation).
 */
public class TestRareCandyMonteCarlo {
    public static void main(String[] args) {
        //Creates a new object of type RareCandyMonteCarlo which will be used to test/run the simulation.
        RareCandyMonteCarlo test = new RareCandyMonteCarlo();
        //Runs the simulation 10000 times.
        test.run(10000.00);
    }
}
