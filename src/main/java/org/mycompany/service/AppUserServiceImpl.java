package org.mycompany.service;

import org.mycompany.dao.AppUserDAO;
import org.mycompany.dao.EmailVerificationTokenDAO;
import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired private AppUserDAO appUserDao;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private EmailVerificationTokenDAO emailVerificationTokenDao;

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
}
