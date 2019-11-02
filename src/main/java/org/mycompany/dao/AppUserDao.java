package org.mycompany.dao;

import org.mycompany.entity.AppUser;

public interface AppUserDao {
    AppUser get(Long id);
    AppUser save(AppUser appUser);
    void update(AppUser appUser);
    void remove(Long id);

    AppUser findByUsername(String username);

    AppUser findByVerifyKey(String verifyKey);
}
