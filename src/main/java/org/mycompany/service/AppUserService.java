package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
public interface AppUserService {

    AppUser getCurrentAppUser();

    AppUser find(long id);

    AppUser findByEmail(String email);

    AppUser save(AppUser appUser);
}
