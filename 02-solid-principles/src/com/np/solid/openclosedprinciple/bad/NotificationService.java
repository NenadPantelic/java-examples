package com.np.solid.openclosedprinciple.bad;

// software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification ->
// you should be able to extend a class behavior, without modifying it
// Problem: hard to extend without modification
public class NotificationService {

    public void sendOTP(String medium) {
        if ("email".equals(medium)) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}