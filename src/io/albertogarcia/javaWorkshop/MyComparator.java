package io.albertogarcia.javaWorkshop;

import io.albertogarcia.javaWorkshop.MyComparableClass;

import java.util.Comparator;

public class MyComparator implements Comparator<MyComparableClass> {
    @Override
    public int compare(MyComparableClass o1, MyComparableClass o2) {
        return o1.getLabel().compareToIgnoreCase(o2.getLabel());
    }
}
