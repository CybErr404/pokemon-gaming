package PokemonCardGame;

public class TestPikachu {
    public static void main(String[] args) {
        Pikachu pikaMain = new Pikachu();
        Pikachu pikaTarget = new Pikachu();
        Bulbasaur newBulb = new Bulbasaur();

        System.out.println("Bulbasaur, USE LEECH SEED!");
        newBulb.attackOne(pikaMain);
        System.out.println("Pika Main Hp: " + pikaMain.getHp() + " Bulbasaur Hp: " + newBulb.getHp());

        pikaMain.attackOne(newBulb);

        while(pikaTarget.getHp() > 0) {
            System.out.println("Pikachu, USE QUICK ATTACK!");
            pikaMain.attackOne(pikaTarget);
            System.out.println("Pika Target Hp: " + pikaTarget.getHp());
        }
    }
}
