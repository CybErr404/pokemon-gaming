package Code.StatsLibrary;

import java.util.ArrayList;
public class SetOperations
{
    public String setUnion(ArrayList <String> setOne, ArrayList <String> setTwo) {
        ArrayList<String> resultArrayList = new ArrayList<>();
        for (String s : setOne) {
            setTwo.add(s);
        }
        for (int i = 0; i < setTwo.size(); i++) {
            if (!resultArrayList.contains(setTwo.get(i))) {
                resultArrayList.add(setTwo.get(i));
            }
        }
        return resultArrayList.toString();
    }

    public String setIntersection(ArrayList <String> setOne, ArrayList <String> setTwo) {
        StringBuilder intersectedSet = new StringBuilder();

        for (String value : setOne) {
            for (String s : setTwo) {
                if (value.equals(s)) {
                    intersectedSet.append(" ").append(value);
                }
            }
        }
        return intersectedSet.toString();
    }

    public String setComplement(ArrayList <String> set, ArrayList <String> boundArray) {

        for(int i = 0; i < boundArray.size(); i++) {
            for(int j = 0; j <= set.size(); j++) {
                if(boundArray.get(i).equals(set.get(j))) {
                    set.remove(j);
                }
            }
        }
        return set.toString();
    }
}
