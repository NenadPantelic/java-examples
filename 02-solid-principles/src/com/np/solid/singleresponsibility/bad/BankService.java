package com.np.solid.singleresponsibility.bad;

// SRP: a class should have only one reason to change
// Problem: this class has multiple responsibilities - has a multiple reasons to change
public class BankService {

    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withdraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }

    public void printPassbook() {
        //update transaction info in passbook
    }

    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }

    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }

}