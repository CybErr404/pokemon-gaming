package Code.StatsLibrary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mia Watts
 */

//The purpose of this class is to test all SetOperation methods defined in the SetOperations class.
public class TestSetOperations
{
    public static void main(String[] args) {
        //Creates a new SetOperations object called setTest.
        SetOperations setTest = new SetOperations();

        //The next three lines of code initialize three arrayLists:
        //The first is an arrayList that contains four numbers.
        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        //The second is an arrayList that contains four different numbers (matching 2 and 3).
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
        //The third is an arrayList that bounds the two prior arrays for the purpose of
        //using the complement method.
        ArrayList<Integer> bound = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        //Stores the union result when unioning the first and second array.
        String storeUnionResult = setTest.setUnion(numbers1, numbers2);
        //prints the result of the union.
        System.out.println("The union is: " + storeUnionResult);
        //Stores the intersection result when intersecting the first and second array.
        String storeIntersectionResult = setTest.setIntersection(numbers1, numbers2);
        //prints the result of the intersection.
        System.out.println("The intersection is: " + storeIntersectionResult);
        //Stores the complement results for the first array and the boundArray.
        String storeComplementResult1 = setTest.setComplement(numbers1, bound);
        //prints the result of the first complement.
        System.out.println("The complement is: " + storeComplementResult1);
        //Stores the complement results for the second array and the boundArray.
        String storeComplementResult2 = setTest.setComplement(numbers2, bound);
        //prints the result of the second complement.
        System.out.println("The complement is: " + storeComplementResult2);
    }
}
