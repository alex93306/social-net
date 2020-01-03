package org.mycompany.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class Principal extends User {
    protected Long appUserID;

    public Principal(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Long getAppUserID() {
        return appUserID;
    }

    public void setAppUserID(Long appUserID) {
        this.appUserID = appUserID;
    }
}
