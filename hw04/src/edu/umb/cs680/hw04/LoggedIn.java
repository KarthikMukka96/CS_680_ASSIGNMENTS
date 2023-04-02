package edu.umb.cs680.hw04;

public class LoggedIn implements State{

    private SecurityContext ctx;
    private static LoggedIn lin;

    private LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedIn getInstance(SecurityContext ctx) {
        if (lin == null) {
            lin = new LoggedIn(ctx);
        }
        lin.ctx = ctx;
        return lin;
    }
    @Override
    public void login(EncryptedString pwd) {
        if (!this.ctx.isActive()) {
            this.ctx.changeState(LoggedOut.getInstance(this.ctx));
            this.ctx.login(pwd);
        } else {
            System.out.println("You are already logged in");
        }
    }

    @Override
    public void logout() {
        this.ctx.changeState(LoggedOut.getInstance(this.ctx));
    }
}
