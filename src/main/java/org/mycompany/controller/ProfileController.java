package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.Gender;
import org.mycompany.entity.MaritalStatus;
import org.mycompany.form.GeneralInfoForm;
import org.mycompany.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    private static final String PROFILE_VIEW = "profile";
    private static final String EDIT_PROFILE_VIEW = "editProfile";

    @Autowired private AppUserService appUserService;

    @GetMapping(value = {"/", "/profile/**"})
    public ModelAndView homePage() {
        AppUser appUser = appUserService.getCurrentAppUser();
        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping(value = {"/profile/**"}, params = {"id"})
    public ModelAndView showUserProfileByID(@RequestParam long id) {
        AppUser appUser = appUserService.find(id);

        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/profile/{username}")
    public ModelAndView showUserProfileByUsername(@PathVariable String username) {
        AppUser appUser = appUserService.findByEmail(username);
        if (appUser == null) {
            throw new UserNotFoundException();
        }

        return new ModelAndView(PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/editProfile")
    public ModelAndView showEditProfilePage() {
        AppUser appUser = appUserService.getCurrentAppUser();

        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/ajaxEditGeneralInfo")
    public ModelAndView loadEditGeneralInfo() {
        AppUser currentUser = appUserService.getCurrentAppUser();

        ModelAndView mav = new ModelAndView("ajax/editGeneralInfo");
        mav.addObject(currentUser);

        return mav;
    }

    @GetMapping("/ajaxEditContactsInfo")
    public ModelAndView loadEditContactsInfo() {
        //todo: maybe it's possible make general, i.e. use ?section=general
        AppUser currentUser = appUserService.getCurrentAppUser();

        ModelAndView mav = new ModelAndView("ajax/editGeneralInfo");
        mav.addObject(currentUser);

        return mav;
    }

    @PostMapping("/saveGeneralInfo")
    public String storeGeneralInfo(GeneralInfoForm form, BindingResult bindingResult) {
        //todo: validate
        if (bindingResult.hasErrors()) {
            return "editProfile";
        }

        AppUser currentUser = appUserService.getCurrentAppUser();
        populateGeneralInfo(currentUser, form);

        appUserService.save(currentUser);

        return "redirect://editProfile";
    }

    protected void populateGeneralInfo(AppUser appUser, GeneralInfoForm form) {
        appUser.setFirstName(form.getFirstName());
        appUser.setLastName(form.getLastName());

        Gender gender = Gender.valueOf(form.getGender());
        appUser.setGender(gender);

        if (Gender.FEMALE.equals(gender)) {
            appUser.setMaidenName(form.getMaidenName());
        }

        appUser.setMaritalStatus(MaritalStatus.valueOf(form.getMaritalStatus()));
        appUser.setBirthDate(LocalDate.parse(form.getBirthday()));
    }

    @PostMapping("/saveContactInfo")
    public ModelAndView storeContactsInfo(AppUser appUser) {
        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected class UserNotFoundException extends RuntimeException {
    }
}
