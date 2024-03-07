package Code.PokemonCardGame;

import java.util.ArrayList;

public class TrainerLillie extends Trainer {
    private ArrayList<Card> hand;
    private int turnCount;
    public void Lillie() {
        if(hand.size() < 6) {
            int size = hand.size();
            for(int i = size; i <= 6; i++) {
                hand.add(drawCard());
            }
        } else if (turnCount == 1) {
            if(hand.size() < 8) {
                int size = hand.size();
                for(int i = size; i <= 8; i++) {
                    hand.add(drawCard());
                }
            }
        }
    }
}
