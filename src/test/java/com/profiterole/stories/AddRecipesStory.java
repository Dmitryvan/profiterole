package com.profiterole.stories;

import com.profiterole.steps.AddRecipesSteps;
import com.profiterole.steps.LoginSteps;
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
public class AddRecipesStory {
    private final String propertyFilePath = "src/test/resources/addRecipes.properties";
    private final String recipeTitle = PropertyLoader.getProperty(propertyFilePath, "recipeTitle");
    private final String recipeDescription = PropertyLoader.getProperty(propertyFilePath, "recipeDescription");
    private final String cookingHours = PropertyLoader.getProperty(propertyFilePath, "cookingHours");
    private final String cookingMinutes = PropertyLoader.getProperty(propertyFilePath, "cookingMinutes");
    private final String quantityOfDish = PropertyLoader.getProperty(propertyFilePath, "quantityOfDish");
    private final String cuisine = PropertyLoader.getProperty(propertyFilePath, "cuisine");
    private final String category = PropertyLoader.getProperty(propertyFilePath, "category");
    private final String markers = PropertyLoader.getProperty(propertyFilePath, "markers");
    private final String ingredientName = PropertyLoader.getProperty(propertyFilePath, "ingredientName");
    private final String ingredientCount = PropertyLoader.getProperty(propertyFilePath, "ingredientCount");
    private final String ingredientType = PropertyLoader.getProperty(propertyFilePath, "ingredientType");
    private final String complexity = PropertyLoader.getProperty(propertyFilePath, "complexity");
    private final String stepDescription = PropertyLoader.getProperty(propertyFilePath, "stepDescription");

    private final String propertLoginFilePath = "src/test/resources/login.properties";
    private final String login = PropertyLoader.getProperty(propertLoginFilePath, "login");
    private final String password = PropertyLoader.getProperty(propertLoginFilePath, "password");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    AddRecipesSteps addRecipesSteps;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setup() {
        loginSteps.openLoginPage();
        loginSteps.enterLogin(login);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter();
        addRecipesSteps.openAddRecipesPage();
    }

    @Test
    public void addRecipesTest() {
        addRecipesSteps.enterTitle(recipeTitle);
        addRecipesSteps.enterDescription(recipeDescription);
        addRecipesSteps.enterCookingTimeHours(cookingHours);
        addRecipesSteps.enterCookingTimeMinutes(cookingMinutes);
        addRecipesSteps.enterQuantityOfDish(quantityOfDish);
        addRecipesSteps.selectCuisine(cuisine);
        addRecipesSteps.selectCategory(category);
        addRecipesSteps.selectMarkers(markers);
        addRecipesSteps.enterIngredientName(ingredientName);
        addRecipesSteps.enterIngredientCount(ingredientCount);
        addRecipesSteps.selectIngredientType(ingredientType);
        addRecipesSteps.selectComplexity(complexity);
        addRecipesSteps.enterStepDescription(stepDescription);
        addRecipesSteps.clickCreate();
        addRecipesSteps.checkRecipeIsAdded();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
