package org.example.Repository;

public interface NotificationRepository {

     public void notificationBySms(String phnNo);

     public void notificationByEmail(String emailId);
}
