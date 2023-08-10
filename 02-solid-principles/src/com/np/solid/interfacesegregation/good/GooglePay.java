package com.np.solid.interfacesegregation.good;

public class GooglePay implements UPIPayment, CashbackManager {

    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {

    }
}
