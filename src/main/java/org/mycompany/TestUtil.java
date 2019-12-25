package org.mycompany;

import org.mycompany.manager.EmailManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestUtil {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("");
        EmailManager mailSender = (EmailManager) applicationContext.getBean("emailManagerImpl");
//        mailSender.sendResetPasswordEmail("alex93306@gmail.com");
    }
}
