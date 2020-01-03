package org.mycompany.service;

import org.mycompany.dao.EmailVerificationTokenDAO;
import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService {

    @Autowired private EmailVerificationTokenDAO emailVerificationTokenDAO;

    @Override
    public EmailVerificationToken findByToken(String token) {
        return emailVerificationTokenDAO.findByToken(token);
    }

    @Override
    public EmailVerificationToken createToken(AppUser appUser) {
        EmailVerificationToken emailVerificationToken = new EmailVerificationToken();
        emailVerificationToken.setAppUser(appUser);

        LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
        emailVerificationToken.setExpiryDate(expiryDate);

        //todo: consider of hashing token. If db will be stoled, then it's easy to get password
        //todo: maybe it needs to check uniqueness of token
        String token = UUID.randomUUID().toString();
        emailVerificationToken.setToken(token);

        emailVerificationTokenDAO.save(emailVerificationToken);

        return  emailVerificationToken;
    }


    @Override
    public void save(EmailVerificationToken emailVerificationToken) {
        emailVerificationTokenDAO.save(emailVerificationToken);
    }

}
