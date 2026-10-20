package Src.Model;

public class AdminAccount {

    private String email;
    private String password;
    private boolean token = false;

    public void setCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getToken() {
        return token;
    }

    public void setToken() {
        token = true;
    }
}
