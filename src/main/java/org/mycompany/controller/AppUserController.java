package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.mycompany.form.ChangePasswordForm;
import org.mycompany.form.RegisterForm;
import org.mycompany.manager.AppUserManager;
import org.mycompany.manager.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class AppUserController {

    private static final String FORGOT_PASSWORD_VIEW_NAME = "forgotPassword";
    private static final String LOGIN_VIEW_NAME = "login";
    private static final String REGISTER_USER_VIEW_NAME = "register";

    @Autowired
    private AppUserManager appUserManager;
    @Autowired
    private EmailManager emailManager;

    @GetMapping("/login")
    //todo:
    public String loginPage() {
        return LOGIN_VIEW_NAME;
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return REGISTER_USER_VIEW_NAME;
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid RegisterForm registerForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return REGISTER_USER_VIEW_NAME;
        }

        AppUser appUser = buildAppUser(registerForm);
        appUserManager.save(appUser);

        EmailVerificationToken verificationToken = appUserManager.createEmailVerificationToken(appUser);

        emailManager.sendVerificationEmail(appUser, verificationToken.getToken());

        return "waitEmailVerification";
    }

    @GetMapping("/verifyEmail/{token}")
    //todo: come up better name method and path variable
    public String verifyEmail(@PathVariable String token, BindingResult bindingResult) {

        EmailVerificationToken emailVerificationToken = null;
//                appUserManager.findEmailVerificationTokenByToken(verifyToken);

        if (emailVerificationToken == null) {
            //todo:
            return null;
        }
        if (emailVerificationToken.getExpiryDate().isAfter(LocalDateTime.now())) {
            //todo:
            return null;
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

    private AppUser buildAppUser(RegisterForm registerForm) {
        AppUser appUser = new AppUser();
        appUser.setEmail(registerForm.getEmail());
        //todo hash password
        appUser.setPassword(registerForm.getPassword());
        appUser.setFirstName(registerForm.getFirstName());
        appUser.setLastName(registerForm.getLastName());
        appUser.setBirthDate(registerForm.getBirthDate());
        appUser.setGender(registerForm.getGender());

        return appUser;
    }


}
