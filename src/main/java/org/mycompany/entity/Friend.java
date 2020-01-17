package org.mycompany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friend {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private AppUser friendUser;

    private FriendshipStatus friendshipStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppUser getFriendUser() {
        return friendUser;
    }

    public void setFriendUser(AppUser friendUser) {
        this.friendUser = friendUser;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }
}
