package com.np.solid.singleresponsibility.good;

public class LoanService {

    public void getLoanInterestInfo(String loanType) {
        if ("homeLoan".equals(loanType)) {
            //do some job
        }

        if ("personalLoan".equals(loanType)) {
            //do some job
        }

        if ("car".equals(loanType)) {
            //do some job
        }
    }
}