package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.Friend;
import org.mycompany.entity.FriendshipStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired private AppUserService appUserService;

    @Override
    public Friend createFriend(Long friendAppUserID) {
        AppUser currentAppUser = appUserService.getCurrentAppUser();
        AppUser friendAppUser = appUserService.find(friendAppUserID);

        Friend friend = new Friend();
        friend.setAppUser(currentAppUser);
        friend.setFriendUser(friendAppUser);
        friend.setFriendshipStatus(FriendshipStatus.REQUEST);

        return save(friend);
    }

    @Override
    public Friend save(Friend friend) {
        return null;
    }
}
