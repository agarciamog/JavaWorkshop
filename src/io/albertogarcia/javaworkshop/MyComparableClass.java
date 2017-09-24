package io.albertogarcia.javaworkshop;

public class MyComparableClass implements Comparable<MyComparableClass> {
    String label, value;
    public MyComparableClass(String l, String v) {
        label = l;
        value = v;
    }
    public String toString(){ return label + " | " + value; }
    public boolean equals(Object o) {
        MyComparableClass other = (MyComparableClass) o;
        return value.equalsIgnoreCase(other.value);
    }
    @Override
    public int compareTo(MyComparableClass o) {
        return value.compareToIgnoreCase(o.value);
    }
    public String getLabel() {
        return label;
    }
    public String getValue() {
        return value;
    }
}
