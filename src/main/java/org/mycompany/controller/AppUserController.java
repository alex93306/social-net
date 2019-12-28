package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.mycompany.form.ChangePasswordForm;
import org.mycompany.form.RegisterForm;
import org.mycompany.service.AppUserService;
import org.mycompany.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static final String FORGOT_PASSWORD_VIEW = "forgotPassword";
    private static final String LOGIN_VIEW = "login";
    private static final String REGISTER_USER_VIEW = "register";

    @Autowired private AppUserService appUserService;
    @Autowired private EmailService emailService;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return LOGIN_VIEW;
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return REGISTER_USER_VIEW;
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid RegisterForm registerForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return REGISTER_USER_VIEW;
        }

        AppUser appUser = buildAppUser(registerForm);
        appUserService.save(appUser);

        EmailVerificationToken verificationToken = appUserService.createEmailVerificationToken(appUser);

        emailService.sendVerificationEmail(appUser, verificationToken.getToken());

        return "waitEmailVerification";
    }

    /**
     * Helper method, which ac
     * @param registerForm
     * @return
     */
    private AppUser buildAppUser(RegisterForm registerForm) {
        AppUser appUser = new AppUser();
        appUser.setEmail(registerForm.getEmail());
        appUser.setFirstName(registerForm.getFirstName());
        appUser.setLastName(registerForm.getLastName());
        appUser.setBirthDate(registerForm.getBirthDate());
        appUser.setGender(registerForm.getGender());

        // User is inactive till he confirm email.
        appUser.setActive(false);

        String encodedPassword = passwordEncoder.encode(registerForm.getPassword());
        appUser.setPassword(encodedPassword);

        return appUser;
    }

    @GetMapping("/verifyEmail/{token}")
    //todo: come up better name method and path variable
    public String verifyEmail(@PathVariable String token, BindingResult bindingResult) {

        EmailVerificationToken emailVerificationToken = null;
//                appUserService.findEmailVerificationTokenByToken(verifyToken);

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
        appUserService.save(appUser);

        //todo: remove or inactivate token ???
        //todo: authentificate user

        return "redirect://";
    }

    @GetMapping("/forgotPassword")
    public String forgotPasswordPage() {
        return FORGOT_PASSWORD_VIEW;
    }

    @PostMapping("/forgotPassword")
    public String requestResetPassword(@RequestParam String email) {
        //todo: validate email

        //todo: capture

//        AppUser appUser = appUserService.findByEmail(email);
        AppUser appUser = new AppUser();
        appUser.setEmail("alex93306@gmail.com");

        //todo: null or exception
//        if (appUser == null) {
//            throw new RuntimeException("UserNotFound");
//        }

        ResetPasswordToken resetPasswordToken = appUserService.createResetPasswordToken(appUser);

        emailService.sendResetPasswordEmail(appUser, resetPasswordToken.getToken());

        return "waitResetPassword";
    }

    @GetMapping("/resetPassword")
    public String newPasswordForm(@RequestParam("token") String token, Model model) {
        AppUser appUser = appUserService.findByPasswordResetToken(token);
        if (appUser == null) {
//            return FORGOT_PASSWORD_VIEW;
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

        AppUser appUser = appUserService.findByEmail(changePasswordForm.getEmail());
        //todo: hast password
        appUser.setPassword(changePasswordForm.getNewPassword());

//        appUserService.save(appUser);

        emailService.sendPasswordChangedEmail(appUser);
        //todo: authentificate user
        //todo: redirect constance and check
        return "redirect://";
    }
}
