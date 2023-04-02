package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.ModelABC.*;
import edu.umb.cs680.hw05.ModelXYZ.*;
import edu.umb.cs680.hw05.Printer.PrintJob;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    @Test
    public void login_test_ModelABC() {

        ModelABC  printer = new ModelABC();
        try {
           printer.execute(null, new SecurityContext(new User(new EncryptedString("correct"))) ,new EncryptedString("correct"));
            assert(true); 
        } catch (RuntimeException e) {
            fail();
        }
        
    }

    @Test
    public void wrong_login_test_ModelABC() {

        ModelABC  printer = new ModelABC();

        try {
           printer.execute(null, new SecurityContext(new User(new EncryptedString("correct"))) ,new EncryptedString("wrong"));
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong Password entered");
        }
        
    }

    @Test
    public void login_test_ModelXYZ() {

        ModelXYZ  printer = new ModelXYZ();
        try {
           printer.execute(null, new SecurityContext(new User(new EncryptedString("correct"))) ,new EncryptedString("wrong"));
            assert(true);
        } catch (RuntimeException e) {
            fail();
        }
        
    }


}