package org.mycompany.controller;

import org.mycompany.dto.AppUserDTO;
import org.mycompany.entity.AppUser;
import org.mycompany.manager.AppUserManager;
import org.mycompany.manager.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class AppUserController {

    @Autowired
    private AppUserManager appUserManager;
    @Autowired
    private EmailManager emailManager;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView createAccount(AppUserDTO appUserDTO, BindingResult bindingResult) {
        //todo: validate
//        if (bindingResult.hasErrors()) {
//            return
//        }
        //todo hash password

        AppUser appUser = new AppUser();
        appUser.setEmail(appUserDTO.getEmail());
        appUser.setPassword(appUserDTO.getPassword());
        appUser.setFirstName(appUserDTO.getFirstName());
        appUser.setLastName(appUserDTO.getLastName());
        appUser.setBirthDay(appUserDTO.getBirthDay());
        appUser.setGender(appUserDTO.getGender());

        appUserManager.save(appUser);

        //todo send email
        emailManager.sendConfirmMail(appUser.getEmail(), UUID.randomUUID().toString());

        return new ModelAndView();
    }

    @GetMapping("/verify/{verifyKey}")
    public String verifyAccount(@PathVariable String verifyKey) {
        appUserManager.verifyAndActivateAccount(verifyKey);//todo: is verify key unique or it should find by id and check
        return null;
    }


}
