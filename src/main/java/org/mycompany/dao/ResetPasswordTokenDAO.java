package org.mycompany.dao;

import org.mycompany.entity.EmailVerificationToken;

public interface ResetPasswordTokenDAO {

    EmailVerificationToken findByToken(String token);

    EmailVerificationToken save(EmailVerificationToken emailVerificationToken);
}
