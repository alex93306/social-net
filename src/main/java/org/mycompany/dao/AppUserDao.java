package org.mycompany.dao;

import org.mycompany.entity.AppUser;

public interface AppUserDao {

    AppUser find(Long id);

    AppUser findByEmail(String email);

    AppUser findByVerificationToken(String token);

    AppUser findByResetPasswordToken(String token);

    AppUser save(AppUser appUser);

    AppUser update(AppUser appUser);
}
