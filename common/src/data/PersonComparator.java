package data;

import java.util.Comparator;

public class PersonComparator implements Comparator<HairColor> {

    @Override
    public int compare(HairColor o1, HairColor o2) {
        return o1.getValue() - o2.getValue();
    }
}
