package org.mycompany.service;

import org.mycompany.dao.AppUserDAO;
import org.mycompany.dao.EmailVerificationTokenDAO;
import org.mycompany.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired private AppUserDAO appUserDao;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private EmailVerificationTokenDAO emailVerificationTokenDao;

    @Override
    public AppUser getCurrentAppUser() {
        //todo:
        return new AppUser();
    }

    @Override
    public AppUser find(long id) {
        //todo: implement
//        return appUserDao.get(id);
        return new AppUser();
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserDao.findByEmail(email);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserDao.save(appUser);
    }
}
