package io.albertogarcia.javaWorkshop;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JavaWorkshop {

	public static void main(String[] args) {
        readProperties();
	}

	private static void readProperties() {
	    Properties properties = new Properties();
	    try (BufferedReader reader = Files.newBufferedReader(Paths.get("app.properties"))) {
            properties.load(reader);
            properties.forEach( (k, v) -> System.out.println(k + " | " + v));
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

	private static void writeProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("fname", "Alberto");
	    properties.setProperty("lname", "Garcia");
	    properties.setProperty("accNum", "123456");

	    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("app.properties"))) {
	        properties.store(writer, "Application Properties");
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
	private static void sortedMap() {
	    SortedMap<String, Integer> map = new TreeMap<>();
        map.put("ghi", 111);
        map.put("abc", 444);
        map.put("def", 333);
        map.put("xyz", 999);

        // Output is sorted
        System.out.println("Tree Map:");
        map.forEach( (k, v) -> System.out.println(k + " | " + v));
        System.out.println("\nTail Map:");
        SortedMap<String, Integer> hMap = map.headMap("def");
        hMap.forEach( (k, v) -> System.out.println(k + " | " + v));
        System.out.println("\nHead Map:");
        SortedMap<String, Integer> tMap = map.tailMap("def");
        tMap.forEach( (k, v) -> System.out.println(k + " | " + v));
    }

	private static void mapsLamdaExpressions() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ghi", 111);
        map.put("abc", 444);
        map.put("def", 333);

        map.forEach( (k, v) -> System.out.println(k + " | " + v));
        System.out.println();
        map.replaceAll( (k, v) -> v = 0);
        map.forEach( (k, v) -> System.out.println(k + " | " + v));
    }

	private static void mapsPutGet() {
        /*
           This is called "programming to an interface" - a rather common and very useful practice.

           Map<String,Integer> is an interface. It cannot be instantiated. Variables of interface
           types need to be assigned objects of classes that implement these interfaces.

           HashMap<String,Integer> is a class that implements Map<String,Integer>, so the assignment
           is valid. If you decide to change the type later, and use TreeMap<String,Integer> instead
           of HashMap<String,Integer>, all you need to do is change the type in the new expression.
           The rest of your code would remain the same.
         */
	    Map<String, Integer> map = new HashMap<>();
	    map.put("ghi", 111);
	    map.put("abc", 444);
	    map.put("def", 333);

	    Integer s1 = map.get("ghi");
        System.out.println(s1);

        // Note, return can be null, and since assigning null to an int will cause a NullPointerException,
        // you should assign to type Integer.
        Integer s2 = map.get("xyz");
        System.out.println(s2);

        Integer s3 = map.getOrDefault("xyz", 999);
        System.out.println(s3);
    }

	private  static void collectionSort_comparable() {
	    TreeSet<MyComparableClass> tree = new TreeSet<>();
	    tree.add(new MyComparableClass("2222", "ghi"));
        tree.add(new MyComparableClass("3333", "abc"));
        tree.add(new MyComparableClass("1111", "def"));

        // tree used the compareTo method in MyComparableClass
        // to sort the collection tree automatically.
        tree.forEach(v -> System.out.println(v));
    }

    private  static void collectionSort_comparator() {
        TreeSet<MyComparableClass> tree = new TreeSet<>(new MyComparator());
        tree.add(new MyComparableClass("2222", "ghi"));
        tree.add(new MyComparableClass("3333", "abc"));
        tree.add(new MyComparableClass("1111", "def"));

        // tree used the compare method in MyComparator
        // to sort the collection tree.
        tree.forEach(v -> System.out.println(v));
    }

    private static void list() {
	    List<String> l = new ArrayList<>();
	    l.add("Hello world!");
	    l.add("Hola mundo!");

        LinkedList<String> m = new LinkedList<>();
        m.addAll(l);

        // Lamda expression
        m.forEach(n -> System.out.println(n));
        System.out.println("Done!");

        //int[] arr = {1, 2, 4, 56, 24, 98};
        ArrayList<Integer> aL = new ArrayList<>(Arrays.asList(1, 43, 56, 84, 57));
        int[] arr = aL.stream().mapToInt(i -> i).toArray();

    }

    private static  void stringFormatterWriter() {
        int a = 1, b = 2, c = 4;
        float avg = (a + b + c) / 3.0f;

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("file1.txt"))) {
            Formatter f = new Formatter(writer);
            f.format("My intergers are %d, %d and %d.", a, b, c);
            writer.newLine();
            f.format("The average is %.2f", avg);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static void stringFormatter() {
	    int a = 1, b = 2, c = 4;
        System.out.println(String.format("The values of my integers are %d, %d and %d.", a, b, c));

        float avg = (a + b + c) / 3.0f;
        System.out.printf("The avg for my string is %.2f", avg);
    }
    private static void stringJoiner() {
        /*
            === NOTES on String, StringBuilder, StringBuffer ===
         If your string is not going to change use a String class because a String object is immutable.
         If your string can change (example: lots of logic and operations in the construction of the string) and will only be accessed from a single thread, using a StringBuilder is good enough.
         If your string can change, and will be accessed from multiple threads, use a StringBuffer because StringBuffer is synchronous so you have thread-safety.
        */
        StringJoiner sj = new StringJoiner("\n");
        sj.add("hi");
        sj.add("hello");
        sj.add("hola");
        sj.add("que tal");

        System.out.println(sj.toString());
    }

    private static void AddException() {
        ExceptionHandling eh = new ExceptionHandling();
        eh.AddException();
    }

    public  static void writeToFile() {
	    IOStreams s = new IOStreams();
        try {
            s.buffWriter();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

    public static void readFile() {
	    IOStreams s = new IOStreams();
	    try {
	        s.buffReader();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

    public static void newReadFile() {
	    IOStreams s = new IOStreams();
	    System.out.println("New Read File");
	    try {
	        s.newBuffReader();
        } catch (IOException e) {
	        System.out.println(e.getMessage());
        }
    }

    public static void readAllLines() {
	    IOStreams s = new IOStreams();
        try {
            s.readAllLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
