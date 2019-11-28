package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.manager.AppUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class ProfileController {
    private static final String PROFILE_VIEWNAME = "profile";
    private static final String EDIT_PROFILE_VIEWNAME = "editProfile";

    @Autowired
    private AppUserManager appUserManager;

    @GetMapping("/")
    public ModelAndView homePage() {
        AppUser appUser = loadUser(); //todo: get current user
        return new ModelAndView(PROFILE_VIEWNAME).addObject(appUser);
    }

    @GetMapping(path = "/", params = {"id"})
    public ModelAndView showUserProfileByID(@RequestParam long id) {
        AppUser appUser = appUserManager.find(id);

        return new ModelAndView(PROFILE_VIEWNAME).addObject(appUser);
    }

    @GetMapping("/{username}")
    public ModelAndView showUserProfile(@PathVariable String username) {
        AppUser appUser = appUserManager.findByUsername(username);

        return new ModelAndView(PROFILE_VIEWNAME).addObject(appUser);
    }

    @GetMapping("/editprofile")
    public ModelAndView showEditProfile() {
        AppUser appUser = loadUser();
        return new ModelAndView(EDIT_PROFILE_VIEWNAME).addObject(appUser);
    }

    @PostMapping("/editprofile")
    public ModelAndView storeEditedProfile(AppUser appUser) {
        //todo:
        return new ModelAndView(EDIT_PROFILE_VIEWNAME).addObject(appUser);
    }

    private AppUser loadUser() {
        AppUser appUser = new AppUser();
        appUser.setFirstName("alex");
        appUser.setLastName("Romanovich");
        appUser.setBirthDate(LocalDate.now());
        appUser.setCity("Minsk");
        appUser.setEducation("BSUIR");
        appUser.setAbout("I'm the bad guy.");

        return appUser;
    }


}
