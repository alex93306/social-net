package org.mycompany.repository;

import org.mycompany.entity.EmailVerificationToken;
import org.springframework.data.repository.CrudRepository;

public interface EmailVerificationTokenRepository extends CrudRepository<EmailVerificationToken, Long> {

    EmailVerificationToken findByToken(String token);
}
