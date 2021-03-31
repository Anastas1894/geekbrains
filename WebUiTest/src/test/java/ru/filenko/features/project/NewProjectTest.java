package ru.filenko.features.project;

import org.junit.jupiter.api.Test;
import ru.filenko.GeneralSettings;
import ru.filenko.common.Configuration;
import ru.filenko.enums.NavigationBarTabs;
import ru.filenko.enums.SubMenuButtons;
import ru.filenko.pages.LoginPage;
import ru.filenko.pages.PageProjects;

public class NewProjectTest extends GeneralSettings {
    @Test
    public void createNewProjectPositiveTest() {
        PageProjects expensesScreen = (PageProjects) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.PROJECTS)
                .clickMenuButton(SubMenuButtons.MY_PROJECT);

        expensesScreen
                .clickOnCreateNewProjectButton()
                .enterDescription("test9999")
                .selectBusinessUnit(1)
                .selectCurator(114)
                .selectTeamLeader(95)
                .selectManager(114)
                .clickSubmit();
                //.checkNewProjectPopUp();
    }

    /*@Test
    public void createNewBTProjectPositiveTest() {
        PageProjects expensesScreen = (PageProjects) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.PROJECTS)
                .clickMenuButton(SubMenuButtons.BUSINESS_TRIPS);

        try {
            Thread.sleep(3000);

        }catch (Exception e){

        }
    }*/
}
