package io.albertogarcia.javaworkshop;

import java.io.Serializable;

public class BankAccount implements Serializable{
    private final String id;
    private double balance;

    public BankAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double d) {
        balance += d;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Balance: $" + balance;
    }
}
