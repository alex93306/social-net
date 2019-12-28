package org.mycompany;

import org.mycompany.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestUtil {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("");
        EmailService mailSender = (EmailService) applicationContext.getBean("emailServiceImpl");
//        mailSender.sendResetPasswordEmail("alex93306@gmail.com");
    }
}
