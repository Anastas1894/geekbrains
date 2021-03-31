package ru.filenko.features.login;

import org.junit.jupiter.api.Test;
import ru.filenko.GeneralSettings;
import ru.filenko.pages.LoginPage;

import static ru.filenko.common.Configuration.*;


public class PositiveLoginTest extends GeneralSettings {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);
    }
}
