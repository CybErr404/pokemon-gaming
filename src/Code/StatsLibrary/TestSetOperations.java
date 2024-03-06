package Code.StatsLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSetOperations
{
    public static void main(String[] args) {
        SetOperations setTest = new SetOperations();

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
        ArrayList<Integer> bound = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        String storeUnionResult = setTest.setUnion(numbers1, numbers2);
        System.out.println("The union is: " + storeUnionResult);
        String storeIntersectionResult = setTest.setIntersection(numbers1, numbers2);
        System.out.println("The intersection is: " + storeIntersectionResult);
        String storeComplementResult1 = setTest.setComplement(numbers1, bound);
        System.out.println("The complement is: " + storeComplementResult1);
        String storeComplementResult2 = setTest.setComplement(numbers2, bound);
        System.out.println("The complement is: " + storeComplementResult2);
    }
}
