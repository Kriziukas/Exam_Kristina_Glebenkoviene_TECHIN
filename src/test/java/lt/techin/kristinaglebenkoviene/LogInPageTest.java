package lt.techin.kristinaglebenkoviene;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInPageTest extends BasePageTest {
    LoginPage loginPage;
    String userName = "Vilma";
    String shortUserName = "Vil";
    String userPassword = "Vili123";

    @Test
    public void userLogin() {
        loginPage = new LoginPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.fillNameInput(userName);
        loginPage.fillPasswordInput(userPassword);
        loginPage.clickLoginButton();
    }

    @Test
    public void wrongUserNameLogin() {
        loginPage = new LoginPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.fillNameInput(shortUserName);
        loginPage.clickLoginButton();
        String expectedErrorMessageForLoginNameText = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualErrorMessageForLoginLoginNameText = loginPage.getTextOfErrorLoginNameMessage();
        assertEquals(expectedErrorMessageForLoginNameText, actualErrorMessageForLoginLoginNameText, "Error message in Login page by entering short name should have this text" + expectedErrorMessageForLoginNameText);

    }

}
