package io.albertogarcia.javaworkshop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {
    private static final int PRODUCT_DOES_NOT_EXIST = -1;
    public final List<Product> products = new ArrayList<>();

    public Shipment(){

    }

    public void add(Product p) {
        products.add(p);
    }

    public void remove(Product p) {
        products.remove(p);
    }

    public void replace(Product oldProd, Product newProd) {
        if(products.indexOf(oldProd) != PRODUCT_DOES_NOT_EXIST) {
            products.set(products.indexOf(oldProd), newProd);
        }
    }
    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
