package com.profiterole.steps;

import com.profiterole.pages.MenuPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.*;

/**
 *
 */
public class MenuSteps extends ScenarioSteps {

    MenuPage menuPage;

    @Step
    public void openMenuPage() {
        menuPage.open();
    }

    @Step
    public void selectMeal(String meal) {
        menuPage.selectMeal(meal);
    }

    @Step
    public void selectCuisine(String cuisine) {
        menuPage.selectCuisine(cuisine);
    }

    @Step
    public void selectDishesType(String dishesType) {
        menuPage.selectDishesType(dishesType);
    }

    @Step
    public void moveDishToMenu(String dish) {
        menuPage.moveDishToMenu(dish);
    }

    @Step
    public void openDishCard(String dish) {
        menuPage.openDishCard(dish);
    }

    @Step
    public void addDishFromCard() {
        menuPage.addDishFromCard();
    }

    @Step
    public void closeDishCard() {
        menuPage.modalWindowClose();
    }

    @Step
    public void checkDishInMenu(String dish) {
        menuPage.checkDishInMenu(dish);
    }
    
    @Step
    public void checkDishCount() {
        assertTrue(menuPage.checkDishesCount());
    }


}
