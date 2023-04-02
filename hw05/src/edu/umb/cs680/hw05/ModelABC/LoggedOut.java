package edu.umb.cs680.hw05.ModelABC;

public class LoggedOut implements State {

    private static LoggedOut lout;
    private SecurityContext ctx;
    private LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedOut getInstance(SecurityContext ctx) {
        if (lout == null) {
            lout = new LoggedOut(ctx);
        }
        lout.ctx = ctx;
        return lout;
    }

    @Override
    public void login(EncryptedString pwd) {
        if (Authenticator.authenticate(this.ctx, pwd)) {
            this.ctx.changeState(LoggedIn.getInstance(this.ctx));
        } else {
            throw new RuntimeException("Wrong Password entered");
        }
    }

    @Override
    public void logout() {
        System.out.println("You are already logged out");
    }
}
