package Code.StatsLibrary;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Mia Watts
 */

//The purpose of this class is to define methods for set union, set intersection, and set complement.
public class SetOperations
{
    /**
     * This returns the union of two arrayLists using two enhanced for loops that
     * removes duplicates by making sure they aren't added if they already exist in both arrayLists.
     * @param setOne - Integer arrayList to be unioned with a second arrayList (setTwo)
     * @param setTwo - Integer arrayList to be unioned with the first arrayList (setOne)
     * @return the unioned arrayList
     */
    public String setUnion(ArrayList <Integer> setOne, ArrayList <Integer> setTwo) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        //Checks if the result array has the current value in setOne. If not, it
        //adds the value to the array.
        for (Integer s : setOne) {
            if(!(resultArrayList.contains(s))) {
                resultArrayList.add(s);
            }
        }
        //Checks if the result array has the current value in setTwo. If not, it adds it to the
        //result array.
        for (Integer integer : setTwo) {
            if (!resultArrayList.contains(integer)) {
                resultArrayList.add(integer);
            }
        }
        //returns the unioned set.
        return resultArrayList.toString();
    }

    /**
     * This method returns the intersection of two arrayLists checking for duplicates and
     * ensuring that only the values that are in common are printed.
     * @param setOne - Integer arrayList to be intersected with a second arrayList (setTwo)
     * @param setTwo - Integer arrayList to be intersected with the first arrayList (setOne)
     * @return the intersected set result.
     */
    public String setIntersection(ArrayList <Integer> setOne, ArrayList <Integer> setTwo) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        //Checks to see if a singular value at one time in setOne equals any of the ones in
        //setTwo. If they are equal and the result array does not contain the value, the value
        //is added  to the result array.
        for (Integer integer : setOne) {
            for (Integer value : setTwo) {
                if (Objects.equals(integer, value) &&
                        !(resultArrayList.contains(integer))) {
                    resultArrayList.add(integer);
                }
            }
        }
        //returns the intersected set.
        return resultArrayList.toString();
    }

    /**
     * This returns the complement of a set when compared to what set it's bounded by.
     * @param set - set that we want to find the complement of in the method
     * @param boundArray - the array that binds the set (i.e., days of the week, boundArray
     *                   would end up being all seven days and set may only be four, five, etc.).
     * @return the complement arrayList that prints the complemented set.
     */
    public String setComplement(ArrayList <Integer> set, ArrayList <Integer> boundArray) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        //Iterates through the bound array, and if the set we want to complement doesn't contain
        //the value and the result doesn't, either, the loop adds the value to the result array.
        for (Integer integer : boundArray) {
            //covers duplicates because it checks to make sure the result array doesn't already
            //contain the value.
            if (!set.contains(integer) && !resultArrayList.contains(integer)) {
                resultArrayList.add(integer);
            }
        }
        //returns the complemented set.
        return resultArrayList.toString();
    }
}
