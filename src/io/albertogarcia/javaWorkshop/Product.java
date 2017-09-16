package io.albertogarcia.javaWorkshop;

import java.util.Objects;

public class Product implements Comparable<Product> {
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

    public String getName(){ return name; }
    public int getWeight() { return weight; }

    @Override
    public int compareTo(Product p) {
        return name.compareToIgnoreCase(p.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
