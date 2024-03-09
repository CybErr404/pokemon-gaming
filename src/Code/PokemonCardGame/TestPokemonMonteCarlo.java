package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * Runs the first Monte Carlo simulation and prints the results.
 */
public class TestPokemonMonteCarlo {
    public static void main(String[] args) {
        //Creates a new PokemonMonteCarlo object named test that will be used to run the simulation.
        PokemonMonteCarlo test = new PokemonMonteCarlo();
        //Runs the simulation 100 times.
        test.run(100.00);
    }
}
