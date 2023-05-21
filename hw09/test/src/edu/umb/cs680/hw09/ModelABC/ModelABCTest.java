package edu.umb.cs680.hw09.ModelABC;

import com.sun.tools.jconsole.JConsoleContext;
import edu.umb.cs680.hw09.Printer.PrintJobExecutor;
import edu.umb.cs680.hw09.ModelABC.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ModelABCTest {

    private ModelABC modelABC;
    private SecurityContext securityContext;
    private PrintJob printerJob;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp1() {
        System.setOut(new PrintStream(outputStream));
    }


    @BeforeEach
    void setUp() {
        modelABC = new ModelABC();
        securityContext = new SecurityContext(new User(new EncryptedString("correct_password")));
        printerJob = new PrintJob();
    }

    @Test
    void testDoAuthentication_SuccessfulLogin() {
        try {
            modelABC.execute(printerJob , securityContext, new EncryptedString("correct_password"));
            assertEquals("........printting......\n", outputStream.toString());
        } catch (RuntimeException err) {
            assertEquals("Wrong Password entered", err.getMessage() );
        }
    }

    @Test
    void testGetPrinter_SingletonInstance() {
        Printer printer1 = Printer.getPrinter();
        Printer printer2 = Printer.getPrinter();

        assertSame(printer1, printer2);
    }

    @Test
    void testPrint_PrintsMessage() {
        Printer printer = Printer.getPrinter();
        printer.print();
        assertEquals("........printting......\n", outputStream.toString());
    }


    @Test
    void testDoAuthentication_FailedLogin() {
        try {
            modelABC.execute(printerJob , securityContext, new EncryptedString("wrong_password"));
            fail();
        } catch (RuntimeException err) {
            assertEquals("Wrong Password entered", err.getMessage() );
        }
    }

}
