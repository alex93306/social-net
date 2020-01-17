package org.mycompany.service;

import org.mycompany.entity.Friend;

public interface FriendService {

    Friend createFriend(Long friendAppUserID);

    Object getAllFriendsForCurrent();

    Friend save(Friend friend);
}
