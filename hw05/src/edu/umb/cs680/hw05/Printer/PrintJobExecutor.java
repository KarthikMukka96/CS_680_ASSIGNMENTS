package edu.umb.cs680.hw05.Printer;

import edu.umb.cs680.hw05.ModelABC.*;

public abstract class PrintJobExecutor {

    public void execute(PrintJob job, SecurityContext ctx, EncryptedString pwd) {
        doAuthentication(ctx, pwd);
        doAccessControl();
        doPrint();
        doExceptionHandling();
    }

    protected abstract void doAuthentication(SecurityContext ctx, EncryptedString pwd) ;

    protected abstract void doAccessControl();

    protected abstract void doPrint() ;

    protected abstract void doExceptionHandling() ;

    
}
