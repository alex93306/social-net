package org.mycompany.repository;

import org.mycompany.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByEmail(String email);
}
