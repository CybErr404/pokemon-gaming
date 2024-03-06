package Code.StatsLibrary;

//Import statement for the arrays class.
import java.util.Arrays;
//Import statement for the TreeMaps used within the mode method.
import java.util.TreeMap;

//The StatsLibrary class is a comprehensive collection of formulas that have been taught
//in Probability and Applied Statistics. Central tendencies, Probability Mass Functions (PMFs),
//and more are included in this class.

//A full list of everything that has been programmed into the StatsLibrary would include the following:
//Mean, median, mode, classic variance, classic standard deviation, the mn rule, permutations,
//combinations, a factorial method using both Longs and BigInteger, conditional probability formulas
//(both P(A|B) and P(B|A)), an independent and dependent checker, the Multiplicative Law of
//Probability, the General Addition Rule Axiom, the odds of something not occurring,
//the Theorem of Total Probability, Bayes Theorem, Combinatorial PMFs, the Binomial Distribution PMF,
//the expected value, variance, and standard deviation for binomial distribution, the Geometric
//Distribution PMF, the expected value, variance, and standard deviation for geometric distribution,
//the Hypergeometric Distribution PMF, the expected value, variance, and standard deviation for
//hypergeometric distribution, the Negative Binomial Distribution PMF, and the expected value,
//variance, and standard deviation for negative binomial distribution.
public class StatsLibrary {

    public double findMean(int[] userInput) {

        //Find the sum.
        double sum = 0;
        for(int i = 0; i < userInput.length; i++) {
            sum = userInput[i] + sum; //or +=, either works.
        }
        double result = sum / userInput.length;

        return result;
    }

    //Median = the middle of the list of numbers (exact middle if odd, average of left and right middle if even).
    public double findMedian(int[] userArray) {
        //Sort the array from smallest to biggest.
        Arrays.sort(userArray);

        //Check whether the array is even (if so, we need to take the average of the middle two numbers).
        //If the array is odd, then we can simply return the middle number.
        if(userArray.length % 2 == 0) {
            int halfLength = userArray.length / 2; //Splits the array length in half and stores the result.
            double middle1 = userArray[halfLength]; //Assigns the first middle number to the division result.
            double middle2 = userArray[halfLength - 1]; //Assigns the second middle number to the one next to the middle.
            return (middle1 + middle2) / 2; //Returning the median.
        }
        else {
            return userArray[(userArray.length / 2)]; //Returns the median.
        }
    }

    //Mode = finding the most common number in a list.
    public double findMode(int[] userArray) {
        TreeMap<Integer, Integer> modeTreeMap = new TreeMap<>();

        return 0;
    }

    public double findVariance(int[] array) {
        double n = array.length; //n represents the size of the array.
        double side1 = (1/(n - 1)); //side1 represents the first side to be multiplied, i.e., 1/(n-1).
        double side2 = 0.0; //side2 represents the summation in the formula.
        double sum = 0.0; //sum represents the sum of all array values.
        double mean = 0.0; //mean is the sum of all array elements divided by how many elements there are. (average but not).
        double variance = 0.0; //variance is the variable that is returned that will contain the variance value.

        for(int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        mean = findMean(array);

        for(int i = 0; i < array.length; i++) {
            side2 = side2 + Math.pow(array[i] - mean, 2);
        }

        variance  = (side1 * side2);
        return variance;
    }

    public double findStandardDeviation(int[] array) {
        double standardDeviation = 0.0;
        standardDeviation = Math.sqrt(findVariance(array));
        return standardDeviation;
    }
}