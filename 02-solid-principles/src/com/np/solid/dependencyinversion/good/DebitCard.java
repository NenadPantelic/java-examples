package com.np.solid.dependencyinversion.good;

public class DebitCard implements BankCard {

    public void doTransaction(int amount) {
        System.out.println("tx done with DebitCard");
    }
}