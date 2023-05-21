package edu.umb.cs680.hw09.ModelABC;

public interface State {
     void login(EncryptedString pwd);

     void logout();
}
