package org.mycompany.manager;

import org.mycompany.entity.AppUser;

public interface AppUserManager {
    AppUser save(AppUser appUser);

    AppUser findByUsername(String username);

    void verifyAndActivateAccount(String verifyKey);

    AppUser find(long id);

    AppUser findByEmail(String email);

    AppUser findByUUID(String uuid);
}
