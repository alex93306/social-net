package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;

public interface EmailVerificationTokenService {

    EmailVerificationToken findByToken(String token);

    EmailVerificationToken createToken(AppUser appUser);

    void save(EmailVerificationToken emailVerificationToken);
}
