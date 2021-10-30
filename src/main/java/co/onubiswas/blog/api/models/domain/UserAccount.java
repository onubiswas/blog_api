package co.onubiswas.blog.api.models.domain;

public class UserAccount {
//    private String id;
    private String name;
    private String email; // pk

    private String saltedPassword;

    public String getName() {
        return name;
    }
    public String getSaltedPassword() {
        return saltedPassword;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSaltedPassword(String password) {
        this.saltedPassword = password;
    }
}
