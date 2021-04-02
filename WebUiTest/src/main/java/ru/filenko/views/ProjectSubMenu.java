package ru.filenko.views;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.filenko.BaseView;
import ru.filenko.IMenuButtons;
import ru.filenko.SubMenu;
import ru.filenko.enums.SubMenuButtons;
import ru.filenko.pages.PageProjects;

public class ProjectSubMenu extends SubMenu {
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("click on sub menu button {buttons}")
    public BaseView clickMenuButton(IMenuButtons buttons) {
        if (buttons instanceof SubMenuButtons) {
            switch ((SubMenuButtons) buttons) {
                case MY_PROJECT:
                case BUSINESS_TRIPS:
                    driver.findElement(((SubMenuButtons) buttons).getBy()).click();
                    return new PageProjects(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }

}
