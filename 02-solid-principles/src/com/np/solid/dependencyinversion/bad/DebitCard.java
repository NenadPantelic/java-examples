package com.np.solid.dependencyinversion.bad;

public class DebitCard {

    public void doTransaction(int amount) {
        System.out.println("tx done with DebitCard");
    }
}