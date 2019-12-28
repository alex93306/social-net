package org.mycompany.service;

import org.mycompany.dao.AppUserDAO;
import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserDAO appUserDao;
//
//    @Autowired
//    private EmailVerificationTokenDAO emailVerificationTokenDao;

    @Override
    public AppUser save(AppUser appUser) {
        return appUserDao.save(appUser);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserDao.findByEmail(email);
    }

    @Override
    public AppUser find(long id) {
        //todo: implement
//        return appUserDao.get(id);
        return new AppUser();
    }

    @Override
    public AppUser findByPasswordResetToken(String uuid) {
        //todo: implement it
        return new AppUser();
    }

    @Override
    public EmailVerificationToken findEmailVerificationTokenByToken(String token) {
//        return  emailVerificationTokenDao.findByToken(token);
        return null;
    }


    @Override
    public EmailVerificationToken createEmailVerificationToken(AppUser appUser) {
        EmailVerificationToken emailVerificationToken = new EmailVerificationToken();
        emailVerificationToken.setAppUser(appUser);
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
        emailVerificationToken.setExpiryDate(expiryDate);
        String token = UUID.randomUUID().toString();
        //todo: hash token
        //todo: should we check token for unique
        emailVerificationToken.setToken(token);

//        emailVerificationTokenDao.save(emailVerificationToken);

        return emailVerificationToken;
    }

    @Override
    public ResetPasswordToken createResetPasswordToken(AppUser appUser) {
        ResetPasswordToken resetPasswordToken = new ResetPasswordToken();
        resetPasswordToken.setAppUser(appUser);
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
        resetPasswordToken.setExpiryDate(expiryDate);
        String token = UUID.randomUUID().toString();
        //todo: hash token
        resetPasswordToken.setToken(token);

        //todo: implement
//        emailVerificationTokenDao.save(emailVerificationToken);

        return resetPasswordToken;
    }
}
