package Code.PokemonCardGame;

public class TrainerLeon extends Trainer {
    boolean currentTurn = true;
    public void Leon(Trainer unfortunatePokemon) {
        while(currentTurn) {
            unfortunatePokemon.setDamage(unfortunatePokemon.getDamage() + 30);
            currentTurn = false;
        }
    }
}
