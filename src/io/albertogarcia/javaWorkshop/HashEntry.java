package io.albertogarcia.javaWorkshop;

class HashEntry {
    private int key;
    private int value;

    public HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

class HashTable {
    private int size = 128;
    private HashEntry[] table;

    public HashTable() {
        table = new HashEntry[size];
    }

    public void add(int key, int value) {
        int hash = key % size;
        while(table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % size;
        }

        table[hash] = new HashEntry(key, value);
    }

    public int get(int key) {
        int hash = key % size;
        while(table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % size;

        if(table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add(1, 10);
        hashTable.add(5, 25);
        hashTable.add(133, 50);

        System.out.println(hashTable.get(5));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(1));
    }
}