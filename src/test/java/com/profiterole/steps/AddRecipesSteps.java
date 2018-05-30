package com.profiterole.steps;

import com.profiterole.pages.AddRecipesPage;
import com.profiterole.pages.SuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.*;

/**
 *
 */

public class AddRecipesSteps extends ScenarioSteps {

    AddRecipesPage addRecipesPage;

    @Step
    public void openAddRecipesPage() {
        addRecipesPage.open();
    }

    @Step
    public void enterTitle(String recipeTitle) {
        addRecipesPage.enterTitle(recipeTitle);
    }

    @Step
    public void enterDescription(String recipeDescription) {
        addRecipesPage.enterDescription(recipeDescription);
    }

    @Step
    public void enterCookingTimeHours(String cookingHours) {
        addRecipesPage.enterCookingTimeHours(cookingHours);
    }

    @Step
    public void enterCookingTimeMinutes(String cookingMinutes) {
        addRecipesPage.enterCookingTimeMinutes(cookingMinutes);
    }

    @Step
    public void enterQuantityOfDish(String quantityOfDish) {
        addRecipesPage.enterQuantityOfDish(quantityOfDish);
    }

    @Step
    public void selectCuisine(String cuisine) {
        addRecipesPage.selectCuisine(cuisine);
    }

    @Step
    public void selectCategory(String category) {
        addRecipesPage.selectCategory(category);
    }

    @Step
    public void selectMarkers(String markers) {
        addRecipesPage.selectMarkers(markers);
    }

    @Step
    public void enterIngredientName(String ingredientName) {
        addRecipesPage.enterIngredientName(ingredientName);
    }

    @Step
    public void enterIngredientCount(String ingredientCount) {
        addRecipesPage.enterIngredientCount(ingredientCount);
    }

    @Step
    public void selectIngredientType(String ingredientType) {
        addRecipesPage.selectIngredientType(ingredientType);
    }

    @Step
    public void selectComplexity(String complexity) {
        addRecipesPage.selectComplexity(complexity);
    }

    @Step
    public void enterStepDescription(String stepDescription) {
        addRecipesPage.enterStepDescription(stepDescription);
    }

    @Step
    public void clickCreate() {
        addRecipesPage.clickCreate();
    }

    @Step
    public void checkRecipeIsAdded() {
        assertTrue(getPages().isCurrentPageAt(SuccessPage.class));
    }
}
