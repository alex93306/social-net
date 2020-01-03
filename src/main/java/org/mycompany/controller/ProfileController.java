package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.service.AppUserService;
import org.mycompany.service.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired private AppUserService appUserService;

    @GetMapping("/")
    public ModelAndView homePage() {
        AppUser appUser = getCurrentApplicationUser();
        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping(path = "/", params = {"id"})
    public ModelAndView showUserProfileByID(@RequestParam long ID) {
        AppUser appUser = appUserService.find(ID);

        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/{username}")
    public ModelAndView showUserProfile(@PathVariable String username) {
        AppUser appUser = appUserService.findByEmail(username);

        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/editProfile")
    public ModelAndView showEditProfilePage() {
        AppUser appUser = getCurrentApplicationUser();

        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
    }

    @PostMapping("/editProfile")
    public ModelAndView storeEditedProfile(AppUser appUser) {
        //todo:
        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
    }

    protected AppUser getCurrentApplicationUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();

        return appUserService.find(principal.getAppUserID());
    }
}
