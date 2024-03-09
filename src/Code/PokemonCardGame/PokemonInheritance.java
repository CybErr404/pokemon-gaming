package Code.PokemonCardGame;

/**
 * @author Mia Watts
 */
//Creates HP, damage, attack names, and getter/setter methods.
public class PokemonInheritance {
    //Declares HP, damage, and attack name variables.
    private int hp;
    private int damage;
    private String attackOneName;
    private String attackTwoName;

    /**
     * Initializes hp, damage, and attack names to simple values.
     */
    public PokemonInheritance() {
        hp = 0;
        damage = 0;
        attackOneName = "";
        attackTwoName = "";
    }

    /**
     * Getter method for the Pokemon's HP.
     * @return HP value.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Setter method for the Pokemon's HP.
     * @param userInputHp - HP value to set the Pokemon's HP to, inputted by the user.
     */
    public void setHp(int userInputHp) {
        hp = userInputHp;
    }

    /**
     * Getter method for the Pokemon's damage.
     * @return Damage value.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Setter method for the Pokemon's damage.
     * @param userInputDamage - Damage value to set the Pokemon's damage to, inputted by the user.
     */
    public void setDamage(int userInputDamage) {
        damage = userInputDamage;
    }

    /**
     * Getter method for the first attack's name.
     * @return Attack name in String form.
     */
    public String getAttackOneName() {
        return attackOneName;
    }

    /**
     * Setter method for the first attack's name.
     * @param userInputAttackOneName - Value that the attack name will be changed to.
     */
    public void setAttackOneName(String userInputAttackOneName) {
        attackOneName = userInputAttackOneName;
    }

    /**
     * Getter method for the second attack's name.
     * @return Attack name in String form.
     */
    public String getAttackTwoName() {
        return attackTwoName;
    }

    /**
     * Setter method for the second attack's name.
     * @param userInputAttackTwoName - Value that the attack name will be changed to.
     */
    public void setAttackTwoName(String userInputAttackTwoName) {
        attackTwoName = userInputAttackTwoName;
    }
}
