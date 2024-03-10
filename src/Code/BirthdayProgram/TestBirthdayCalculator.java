package Code.BirthdayProgram;

/**
 * @author Mia Watts
 * This program is the tester program for the Birthday Calculator, which calculates the probability
 * of someone else in a room having the same birthday as you.
 */
public class TestBirthdayCalculator {
    public static void main(String[] args) {
        BirthdayCalculator test = new BirthdayCalculator();
        System.out.println("The probability that someone shares your birthday, " + test.getBirthday() + ", is: ");
        double birthdayProbability = test.runBirthdayCalculator(253);
        System.out.println(birthdayProbability * 100 + "%");
    }
}
