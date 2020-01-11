package org.mycompany.service;

import org.mycompany.dao.AppUserDAO;
import org.mycompany.dao.EmailVerificationTokenDAO;
import org.mycompany.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
    public List<AppUser> findAll() {
        AppUser appUser1 = new AppUser();
        appUser1.setId(1L);
        appUser1.setFirstName("alex");
        appUser1.setLastName("romanovich");

        AppUser appUser2 = new AppUser();
        appUser2.setId(2L);
        appUser2.setFirstName("bob");
        appUser2.setLastName("Marlie");

        return Arrays.asList(appUser1, appUser2);
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
