package Code.StatsLibrary;

import java.util.ArrayList;
public class TestSetOperations
{
    public static void main(String[] args) {
        SetOperations setTest = new SetOperations();

        ArrayList<String> daysOfTheWeek1 = new ArrayList<>();
        daysOfTheWeek1.add("Monday");
        daysOfTheWeek1.add("Tuesday");
        daysOfTheWeek1.add("Wednesday");
        daysOfTheWeek1.add("Thursday");
        daysOfTheWeek1.add("Friday");

        ArrayList<String> daysOfTheWeek2 = new ArrayList<>();
        daysOfTheWeek2.add("Monday");
        daysOfTheWeek2.add("Tuesday");
        daysOfTheWeek2.add("Saturday");
        daysOfTheWeek2.add("Sunday");

        ArrayList<String> totalDays = new ArrayList<>();
        daysOfTheWeek2.add("Monday");
        daysOfTheWeek2.add("Tuesday");
        daysOfTheWeek2.add("Wednesday");
        daysOfTheWeek2.add("Thursday");
        daysOfTheWeek2.add("Friday");
        daysOfTheWeek2.add("Saturday");
        daysOfTheWeek2.add("Sunday");

        //String storeUnionResult = setTest.setUnion(daysOfTheWeek1, daysOfTheWeek2);
        //System.out.println(storeUnionResult);
        //String storeIntersectionResult = setTest.setIntersection(daysOfTheWeek1, daysOfTheWeek2);
        //System.out.println(storeIntersectionResult);
        String storeComplementResult = setTest.setComplement(daysOfTheWeek1, totalDays);
        System.out.println(storeComplementResult);
    }
}
