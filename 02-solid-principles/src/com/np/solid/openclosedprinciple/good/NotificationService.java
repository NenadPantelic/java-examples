package com.np.solid.openclosedprinciple.good;

public interface NotificationService {
    void sendOTP(String medium);

    void sendTransactionNotification(String medium);
}