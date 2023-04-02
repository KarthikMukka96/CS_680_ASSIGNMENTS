package edu.umb.cs680.hw04;

public class User {
	private EncryptedString password;

	public User (EncryptedString pwd) {
		this.password = pwd;
	}

	public EncryptedString getPassword() {
		return this.password;
	}
}
