package Code.PokemonCardGame;

/**
 * @author Mia Watts
 */
//Tests whether the Pikachu and other Pokemon cards work.
public class TestPikachu {
    public static void main(String[] args) {
        //Initializes Pikachu and Bulbasaur objects.
        Pikachu pikaMain = new Pikachu();
        Pikachu pikaTarget = new Pikachu();
        Bulbasaur newBulb = new Bulbasaur();

        //Simulates a Bulbasaur attack.
        System.out.println("Bulbasaur, USE LEECH SEED!");
        newBulb.attackOne(pikaMain);
        System.out.println("Pika Main HP: " + pikaMain.getHp() + " Bulbasaur HP: " + newBulb.getHp());

        //Uses Pikachu's QUICK ATTACK! on Bulbasaur.
        pikaMain.attackOne(newBulb);

        //Loops through attacks until the target has been defeated.
        while(pikaTarget.getHp() > 0) {
            System.out.println("Pikachu, USE QUICK ATTACK!");
            pikaMain.attackOne(pikaTarget);
            System.out.println("Pika Target Hp: " + pikaTarget.getHp());
        }
    }
}
