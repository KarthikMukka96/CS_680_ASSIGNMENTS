package edu.umb.cs680.hw09.ModelABC;

public class SecurityContext {
    private State state;
    private User userDetails;

    public SecurityContext(User user) {
        this.state = LoggedOut.getInstance(this);
        this.userDetails = user;
    }

    public EncryptedString getPassword() {
        return this.userDetails.getPassword();
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public void login(EncryptedString pwd) {
        this.state.login(pwd);
    }

    public void logout() {
        this.state.logout();
    }

    public boolean isActive() {
        return true;
    }

    public State getState() {
        return this.state;
    }

}