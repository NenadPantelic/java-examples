package com.np.solid.dependencyinversion.bad;

public class CreditCard {

    public void doTransaction(int amount) {
        System.out.println("tx done with CreditCard");
    }
}