package org.example.model;

import org.example.Repository.NotificationRepository;
import org.example.Repository.NotificationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Phone {

    @Autowired
    private Network network;

    NotificationRepository notification = new NotificationRepositoryImpl();
    public void smsNotification(String phnNo){
        if(network.isAvailable()){
            notification.notificationBySms(phnNo);
        }
        else{
            System.out.println("You don't have proper signal");
        }
    }

    public void emailNotification(String emailId){
        if(network.isAvailable()){
            notification.notificationByEmail(emailId);
        }
        else{
            System.out.println("You are not connected to the internet");
        }
    }
}
