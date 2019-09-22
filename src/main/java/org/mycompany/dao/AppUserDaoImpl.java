package org.mycompany.dao;

import org.mycompany.entity.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    @Override
    public AppUser get(Long id) {
        return null;
    }

    @Override
    public Long save(AppUser appUser) {
        return null;
    }

    @Override
    public void update(AppUser appUser) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public AppUser findByUsername(String username) {
        return null;
    }

    @Override
    public AppUser findByVerifyKey(String verifyKey) {
        return null;
    }
}
