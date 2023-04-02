package edu.umb.cs680.hw04;

public class EncryptedString {
    String password;

    public EncryptedString(String pwd) {
        this.password = pwd;
    }

    public String decrypt() {
        return password;
    }

}
