package org.mycompany.manager;

import org.mycompany.dao.AppUserDao;
import org.mycompany.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

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
    public void verifyAndActivateAccount(String verifyKey) {
        AppUser appUser = appUserDao.findByVerifyKey(verifyKey);
        if (appUser == null) {
            throw new RuntimeException("Account can't be activated, because verify key isn't valid");
        }

        if (!appUser.isActive()) {
            appUser.setActive(true);
            appUserDao.save(appUser);
        }
    }

    @Override
    public AppUser find(long id) {
        return appUserDao.get(id);
    }
}
