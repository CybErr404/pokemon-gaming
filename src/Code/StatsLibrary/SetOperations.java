package Code.StatsLibrary;

import java.util.ArrayList;
import java.util.Objects;

public class SetOperations
{
    public String setUnion(ArrayList <Integer> setOne, ArrayList <Integer> setTwo) {
        ArrayList<String> resultArrayList = new ArrayList<>();
        for (Integer s : setOne) {
            setTwo.add(s);
        }
        for (int i = 0; i < setTwo.size(); i++) {
            if (!resultArrayList.contains(setTwo.get(i))) {
                resultArrayList.add(String.valueOf(setTwo.get(i)));
            }
        }
        return resultArrayList.toString();
    }

    public String setIntersection(ArrayList <Integer> setOne, ArrayList <Integer> setTwo) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        for(int i = 0; i < setOne.size(); i++) {
            for(int j = 0; j < setTwo.size(); j++) {
                if(Objects.equals(setOne.get(i), setTwo.get(j)) &&
                        !(resultArrayList.contains(setOne.get(i)))) {
                    resultArrayList.add(setOne.get(i));
                }
            }
        }
        return resultArrayList.toString();
    }

    public String setComplement(ArrayList <Integer> set, ArrayList <Integer> boundArray) {

        for(int i = 0; i < boundArray.size(); i++) {
            for(int j = 0; j < set.size(); j++) {
                if(boundArray.get(i).equals(set.get(j))) {
                    set.remove(j);
                }
            }
        }
        return set.toString();
    }
}
