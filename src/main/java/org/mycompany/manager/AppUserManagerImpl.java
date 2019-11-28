package org.mycompany.manager;

import org.mycompany.dao.AppUserDao;
import org.mycompany.entity.AbstractToken;
import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AppUserManagerImpl implements AppUserManager {

    @Autowired
    private AppUserDao appUserDao;

    @Override
    public AppUser save(AppUser appUser) {
        return appUserDao.save(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserDao.findByUsername(username); //todo: replace with common method
    }

    @Override
    public AppUser find(long id) {
        return appUserDao.get(id);
    }

    @Override
    public AppUser findByEmail(String email) {
        //todo: implement
        return null;
    }

    @Override
    public AppUser findByPasswordResetToken(String uuid) {
        //todo: implement it
        return null;
    }

    @Override
    public EmailVerificationToken findEmailVerificationTokenByToken(String verifyToken) {
        //todo: implement
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
        emailVerificationToken.setToken(token);

        //todo: implement
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
