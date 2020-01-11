package org.mycompany.service;

import org.mycompany.entity.AppUser;
import java.util.List;

public interface AppUserService {

    AppUser getCurrentAppUser();

    AppUser find(long id);

    List<AppUser> findAll();

    AppUser findByEmail(String email);

    AppUser save(AppUser appUser);
}
