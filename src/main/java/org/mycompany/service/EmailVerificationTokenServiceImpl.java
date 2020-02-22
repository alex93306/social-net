package org.mycompany.service;

import org.mycompany.repository.EmailVerificationTokenRepository;
import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService {

    private EmailVerificationTokenRepository emailVerificationTokenRepository;

    public EmailVerificationTokenServiceImpl(EmailVerificationTokenRepository emailVerificationTokenRepository) {
        this.emailVerificationTokenRepository = emailVerificationTokenRepository;
    }

    @Override
    public EmailVerificationToken findByToken(String token) {
        return emailVerificationTokenRepository.findByToken(token);
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

        emailVerificationTokenRepository.save(emailVerificationToken);

        return  emailVerificationToken;
    }


    @Override
    public void save(EmailVerificationToken emailVerificationToken) {
        emailVerificationTokenRepository.save(emailVerificationToken);
    }

}
