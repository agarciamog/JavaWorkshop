package io.albertogarcia.javaWorkshop;

public class Product {
    private String name;
    private int weight;

    public Product (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Weight: " + weight;
    }
}
