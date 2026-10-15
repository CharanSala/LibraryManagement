package Src.Model;

public class AdminDetails {

    private String email;
    private String password;

    public void setValues(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
