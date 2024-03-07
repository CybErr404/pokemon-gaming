package Code.StatsLibrary;

//Import statement for the arrays class.
import java.math.BigInteger;
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
//the Theorem of Total Probability, Bayes Theorem, the combinatorial PMF, the Binomial Distribution PMF,
//the expected value, variance, and standard deviation for binomial distribution, the Geometric
//Distribution PMF, the expected value, variance, and standard deviation for geometric distribution,
//the Hypergeometric Distribution PMF, the expected value, variance, and standard deviation for
//hypergeometric distribution, the Negative Binomial Distribution PMF, and the expected value,
//variance, and standard deviation for negative binomial distribution.

/**
 * @author Mia Watts
 */
public class StatsLibrary {

    /**
     *
     * @param userInput - array that takes integer values
     * @return the mean result, or the sum divided by the length of the array
     */
    public double findMean(int[] userInput) {

        //Find the sum.
        double sum = 0;
        for (int j : userInput) {
            sum = j + sum; //or +=, either works.
        }

        //returns the sum divided by the array length
        return sum / userInput.length;
    }

    /**
     *
     * @param userArray - array parameter that has integer values
     * @return median (middle value if odd array length and result of dividing two middle numbers
     * after adding them together if even)
     */
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

    /**
     *
     * @param userArray - array of integer values
     * @return the mode
     */
    //Mode = finding the most common number in a list.
    public double findMode(int[] userArray) {
        TreeMap<Integer, Integer> modeTreeMap = new TreeMap<>();
        for(int i = 0; i < userArray.length; i++) {
            modeTreeMap.put(userArray[i], i);
        }
        for(int i = 0; i < userArray.length; i++) {
            if(modeTreeMap.containsKey(userArray[i])) {
                modeTreeMap.put(userArray[i], i + 1);
            }
        }
        return modeTreeMap.values().stream().max(Integer::compare).get();
    }

    public double findVariance(int[] array) {
        double n = array.length; //n represents the size of the array.
        double side1 = (1/(n - 1)); //side1 represents the first side to be multiplied, i.e., 1/(n-1).
        double side2 = 0.0; //side2 represents the summation in the formula.
        double sum = 0.0; //sum represents the sum of all array values.
        double mean = 0.0; //mean is the sum of all array elements divided by how many elements there are. (average but not).
        double variance = 0.0; //variance is the variable that is returned that will contain the variance value.

        for (int k : array) {
            sum = sum + k;
        }

        mean = findMean(array);

        for (int j : array) {
            side2 = side2 + Math.pow(j - mean, 2);
        }

        variance  = (side1 * side2);
        return variance;
    }

    public double findStandardDeviation(int[] array) {
        double standardDeviation = 0.0;
        standardDeviation = Math.sqrt(findVariance(array));
        return standardDeviation;
    }

    public double mxnRule(double m, double n) {
        return m * n;
    }

    public long longFactorial(double number) {
        long result = 1;
        for(int i = (int) number; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    public BigInteger bigIntegerFactorial(int number) {
        BigInteger result = BigInteger.ONE;
        for(int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public BigInteger permutations(int n, int r) {
        return ((bigIntegerFactorial(n)).divide(bigIntegerFactorial(n - r)));
    }

    public BigInteger combinations(int n, int r) {
        BigInteger numerator = (bigIntegerFactorial(n));
        BigInteger denominator = (bigIntegerFactorial(r)).multiply((bigIntegerFactorial(n - r)));
        return numerator.divide(denominator);
    }

    public long combinationsLong(int n, int r) {
        double numerator = longFactorial(n);
        double denominator = longFactorial(r) * longFactorial(n - r);
        return (long) (numerator / denominator);
    }

    public double conditionalProbability1(double b, double aIntersectionB) {
        if(b == 0) {
            return 0.00;
        }
        return (aIntersectionB / b);
    }

    public double conditionalProbability2(double a, double aIntersectionB) {
        if(a == 0) {
            return 0.00;
        }
        return (aIntersectionB / a);
    }

    public boolean independenceChecker(double aGivenB, double bGivenA, double a, double b,
                                       double aIntersectionB) {
        return aGivenB == a || bGivenA == b || aIntersectionB == (a * b);
    }

    public double multiplicativeLawOfProbability1(double a, double bGivenA) {
        return a * bGivenA;
    }

    public double multiplicativeLawOfProbability2(double a, double aGivenB) {
        return a * aGivenB;
    }

    public double multiplicativeLawOfProbability3(double a, double b) {
        return a * b;
    }

    public double additiveLawOfProbability1(double a, double b, double aIntersectionB) {
        return a + b - aIntersectionB;
    }

    public double additiveLawOfProbability2(double a, double b) {
        return a + b;
    }

    public double oddsOfSomethingNotHappening(double aBar) {
        return 1.0 - aBar;
    }

    public double theoremOfTotalProbability(double aGivenB, double b, double bBar, double aGivenBBar) {
        return (double) ((aGivenB) * (b)) / ((aGivenB) * (b)) + ((aGivenBBar) * (bBar));
    }

    public double bayesTheorem(double a, double b, double aGivenB) {
        return ((aGivenB) * (b)) / a;
    }

    public double combinatorialPMF(int N, int nR, int nB, int y, int s) {
        return (double) ((combinationsLong(nR, y)) * (combinationsLong(nB, (s - y)))) / (combinationsLong(N, s));
    }

    public double binomialDistributionPMF(double p, double q, int n, int y) {
        return (combinationsLong(n, y)) * (Math.pow(p, y)) * (Math.pow(q, (n - y)));
    }

    public double expectedValueBDPMF(double n, double p) {
        return n * p;
    }

    public double varianceValueBDPMF(double n, double p, double q) {
        return n * p * q;
    }

    public double standardDeviationValueBDPMF(double n, double p, double q) {
        return Math.sqrt(varianceValueBDPMF(n, p, q));
    }

    public double geometricDistributionPMF(double p, double q, int y) {
        return (Math.pow(q, (y - 1))) * p;
    }

    public double expectedValueGDPMF(double p) {
        return 1 / p;
    }

    public double varianceValueGDPMF(double p) {
        return (1 - p)/(Math.pow(p, 2));
    }

    public double standardDeviationValueGDPMF(double p) {
        return Math.sqrt(varianceValueGDPMF(p));
    }

    public long hypergeometricDistributionPMF(int r, int y, int N, int n) {
        return ((combinationsLong(r, y)) * (combinationsLong(N - r, n - y))) /
                (combinationsLong(N, n));
    }

    public double expectedValueHGDPMF(double n, double r, double N) {
        return (n * r) / N;
    }

    public double varianceValueHGDPMF(double n, double r, double N) {
        return n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1));
    }

    public double standardDeviationValueHGDPMF(double n, double r, double N) {
        return Math.sqrt(varianceValueHGDPMF(n, r, N));
    }

    public double negativeBinomialDistributionPMF(double p, double q, int  y, int r) {
        double combination = combinationsLong(y - 1, r - 1);
        return combination * (Math.pow(p, r)) * (Math.pow(q, y - r));
    }

    public double expectedValueNBDPMF(double p, int r) {
        return r / p;
    }

    public double varianceValueNBDPMF(double p, int r) {
        return (r * (1 - p)) / (Math.pow(p, 2));
    }

    public double standardDeviationValueNBDPMF(double p, int r) {
        return Math.sqrt(varianceValueNBDPMF(p, r));
    }
}