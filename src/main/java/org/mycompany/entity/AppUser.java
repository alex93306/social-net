package org.mycompany.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findByEmail", query = "SELECT u FROM AppUser u WHERE u.email = :email"),
//        @NamedQuery(name = "findByEmailVerificationToken", query = ""),
//        @NamedQuery(name = "findByResetPasswordToken", query = "")
})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;

    // todo: add locale or language
    private boolean active = false;

    private String firstName;
    private String lastName;
    private String maidenName;
//    private Gender gender;
//    private MaritalStatus maritalStatus;
    private LocalDate birthDate;
    private String homeCity;

//    @ManyToMany
//    private List<Language> speakLanguages;

    private String city;
    private String education;
    private String about;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public MaritalStatus getMaritalStatus() {
//        return maritalStatus;
//    }
//
//    public void setMaritalStatus(MaritalStatus maritalStatus) {
//        this.maritalStatus = maritalStatus;
//    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

//    public List<Language> getSpeakLanguages() {
//        return speakLanguages;
//    }
//
//    public void setSpeakLanguages(List<Language> speakLanguages) {
//        this.speakLanguages = speakLanguages;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    // custom getter/setter
    public String getFullName() {
        return firstName + " " + lastName;
    }
}