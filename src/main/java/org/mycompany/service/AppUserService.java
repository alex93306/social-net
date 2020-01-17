package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;

public interface AppUserService {
    AppUser find(long id);

    AppUser findByEmail(String email);

    AppUser getCurrentAppUser();

    AppUser save(AppUser appUser);
}
