package org.mycompany.service;

import org.mycompany.dao.AppUserDAO;
import org.mycompany.entity.AppUser;
import org.mycompany.service.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired private AppUserDAO appUserDao;

    @Override
    public AppUser find(long id) {
        return appUserDao.find(id);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserDao.findByEmail(email);
    }

    @Override
    public AppUser getCurrentAppUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();

        return findByEmail(principal.getUsername());
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserDao.save(appUser);
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserDao.update(appUser);
    }
}
