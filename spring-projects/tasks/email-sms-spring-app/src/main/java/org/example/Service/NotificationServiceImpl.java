package org.example.Service;

import org.example.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void notificationBySms(String phnNo) {
        notificationRepository.notificationBySms(phnNo);
    }

    @Override
    public void notificationByEmail(String emailId) {
        notificationRepository.notificationByEmail(emailId);
    }
}
