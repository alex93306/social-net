package org.mycompany.service;

import org.mycompany.repository.AppUserRepository;
import org.mycompany.entity.AppUser;
import org.mycompany.service.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser find(long id) {
        //todo: orElse
        return appUserRepository.findById(id).orElse(null);
    }

    @Override
    public AppUser findByEmail(String email) {
        //todo:
        return appUserRepository.findByEmail(email);
    }

    @Override
    public AppUser getCurrentAppUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();

        return findByEmail(principal.getUsername());
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserDao.update(appUser);
    }
}
