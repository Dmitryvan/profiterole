package com.profiterole.stories;

import com.profiterole.steps.LoginSteps;
import com.profiterole.steps.MenuSteps;
import com.profiterole.utils.PropertyLoader;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 */

@RunWith(SerenityRunner.class)
public class MenuStory {

    private final String propertyFilePath = "src/test/resources/menu.properties";
    private final String meal = PropertyLoader.getProperty(propertyFilePath, "meal");
    private final String cuisine = PropertyLoader.getProperty(propertyFilePath, "cuisine");
    private final String dishesType = PropertyLoader.getProperty(propertyFilePath, "dishesType");
    private final String dishOne = PropertyLoader.getProperty(propertyFilePath, "dishOne");
    private final String dishTwo = PropertyLoader.getProperty(propertyFilePath, "dishTwo");

    private final String propertyLoginFilePath = "src/test/resources/login.properties";
    private final String login = PropertyLoader.getProperty(propertyLoginFilePath, "login");
    private final String password = PropertyLoader.getProperty(propertyLoginFilePath, "password");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    MenuSteps menuSteps;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setup() {
        loginSteps.openLoginPage();
        loginSteps.enterLogin(login);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter();
        menuSteps.openMenuPage();
    }

    @Test
    public void addMenuForADay() {
        menuSteps.selectMeal(meal);
        menuSteps.selectCuisine(cuisine);
        menuSteps.selectDishesType(dishesType);
        menuSteps.moveDishToMenu(dishOne);
        menuSteps.moveDishToMenu(dishTwo);
        menuSteps.moveDishToMenu(dishOne);
        menuSteps.checkDishInMenu(dishOne);
        menuSteps.checkDishInMenu(dishTwo);
        menuSteps.checkDishCount();
    }

    @Test
    public void openDishCatd() {
        menuSteps.selectMeal(meal);
        menuSteps.selectCuisine(cuisine);
        menuSteps.selectDishesType(dishesType);
        menuSteps.openDishCard(dishOne);
        menuSteps.addDishFromCard();
        //menuSteps.closeDishCard();
        menuSteps.checkDishCount();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
