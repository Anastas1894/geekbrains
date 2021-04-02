package ru.filenko.views;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.filenko.BaseView;
import ru.filenko.SubMenu;
import ru.filenko.enums.NavigationBarTabs;

public class NavigationBar extends BaseView {
    public NavigationBar(WebDriver driver) {
        super(driver);
    }
    @Step("move cursor to {tab}")
    public SubMenu moveCursorToNavigationTab(NavigationBarTabs tab) {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();
        switch (tab) {
            case PROJECTS:
                return new ProjectSubMenu(driver);
            default:
                throw new IllegalArgumentException("Another tabs currently not implemented");
        }
    }
    @Step("Check visibility of tab {tab}")
    public NavigationBar checkTabVisibility(NavigationBarTabs tab) {
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}
