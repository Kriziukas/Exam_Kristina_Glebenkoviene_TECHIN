package lt.techin.kristinaglebenkoviene;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOutTest extends BasePageTest {

    String userName = "Vilma";
    String userPassword = "Vili123";
    LoginPage loginPage;
    UserAccountPage userAccountPage;

    @Test
    public void userLogout() {

        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.fillNameInput(userName);
        loginPage.fillPasswordInput(userPassword);
        loginPage.clickLoginButton();
        String expectedUserAccountElementText = "Galimos operacijos: sudėti, atimti, dauginti, dalinti";
        String actualUserAccountElementText = userAccountPage.getTextOfUserAccountElement();
        assertEquals(expectedUserAccountElementText, actualUserAccountElementText, "User account page element should have this text" + expectedUserAccountElementText);
        userAccountPage.clickLogoutLink();

    }
}

