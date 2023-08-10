package com.np.solid.interfacesegregation.bad;

public class Paytm implements UPIPayment {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {
        // not applicable
    }
}
