package org.mycompany.service;

import org.mycompany.entity.AppUser;

public interface AppUserService {
    AppUser find(long id);

    AppUser findByEmail(String email);

    AppUser getCurrentAppUser();

    AppUser save(AppUser appUser);
}
