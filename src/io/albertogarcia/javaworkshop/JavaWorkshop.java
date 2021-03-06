package io.albertogarcia.javaworkshop;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JavaWorkshop {

	public static void main(String[] args) {
        arrayList();
	}

	private static void arrayList() {
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    int numBuckets = 10;

	    for(int i = 0; i < numBuckets; i++) {
	        arr.add(null);
        }

        System.out.println("Done");
    }

    private static void queues() {
	    Queue<Integer> queue = new PriorityQueue<Integer>();
	    queue.offer(1);
	    queue.offer(2);
	    queue.offer(4);

	    Integer i = queue.peek();
        System.out.println(i);
        System.out.println("======");
        for(Integer x : queue) {
            System.out.println(x);
        }
    }

	private static void getAscii(){
	    char c = 'J';
        int value = (int) c;
	    System.out.println(value);

    }

	private static void shipmentExample() {
	    Shipment shipment = new Shipment();
	    Product p1 = new Product("Window", 25);
	    shipment.add(p1);
	    Product p2 = new Product("Door", 15);
        shipment.add(p2);

        shipment.replace(p1, new Product("Stove", 200));

        for(Product p : shipment) {
            System.out.println(p.toString());
        }
    }

	private static void lists() {
	    List<String> list = new LinkedList<>();
	    list.add("A");
	    list.add("B");
	    list.add("C");

        System.out.println(list.get(1));
    }

	private static void collections() {
	    StringBuffer[] s = { new StringBuffer("A"), new StringBuffer("B"), new StringBuffer("C")};
	    List<StringBuffer> list = Arrays.asList(s);
	    List<StringBuffer> linkedlist = new LinkedList<>(Arrays.asList(s));

	    Iterator<StringBuffer> iterator = linkedlist.iterator();

	    StringBuffer sb;
	    while(iterator.hasNext()) {
            sb = iterator.next();
            iterator.remove();
            System.out.println(sb);
        }
    }

	private static void serialization() {
	    BankAccount acc = new BankAccount("1234", 500);
	    acc.deposit(250);
	    saveAccount(acc, "object.dat");
	    BankAccount bankAccount  = loadAccount("object.dat");
        System.out.println(bankAccount.toString());
    }

    private static void saveAccount(BankAccount ba, String file) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(file)))) {
            outputStream.writeObject(ba);
            System.out.println("Object serialized...");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static BankAccount loadAccount(String file) {
	    BankAccount ba = null;

	    try(ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(file)))) {
            ba = (BankAccount) inputStream.readObject();
        } catch (IOException e) {
	        System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
	        System.out.println(e.getMessage());
        }
        return ba;
    }

	private static void classWork(){
	    IOStreams s = new IOStreams();
	    Class<?> myClass = s.getClass();
	    Method[] methods = myClass.getDeclaredMethods();
	    for(Method m:methods) {
            System.out.println(m.toString());
        }
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
            // Can also write to an xml, but need to use outputstream > properties.storeToXML(out);
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

    private static void hashSet() {
        Set<Product> products = new HashSet<Product>();
	    Product p1 = new Product("Window", 15);
        Product p2 = new Product("Floor Panel", 5);
        Product p3 = new Product("Door", 10);
        Product p4 = new Product("Window", 15);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p3);

        for(Product p : products) {
            System.out.println(p);
        }
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
