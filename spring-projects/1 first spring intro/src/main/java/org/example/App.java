package org.example;

import org.example.beans.Phone;
import org.example.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Phone phone = context.getBean(Phone.class);
        String phnNo = "9381153612";
        phone.call(phnNo);
        phone.sendText(phnNo,"You have received the message");
    }
}
