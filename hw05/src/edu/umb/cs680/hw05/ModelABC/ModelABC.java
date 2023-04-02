package edu.umb.cs680.hw05.ModelABC;


import edu.umb.cs680.hw05.Printer.*;

public class ModelABC extends PrintJobExecutor{

	@Override
	public void doAuthentication(SecurityContext ctx, EncryptedString pwd) {
		ctx.login(pwd);
		if (!(ctx.isActive() && ctx.getState() instanceof LoggedIn)) {
			throw new RuntimeException("Password wrong, printing failed");
		}

	}

	@Override
	public void doExceptionHandling(){}

	@Override
	public void doAccessControl() {}

	@Override
	public void doPrint() {
		System.out.println("Model ABC Printing............");
	}
    
}
