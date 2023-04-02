package edu.umb.cs680.hw05.ModelABC;

public interface State {
     void login(EncryptedString pwd);

     void logout();
}
