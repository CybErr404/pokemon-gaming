package Code.BirthdayProgram;

/**
 * @author Mia Watts
 */
public class BirthdayCalculator extends Person {
    /**
     * Method that calculates the probability that someone else shares your birthday.
     * @param peopleInClass - The amount of people in the class.
     * @return The probability that given there are peopleInClass individuals in the class,
     * someone else shares your birthday.
     */
    public double runBirthdayCalculator(double peopleInClass) {
        return Math.pow((364.00/365.00), peopleInClass);
    }
}
