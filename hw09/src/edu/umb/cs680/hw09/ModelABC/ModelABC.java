package edu.umb.cs680.hw09.ModelABC;


import edu.umb.cs680.hw09.Printer.*;

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

		if (ctx.isActive()) {
			job.execute();
		}
	}
    
}
