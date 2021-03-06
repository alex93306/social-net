package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.Gender;
import org.mycompany.form.ContactsInfoForm;
import org.mycompany.form.GeneralInfoForm;
import org.mycompany.service.AppUserService;
import org.mycompany.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    private static final String PROFILE_VIEW = "profile";
    private static final String EDIT_PROFILE_VIEW = "editProfile";

    protected AppUserService appUserService;
    protected LanguageService languageService;

    public ProfileController(AppUserService appUserService, LanguageService languageService) {
        this.appUserService = appUserService;
        this.languageService = languageService;
    }

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
    public ModelAndView showEditProfilePage(@RequestParam("sec") String section) {
//        if (section == null)
//            throw
        if (section.isEmpty()){

        } else if ("contacts".equals(section)) {

        }
        AppUser appUser = appUserService.getCurrentAppUser();

        return new ModelAndView(EDIT_PROFILE_VIEW).addObject(appUser);
    }

    @GetMapping("/ajaxEditGeneralInfo")
    public ModelAndView loadEditGeneralInfo() {
        AppUser currentUser = appUserService.getCurrentAppUser();

        ModelAndView mav = new ModelAndView("ajax/editGeneralInfo");

//        todo: type of field e.i. birthday
//        todo move to separate method
        GeneralInfoForm generalInfoForm = new GeneralInfoForm();
        generalInfoForm.setFirstName(currentUser.getFirstName());
        generalInfoForm.setLastName(currentUser.getLastName());
        generalInfoForm.setMaidenName(currentUser.getMaidenName());
        generalInfoForm.setGender(String.valueOf(currentUser.getGender().ordinal()));
        generalInfoForm.setMaritalStatus(String.valueOf(currentUser.getMaritalStatus().ordinal()));
        generalInfoForm.setBirthday(String.valueOf(currentUser.getBirthDate()));
        generalInfoForm.setHomeCity(currentUser.getHomeCity());

        generalInfoForm.setLanguage(String.valueOf(currentUser.getLanguages().get(0).getId()));

        mav.addObject("generalInfoForm", generalInfoForm);
        mav.addObject("languageOptions", languageService.getAllLanguages());

        return mav;
    }

    @PostMapping("/ajaxSaveGeneralInfo")
    public ModelAndView storeGeneralInfo(GeneralInfoForm form, BindingResult bindingResult) {
        //todo: validate
        if (bindingResult.hasErrors()) {
            return new ModelAndView("ajax/editGeneralInfo");
        }

        AppUser currentUser = appUserService.getCurrentAppUser();
        populateGeneralInfo(currentUser, form);

        appUserService.update(currentUser);

        ModelAndView mav = new ModelAndView("ajax/editGeneralInfo");
        mav.addObject("appUser", currentUser);
        mav.addObject("isSaved", true);

        return mav;
    }

    protected void populateGeneralInfo(AppUser appUser, GeneralInfoForm form) {
        appUser.setFirstName(form.getFirstName());
        appUser.setLastName(form.getLastName());

        Gender gender = Gender.valueOf(form.getGender());
        appUser.setGender(gender);

//        if (Gender.FEMALE.equals(gender)) {
//            appUser.setMaidenName(form.getMaidenName());
//        }

//        appUser.setMaritalStatus(MaritalStatus.valueOf(form.getMaritalStatus()));
//        appUser.setBirthDate(LocalDate.parse(form.getBirthday()));

        appUser.setHomeCity(form.getHomeCity());
    }

    @GetMapping("/ajaxEditContactsInfo")
    public ModelAndView loadEditContactsInfo() {
        //todo: maybe it's possible make general, i.e. use ?section=general
        AppUser currentUser = appUserService.getCurrentAppUser();

        ModelAndView mav = new ModelAndView("ajax/editContactsInfo");
        mav.addObject(currentUser);
        //todo;
        mav.addObject("genderOptions", Gender.values());

        return mav;
    }

    @PostMapping("/ajaxSaveContactsInfo")
    public ModelAndView storeContactsInfo(ContactsInfoForm form, BindingResult bindingResult) {
        AppUser currentUser = appUserService.getCurrentAppUser();
        populateContactsInfo(currentUser, form);

        appUserService.update(currentUser);

        ModelAndView mav = new ModelAndView("ajax/editContactsInfo");
        mav.addObject("appUser", currentUser);
        mav.addObject("isSaved", true);

        return mav;
    }

    protected void populateContactsInfo(AppUser appUser, ContactsInfoForm form) {
        appUser.setCountry(form.getCountry());
        appUser.setCity(form.getCity());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected class UserNotFoundException extends RuntimeException {
    }
}
