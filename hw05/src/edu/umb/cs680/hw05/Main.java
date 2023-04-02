package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.ModelABC.*;

public class Main {
	public static void main(String[] args) {

		ModelABC print = new ModelABC();
		try {
			print.execute(null, new SecurityContext(new User(new EncryptedString("pwd"))), new EncryptedString("123"));
		} catch (RuntimeException e) {
			System.out.print(e.getMessage());
		}

	}
}
