package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.manager.AppUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class ProfileController {
    private static final String PROFILE_VIEW = "profile";
    private static final String EDIT_PROFILE_VIEW = "editProfile";

    @Autowired
    private AppUserManager appUserManager;

    @GetMapping("/")
    public ModelAndView homePage() {
        AppUser appUser = loadUser(); //todo: get current user
        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping(path = "/", params = {"id"})
    public ModelAndView showUserProfileByID(@RequestParam long ID) {
        AppUser appUser = appUserManager.find(ID);

        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/{username}")
    public ModelAndView showUserProfile(@PathVariable String username) {
        AppUser appUser = appUserManager.findByEmail(username);

        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/editProfile")
    public ModelAndView showEditProfilePage() {
        AppUser appUser = loadUser();
        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
    }

    @PostMapping("/editProfile")
    public ModelAndView storeEditedProfile(AppUser appUser) {
        //todo:
        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
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
