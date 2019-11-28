package org.mycompany.controller;

import org.mycompany.form.ChangePasswordForm;
import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.mycompany.form.NewUserForm;
import org.mycompany.manager.AppUserManager;
import org.mycompany.manager.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class AppUserController {

    private static final String FORGOT_PASSWORD_VIEW_NAME = "forgotPassword";
    private static final String LOGIN_VIEW_NAME = "login";
    private static final String REGISTER_VIEW_NAME = "register";

    @Autowired
    private AppUserManager appUserManager;
    @Autowired
    private EmailManager emailManager;

    @GetMapping("/login")
    public String loginPage() {
        return LOGIN_VIEW_NAME;
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("newUserForm", new NewUserForm());
        return REGISTER_VIEW_NAME;
    }

    @PostMapping("/register")
    public String createAccount(@Valid NewUserForm newUserForm, BindingResult bindingResult) {
        //todo: validate
        if (bindingResult.hasErrors()) {
            return REGISTER_VIEW_NAME;
        }

        AppUser appUser = new AppUser();
        appUser.setEmail(newUserForm.getEmail());
        //todo hash password
        appUser.setPassword(newUserForm.getPassword());
        appUser.setFirstName(newUserForm.getFirstName());
        appUser.setLastName(newUserForm.getLastName());
        appUser.setBirthDate(newUserForm.getBirthDate());
        appUser.setGender(newUserForm.getGender());

        // generate and set UUID. it will use for email verification and reset password
        //todo: shoud we check uuid or it's really unique. Should we check if it's exists. should we send other info beside uuid

        appUserManager.save(appUser);

        EmailVerificationToken verificationToken = appUserManager.createEmailVerificationToken(appUser);

        //todo send email
        emailManager.sendVerificationEmail(appUser, verificationToken.getToken());

        return "waitEmailVerification";
    }

    @GetMapping("/verify-email/{verifyToken}")
    //todo: come up better name method and path variable
    public String verifyEmail(@PathVariable String verifyToken, BindingResult errors) {

        EmailVerificationToken emailVerificationToken = appUserManager.findEmailVerificationTokenByToken(verifyToken);

        if (emailVerificationToken == null) {
            //todo:
            return  null;
        }
        if (emailVerificationToken.getExpiryDate().isAfter(LocalDateTime.now())) {
            //todo:
            return  null;
        }

        AppUser appUser = emailVerificationToken.getAppUser();
        appUser.setActive(true);
        appUserManager.save(appUser);

        //todo: remove or inactivate token ???
        //todo: authentificate user

        return "redirect://";
    }

    @GetMapping("/forgotPassword")
    public String forgotPasswordPage() {
        return FORGOT_PASSWORD_VIEW_NAME;
    }

    @PostMapping("/forgotPassword")
    public String requestResetPassword(@RequestParam String email) {
        //todo: validate email

        //todo: capture

//        AppUser appUser = appUserManager.findByEmail(email);
        AppUser appUser = new AppUser();
        appUser.setEmail("alex93306@gmail.com");

        //todo: null or exception
//        if (appUser == null) {
//            throw new RuntimeException("UserNotFound");
//        }

        ResetPasswordToken resetPasswordToken = appUserManager.createResetPasswordToken(appUser);

        emailManager.sendResetPasswordEmail(appUser, resetPasswordToken.getToken());

        return "waitResetPassword";
    }

    @GetMapping("/resetPassword")
    public String newPasswordForm(@RequestParam("token") String token, Model model) {
        AppUser appUser = appUserManager.findByPasswordResetToken(token);
        if (appUser == null) {
//            return FORGOT_PASSWORD_VIEW_NAME;
            //todo:
            throw new RuntimeException("UserNotFound");
        }
        //todo: invalidate token???
        //todo: model attribute
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
        changePasswordForm.setEmail(appUser.getEmail());
        model.addAttribute("newPasswordForm", changePasswordForm);
        return "newPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(ChangePasswordForm changePasswordForm, BindingResult bindingResult) {
        //todo: validate dto
        //todo: capture
        if (bindingResult.hasErrors()) {
            return "newPassword";
        }

        AppUser appUser = appUserManager.findByEmail(changePasswordForm.getEmail());
        //todo: hast password
        appUser.setPassword(changePasswordForm.getNewPassword());

//        appUserManager.save(appUser);

        emailManager.sendPasswordChangedEmail(appUser);
        //todo: authentificate user
        //todo: redirect constance and check
        return "redirect://";
    }


}
