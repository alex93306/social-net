package org.mycompany.dao;

import org.mycompany.entity.EmailVerificationToken;

public interface EmailVerificationTokenDao {

    EmailVerificationToken findByToken(String token);

    EmailVerificationToken save(EmailVerificationToken emailVerificationToken);
}
