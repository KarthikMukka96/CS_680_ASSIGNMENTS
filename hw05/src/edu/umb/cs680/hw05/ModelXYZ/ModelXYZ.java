package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw05.Printer.*;
import edu.umb.cs680.hw05.ModelABC.*;

public class ModelXYZ extends PrintJobExecutor{

    @Override
    public void doPrint() {
    	System.out.println("Model XYZ Printing...........");
    }

    @Override
    public void doExceptionHandling(){}

    @Override
    public void doAccessControl() {}

    @Override
    public void doAuthentication(SecurityContext ctx, EncryptedString pwd) {}
}
