package org.example;

import org.example.configuration.AppConfig;
import org.example.model.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Phone phone = context.getBean(Phone.class);
        String phnNo = "9381153612";
        phone.smsNotification(phnNo);
        String emailId = "Bharadwaj.Kodi@ust.com";
        phone.emailNotification(emailId);
    }
}
