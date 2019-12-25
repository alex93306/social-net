package org.mycompany.entity;

import javax.persistence.Id;
import java.time.LocalDateTime;

//todo: name
//@Entity
public abstract class AbstractToken {

    @Id
    private Long id;
    private LocalDateTime expiryDate;
    //todo: come up better name
    private String token;

    private AppUser appUser;

    //todo:
    private LocalDateTime created = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
