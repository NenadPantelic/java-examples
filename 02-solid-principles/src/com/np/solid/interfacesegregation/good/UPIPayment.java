package com.np.solid.interfacesegregation.good;

// do not force any client to implement an interface which is irrelevant to them
public interface UPIPayment {

    void payMoney();

    void getScratchCard();
}
