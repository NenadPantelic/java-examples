package com.np.solid.singleresponsibility.good;

public class NotificationService {

    public void sendOTP(String medium) {
        if ("email".equals(medium)) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}