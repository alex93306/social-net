package org.mycompany.controller;

import org.mycompany.service.AppUserService;
import org.mycompany.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendController {

    @Autowired private AppUserService appUserService;
    @Autowired private FriendService friendService;

    @PostMapping("/requestFriend")
    public String requestAddToFriend(Long friendAppUserID) {

        friendService.createFriend(friendAppUserID);

        return "redirect://friendList";
    }

    @GetMapping("/friendList")
    public ModelAndView friendListPage() {

        ModelAndView mav = new ModelAndView("friendList");
        mav.addObject("friends", friendService.getAllFriendsForCurrent());

        return mav;
    }
}
