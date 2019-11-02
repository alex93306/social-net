package org.mycompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import java.util.Collections;
import java.util.Properties;

@Configuration
//todo: should properties be in package
@PropertySource("classpath:/email.properties")
@ComponentScan(basePackages = {"org.mycompany.controller", "org.mycompany.dao", "org.mycompany.manager"})
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


//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//        emfb.setPersistenceUnitName("socialPU");
//        return emfb;
//    }
}
