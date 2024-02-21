package lt.techin.kristinaglebenkoviene;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BasePageTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    UserAccountPage successfullyRegistrationPage;
    String existingUserName = "Marta";

        String userName = "Kristina123456";
        String userPassword = "milka123";

    @Test
    public void userRegistration() {

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new UserAccountPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.clickCreateNewUserLink();
        String expectedRegElementText = "Naujos paskyros sukūrimas";
        String actualRegElementText = registrationPage.getTextOfRegistrationElement();
        assertEquals(expectedRegElementText, actualRegElementText, "Registration page element should have this text" + expectedRegElementText);
        registrationPage.setRegistrationNameInput(userName);
        registrationPage.setRegistrationPasswordInput(userPassword);
        registrationPage.setRegistrationPasswordConfirmationInput(userPassword);
        registrationPage.clickCreateNewUserButton();
    }

    @Test
    public void existingUserRegistration() {

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new UserAccountPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.clickCreateNewUserLink();
        String expectedRegElementText = "Naujos paskyros sukūrimas";
        String actualRegElementText = registrationPage.getTextOfRegistrationElement();
        assertEquals(expectedRegElementText, actualRegElementText, "Registration page element should have this text" + expectedRegElementText);
        registrationPage.setRegistrationNameInput(existingUserName);
        registrationPage.clickCreateNewUserButton();

    }

}
