package Code.BirthdayProgram;

/**
 * @author Mia Watts
 */
public class Person {
    //Declares a birthday variable.
    private int birthday;

    /**
     * Creates a Person constructor that initializes the person's birthday.
     */
    public Person() {
        //Initializes the person's birthday to Christmas Day (just because)!
        birthday = 1225;
    }

    /**
     * Getter method that returns the person's integer birthday.
     * @return The person's birthday.
     */
    public int getBirthday() {
        return birthday;
    }

    /**
     * Setter method that changes the birthday variable to a new one.
     * @param newBirthday - Integer variable that houses the new birthday.
     */
    public void setBirthday(int newBirthday) {
        birthday = newBirthday;
    }
}
