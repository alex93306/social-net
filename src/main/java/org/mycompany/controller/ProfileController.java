package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.manager.AppUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    @Autowired
    private AppUserManager appUserManager;

    @GetMapping("/")
    public ModelAndView homePage() {
        AppUser appUser = null; //todo: get current user

        return new ModelAndView("profile").addObject(appUser);
    }

    @GetMapping(path = "/", params = {"id"})
    public ModelAndView showUserProfileByID(@RequestParam long id) {
        AppUser appUser = appUserManager.find(id);

        return new ModelAndView("profile").addObject(appUser);
    }

    @GetMapping("/{username}")
    public ModelAndView showUserProfile(@PathVariable String username) {
        AppUser appUser = appUserManager.findByUsername(username);

        return new ModelAndView("profile").addObject(appUser);
    }


}
