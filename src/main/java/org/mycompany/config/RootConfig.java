package org.mycompany.config;

import org.mycompany.controller.AppUserController;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import java.util.Collections;
import java.util.Properties;

@Configuration
//todo: should properties be in package
@PropertySource("classpath:/email.properties")
public class RootConfig {

    @Bean
    public MailSender mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));

        Properties props = new Properties();
        props.put("mail.smtp.auth", env.getProperty("mail.properties.mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", env.getProperty("mail.properties.mail.smtp.starttls.enable"));

        mailSender.setJavaMailProperties(props);

        return mailSender;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setBasename("messages");

        return messageSource;
    }

}
