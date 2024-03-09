package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * This class extends Trainer and implements the TrainerActions interface.
 * Represents Leon, whose Trainer card states that once played, a Pokemon
 * can attack and deal 30 more damage than their original attack allows.
 */
public class TrainerLeon extends Trainer implements TrainerActions {
    //Boolean variable that will eventually determine whether the current turn is over.
    boolean currentTurn = true;

    /**
     * If Leon is played, the method allows a Pokemon to deal 30 more damage than usual.
     * Resets once the turn is over.
     * @param pokemon - Pokemon that will be able to attack with 30 more dealt damage.
     */
    public void Leon(Trainer pokemon) {
        while(currentTurn) {
            pokemon.setDamage(pokemon.getDamage() + 30);
            currentTurn = false;
        }
        pokemon.setDamage(pokemon.getDamage() - 30);
    }

    /**
     * Method to implement the playable version of the Leon Trainer card.
     * @param gameState - Current state of the game.
     */
    public void playable(PokemonCardGame gameState) {

    }
}
