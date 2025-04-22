import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userauthprogpoe.Login;  // Import Login class (ensure the package name is correct)

public class UserAuthProgPoeTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login("kyl_1", "Ch$$sec@ke99", "+27831234567", "Dinilla", "Cameron");
    }

    @Test
    public void testUserNameValid() {
        assertTrue(login.checkUserName(), "Username should be correctly formatted");
    }

    @Test
    public void testUserNameInvalid() {
        login = new Login("kyl!!!", "Ch$$sec@ke99", "+27831234567", "Dinilla", "Cameron");
        assertFalse(login.checkUserName(), "Username should be incorrectly formatted");
    }

    @Test
    public void testPasswordValid() {
        assertTrue(login.checkPasswordComplexity(), "Password should meet complexity requirements");
    }

    @Test
    public void testPasswordInvalid() {
        login = new Login("kyl_1", "password", "+27831234567", "Dinilla", "Cameron");
        assertFalse(login.checkPasswordComplexity(), "Password should not meet complexity requirements");
    }

    @Test
    public void testCellPhoneNumberValid() {
        assertTrue(login.checkCellPhoneNumber(), "Cell phone number should be correctly formatted");
    }

    @Test
    public void testCellPhoneNumberInvalid() {
        login = new Login("kyl_1", "Ch$$sec@ke99", "08966553", "Dinilla", "Cameron");
        assertFalse(login.checkCellPhoneNumber(), "Cell phone number should be incorrectly formatted");
    }
}
