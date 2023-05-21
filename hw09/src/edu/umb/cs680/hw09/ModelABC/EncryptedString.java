package edu.umb.cs680.hw09.ModelABC;

public class EncryptedString {
    String password;

    public EncryptedString(String pwd) {
        this.password = pwd;
    }

    public String decrypt() {
        return password;
    }

}
