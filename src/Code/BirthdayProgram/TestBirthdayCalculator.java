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
        double birthdayProbability1 = test.runBirthdayCalculator(253);
        System.out.println(birthdayProbability1 * 100 + "%" + "\n");

        test.setBirthday(1005);
        System.out.println("The probability that someone shares your birthday, " + test.getBirthday() + ", is: ");
        double birthdayProbability2 = test.runBirthdayCalculator(20);
        System.out.println(birthdayProbability2 * 100 + "%");
    }
}
