package ru.filenko.features.navigation;

import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.filenko.GeneralSettings;
import ru.filenko.common.Configuration;
import ru.filenko.enums.NavigationBarTabs;
import ru.filenko.pages.LoginPage;

import static ru.filenko.common.Configuration.BASE_URL;

@Feature("Navigation")
public class NavigationTest extends GeneralSettings {
    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    public void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);

    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

}
