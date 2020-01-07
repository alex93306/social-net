package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.EmailVerificationToken;
import org.mycompany.entity.ResetPasswordToken;
import org.mycompany.form.ChangePasswordForm;
import org.mycompany.form.RegisterForm;
import org.mycompany.service.AppUserService;
import org.mycompany.service.EmailService;
import org.mycompany.service.EmailVerificationTokenService;
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
    private static final String WAIT_CONFIRM_EMAIL_VIEW = "waitConfirmEmail";

    @Autowired private AppUserService appUserService;
    @Autowired private EmailVerificationTokenService emailVerificationTokenService;
    @Autowired private EmailService emailService;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return LOGIN_VIEW;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return REGISTER_USER_VIEW;
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid RegisterForm registerForm, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return REGISTER_USER_VIEW;
        }

        //todo: catpature?
        //todo: prevent from double submition
        AppUser appUser = buildAppUser(registerForm);
        appUserService.save(appUser);

        EmailVerificationToken verificationToken = emailVerificationTokenService.createToken(appUser);

        emailService.sendVerificationEmail(appUser, verificationToken.getToken());

        model.addAttribute(appUser);
        //todo: prevent double submittion after F5. apply Post/Redirect/Get pattern
        //todo: add logging
        return WAIT_CONFIRM_EMAIL_VIEW;
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

        // User is inactive till he confirms email.
        appUser.setActive(false);

        String encodedPassword = passwordEncoder.encode(registerForm.getPassword());
        appUser.setPassword(encodedPassword);

        return appUser;
    }

    @GetMapping("/confirmEmail/{token}")
    public String confirmEmail(@PathVariable String token) {

        EmailVerificationToken emailVerificationToken = emailVerificationTokenService.findByToken(token);

        if (emailVerificationToken == null || emailVerificationToken.getExpiryDate().isAfter(LocalDateTime.now())) {
            //todo:
            return "redirect://badlink";
        }

        AppUser appUser = emailVerificationToken.getAppUser();
        appUser.setActive(true);
        appUserService.save(appUser);

        // Deactivate token after use it
        emailVerificationToken.setUsed(true);
        emailVerificationTokenService.save(emailVerificationToken);

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

//        ResetPasswordToken resetPasswordToken = appUserService.createResetPasswordToken(appUser);
//
//        emailService.sendResetPasswordEmail(appUser, resetPasswordToken.getToken());

        return "waitResetPassword";
    }

    @GetMapping("/resetPassword")
    public String newPasswordForm(@RequestParam("token") String token, Model model) {
        //todo: replace
        EmailVerificationToken emailVerificationToken = emailVerificationTokenService.findByToken(token);
        if (emailVerificationToken == null || emailVerificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
//            return FORGOT_PASSWORD_VIEW;
            //todo:
            throw new RuntimeException("UserNotFound");
        }

        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
        changePasswordForm.setEmail(emailVerificationToken.getAppUser().getEmail());
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
