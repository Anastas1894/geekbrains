package ru.filenko;

import org.openqa.selenium.WebDriver;

public abstract class SubMenu extends BaseView{
    public SubMenu(WebDriver driver) {
        super(driver);
    }

    abstract public BaseView clickMenuButton(IMenuButtons buttons);
}
