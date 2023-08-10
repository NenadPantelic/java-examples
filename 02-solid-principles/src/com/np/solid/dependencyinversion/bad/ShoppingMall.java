package com.np.solid.dependencyinversion.bad;

// The principle states that we must use abstraction (abstract classes and interfaces) instead of concrete
// implementations. High-level modules should not depend on the low-level module but both should depend on the abstraction
public class ShoppingMall {

    private final DebitCard debitCard;

    public ShoppingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void doPayment(Object order, int amount) {
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(debitCard);
        shoppingMall.doPayment("some order", 5000);
    }
}