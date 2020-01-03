package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;

public interface AppUserService {

    AppUser save(AppUser appUser);

    AppUser find(long id);

    AppUser findByEmail(String email);
}
