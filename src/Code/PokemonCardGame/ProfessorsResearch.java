package Code.PokemonCardGame;

import java.util.ArrayList;

public class ProfessorsResearch extends Trainer {
    private ArrayList<Card> hand;

    public ProfessorsResearch() {
        hand = new ArrayList<>();
    }

    public void playable(PokemonCardGame gameState) {
        gameState.getHand().clear();
        drawHand();
    }
}
