package io.albertogarcia.javaworkshop;

import java.util.Comparator;

public class MyComparator implements Comparator<MyComparableClass> {
    @Override
    public int compare(MyComparableClass o1, MyComparableClass o2) {
        return o1.getLabel().compareToIgnoreCase(o2.getLabel());
    }
}
