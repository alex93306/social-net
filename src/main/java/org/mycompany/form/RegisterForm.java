package org.mycompany.form;

import org.hibernate.validator.constraints.Length;
import org.mycompany.entity.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RegisterForm {

    @Email
    @NotEmpty(message = "{error.email.notEmpty}")
    private String email;

    @NotEmpty
    @Length(min = 8, max = 30)
    //todo: password strength
    private String password;

    @NotEmpty
    @Length(min = 8, max = 30)
    //todo: match
    private String repeatPassword;

    @NotEmpty
    //todo: length control
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //todo: isn't future
    //todo: incorrect format
    private LocalDate birthDate;

    @NotNull
    //todo: invalide value for enum. now we have exception
    private Gender gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
