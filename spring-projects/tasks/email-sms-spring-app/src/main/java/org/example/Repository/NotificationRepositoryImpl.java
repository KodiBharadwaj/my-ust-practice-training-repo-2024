package org.example.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository{

    @Override
    public void notificationBySms(String phnNo) {
        System.out.println("Hello " + phnNo + ", You have recieved an sms");
    }

    @Override
    public void notificationByEmail(String emailId) {
        System.out.println("Hello " + emailId + ", You have recieved an email");
    }
}
