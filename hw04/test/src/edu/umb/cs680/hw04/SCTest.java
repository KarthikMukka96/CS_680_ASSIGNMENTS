package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SCTest {

    @Test
    public void initialLogoutState() {
        SecurityContext mac = new SecurityContext(new User(new EncryptedString("pwd")));

        assertEquals(mac.getState() , LoggedOut.getInstance(mac));
    }

    @Test
    public void loginTest() {
        SecurityContext mac = new SecurityContext(new User(new EncryptedString("pwd")));

        mac.login(new EncryptedString("pwd"));

        assertEquals(mac.getState() , LoggedIn.getInstance(mac));
    }

    @Test
    public void loginFailedTest() {
        SecurityContext mac = new SecurityContext(new User(new EncryptedString("pwd")));

        assertEquals(mac.getState() , LoggedOut.getInstance(mac));

        try {
            mac.login(new EncryptedString("okokk"));
            fail();
        } catch (RuntimeException e) {
            assertEquals("Wrong Password entered" , e.getMessage());
        }

    }

    @Test
    public void loginToLogout() {
        SecurityContext mac = new SecurityContext(new User(new EncryptedString("pwd")));

        mac.login(new EncryptedString("pwd"));

        mac.logout();

        assertEquals(mac.getState() , LoggedOut.getInstance(mac));
    }

    @Test
    public void logoutToLogout() {
        SecurityContext mac = new SecurityContext(new User(new EncryptedString("pwd")));

        mac.logout();

        assertEquals(mac.getState() , LoggedOut.getInstance(mac));
    }
  
    @Test
    public void testForSingletonOfLoggedOutLoggedIn() {
        
        SecurityContext mac = new SecurityContext(new User(new EncryptedString("pwd")));

        assertSame(LoggedOut.getInstance(mac), LoggedOut.getInstance(mac));

        assertSame(LoggedIn.getInstance(mac), LoggedIn.getInstance(mac));
    }

}