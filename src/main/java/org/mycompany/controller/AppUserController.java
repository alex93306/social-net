package org.mycompany.controller;

import org.mycompany.dto.AppUserDTO;
import org.mycompany.dto.NewPasswordDTO;
import org.mycompany.entity.AppUser;
import org.mycompany.manager.AppUserManager;
import org.mycompany.manager.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class AppUserController {

    private static final String FORGOT_PASSWORD_VIEW_NAME = "forgotPassword";
    private static final String REGISTER_VIEW_NAME = "register";

    @Autowired
    private AppUserManager appUserManager;
    @Autowired
    private EmailManager emailManager;

    @GetMapping("/register")
    public String registerPage() {
        return REGISTER_VIEW_NAME;
    }

    @PostMapping("/register")
    public String createAccount(AppUserDTO appUserDTO, BindingResult bindingResult) {
        //todo: validate
        if (bindingResult.hasErrors()) {
            return REGISTER_VIEW_NAME;
        }

        AppUser appUser = new AppUser();
        appUser.setEmail(appUserDTO.getEmail());
        //todo hash password
        appUser.setPassword(appUserDTO.getPassword());
        appUser.setFirstName(appUserDTO.getFirstName());
        appUser.setLastName(appUserDTO.getLastName());
        appUser.setBirthDay(appUserDTO.getBirthDay());
        appUser.setGender(appUserDTO.getGender());

        // generate and set UUID. it will use for email verification and reset password
        //todo: shoud we check uuid or it's really unique. Should we check if it's exists. should we send other info beside uuid
        //todo: add expiration time
        //todo: maybe it needs to create additional entity verificationToken
        appUser.setUUID(UUID.randomUUID().toString());

        appUserManager.save(appUser);

        //todo send email
        emailManager.sendConfirmEmail(appUser);

        return "waitEmailVerification";
    }

    @GetMapping("/verify/{verifyKey}")
    public String verifyAccount(@PathVariable String verifyKey) {
        appUserManager.verifyAndActivateAccount(verifyKey);//todo: is verify key unique or it should find by id and check
        return null;
    }

    @GetMapping("/forgot_password")
    public String showPasswordRecoveryPage() {
        return FORGOT_PASSWORD_VIEW_NAME;
    }

    @PostMapping("/forgot_password")
    //todo: RequestParam does it need?
    //todo: default or empty email. think about it
    public String requestResetPassword(@RequestParam String email) {
//        if (email.isEmpty()) {
//            return ;
//        }
// todo: email validation

        AppUser appUser = appUserManager.findByEmail(email);
        //todo: maybe it's ok to set it during register and don't change it
        appUser.setUUID(UUID.randomUUID().toString());
        appUserManager.save(appUser);

        emailManager.sendResetPasswordEmail(appUser);
        return "waitResetPassword";
    }


    @GetMapping("/reset_password")
    public String newPasswordForm(@RequestParam("uuid") String uuid) {
        //todo: validate uuid
        AppUser appUser = appUserManager.findByUUID(uuid);
        if (appUser != null) {
            //todo: set uuid or email into form to find user then
            return "newPassword";
        } else {
            return FORGOT_PASSWORD_VIEW_NAME;
        }

        //todo: remove uuid or not????
    }

    @PostMapping("reset_password")
    public String resetPassword(NewPasswordDTO newPasswordDTO, BindingResult bindingResult) {
        //todo: validate dto
        if (bindingResult.hasErrors()) {
            return "newPassword";
        }

        AppUser appUser = appUserManager.findByUUID(newPasswordDTO.getUUID());
        //todo: hast password
        appUser.setPassword(newPasswordDTO.getPassword());

        appUserManager.save(appUser);

        emailManager.sendPasswordChangedEmail(appUser);
        //todo: authentificate user
        //todo: check redirect
        return "redirect://";
    }


}
