package Code.StatsLibrary;

//This class's purpose is to test all formulas and methods within the StatsLibrary class.
//See the StatsLibrary class for a programmed collection of all statistics formulas
//that have been covered in the course up to 3/7/2024.
public class TestStatsLibrary {
    public static void main(String[] args) {
        //Creates a new object named test of type StatsLibrary. Test will
        //be used to try each method written in the StatsLibrary class.
        StatsLibrary test = new StatsLibrary();
        //Creates an array called numbersArray that has two repeating numbers.
        //numbersArray is used to test the mean, median, and mode.
        int[] numbersArray1 = {1, 2, 3, 4, 4, 5, 6, 7, 7};
        int[] numbersArray2 = {1, 2, 3, 4, 5, 6, 7};
        int[] numbersArray3 = {2, 3, 4, 5, 5, 7, 8, 9};

        //TESTING THE MEAN METHOD...
        //Initializes a double variable called storeMeanResults with the result of
        //calling the findMean method on the numbersArray variable.
        double storeMeanResults = test.findMean(numbersArray1);
        //Prints the mean of the array.
        System.out.println("The mean of the array is: " + storeMeanResults);

        //TESTING THE MODE METHOD...
        //Declares and initializes a variable called storeModeResults1 that stores
        //the result of taking the mode of an array with two repeating values of the same count.
        double storeModeResults1 = test.findMode(numbersArray1);
        //Declares and initializes a variable called storeModeResults2 that stores
        //the result of taking the mode of an array with no mode.
        double storeModeResults2 = test.findMode(numbersArray2);
        //Declares and initializes a variable called storeModeResults3 that stores
        //the result of taking the mode of an array with one clear mode.
        double storeModeResults3 = test.findMode(numbersArray3);
        //Prints the mode of an array with two repeating values of the same count.
        System.out.println("The mode of an array with two repeating values is: " + storeModeResults1);
        //Prints the mode of an array with no mode.
        System.out.println("The mode of an array with no mode is: " + storeModeResults2);
        //Prints the mode of an array that has one clear mode.
        System.out.println("The mean of an array with one mode is: " + storeModeResults3);

        //TESTING THE MEDIAN METHOD...
        //Declares and initializes a variable called storeMedianResults1 that stores
        //the result of taking the median of an array with an odd number of values.
        double storeMedianResults1 = test.findMedian(numbersArray1);
        //Declares and initializes a variable called storeMedianResults2 that stores
        //the result of taking the median of an array with an even number of values.
        double storeMedianResults2 = test.findMedian(numbersArray3);
        //Prints the median of the array with an odd number of values.
        System.out.println("The median of an odd array is: " + storeMedianResults1);
        //Prints the median of the array with an even number of values.
        System.out.println("The median of an even array is: " + storeMedianResults2);


    }
}
