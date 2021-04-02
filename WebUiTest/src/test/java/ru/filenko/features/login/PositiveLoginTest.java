package ru.filenko.features.login;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import ru.filenko.GeneralSettings;
import ru.filenko.pages.LoginPage;

import static ru.filenko.common.Configuration.*;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)

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
