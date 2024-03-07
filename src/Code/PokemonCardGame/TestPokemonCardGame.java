package Code.PokemonCardGame;

public class TestPokemonCardGame {

    public static void main(String[] args) {
        PokemonCardGame test = new PokemonCardGame();
        //test.runAgain();
        test.run(100.00);

        System.out.println(test.getDeck().toString());
    }
}
