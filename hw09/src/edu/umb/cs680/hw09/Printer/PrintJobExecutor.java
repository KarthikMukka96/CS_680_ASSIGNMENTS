package edu.umb.cs680.hw09.Printer;

import edu.umb.cs680.hw09.ModelABC.*;
import edu.umb.cs680.hw09.ModelABC.SecurityContext;

public abstract class PrintJobExecutor {
    public Command job;
    public SecurityContext ctx;

    public void execute(Command job, SecurityContext ctx, EncryptedString pwd) {
        doAuthentication(ctx, pwd);
        doAccessControl();
        this.ctx = ctx;
        this.job = job;
        doPrint();
        doExceptionHandling();
    }

    protected abstract void doAuthentication(SecurityContext ctx, EncryptedString pwd) ;

    protected abstract void doAccessControl();

    protected abstract void doPrint() ;

    protected abstract void doExceptionHandling() ;

    
}
