package edu.umb.cs680.hw05.ModelABC;

public class Authenticator {
    public static boolean authenticate(SecurityContext ctx, EncryptedString pwd) {
        if (ctx!= null && ctx.getPassword().decrypt().equals(pwd.decrypt())) {
            return true;
        }
        return false;
    }
}
