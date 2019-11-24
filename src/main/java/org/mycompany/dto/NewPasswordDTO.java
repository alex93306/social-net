package org.mycompany.dto;

public class NewPasswordDTO {
    private String uuid;
    private String password;
    private String repeatPassword;

    //todo: is getttet/setter required or we can use public for field int dtos?
    public String getUUID() {
        return uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
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
}
