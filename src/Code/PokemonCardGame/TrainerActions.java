package Code.PokemonCardGame;

/**
 * @author Mia Watts
 * TrainerActions interface that has each Trainer implement the playable method
 * that can play the specific Trainer card being created.
 */
public interface TrainerActions {
    /**
     * Interface method that must be added to all Trainer classes.
     * @param gameState - Current state of the game.
     */
    void playable(PokemonCardGame gameState);
}
