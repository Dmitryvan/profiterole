package com.profiterole.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 */
@DefaultUrl("http://gioia-profiterole.rhcloud.com/addRecipes")
@At("http://gioia-profiterole.rhcloud.com/addRecipes")
public class AddRecipesPage extends PageObject {

    private final By fieldRecipeTitle = By.className("add-recipe-title");
    private final By fieldRecipeDescription = By.name("description");
    private final By fieldCookingHours = By.name("cookingTimeHours");
    private final By fieldCookingMinutes = By.name("cookingTimeMinutes");
    private final By fieldQuantityOfDish = By.name("quantityOfDish");
    private final By selectCuisine = By.name("cuisineId");
    private final By selectCategory = By.name("categoryId");
    private final By checkBoxesMarkers = By.xpath("//input[starts-with(@name, \"markersNames\")]");
    private final By fieldIngredientName = By.id("ingredientsNameList[0]");
    private final By fieldIngredientCount = By.id("ingredientsCountList[0]");
    private final By selectIngredientType = By.id("ingredientsTypeList[0]");
    private final By selectComplexity = By.xpath("//select[@id=\"complexity\"]");
    private final By textAreaStepDescription = By.xpath("//div[@id=\"step_1\"]//textarea");
    private final By btnCreate = By.id("OK");


    public void typeIntoField(By locator, String value) {
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    public void enterTitle(String recipeTitle) {
        typeIntoField(fieldRecipeTitle, recipeTitle);
    }

    public void enterDescription(String recipeDescription) {
        typeIntoField(fieldRecipeDescription, recipeDescription);
    }

    public void enterCookingTimeHours(String cookingHours) {
        typeIntoField(fieldCookingHours, cookingHours);
    }

    public void enterCookingTimeMinutes(String cookingMinutes) {
        typeIntoField(fieldCookingMinutes, cookingMinutes);
    }

    public void enterQuantityOfDish(String quantityOfDish) {
        typeIntoField(fieldQuantityOfDish, quantityOfDish);
    }

    public void selectCuisine(String cuisine) {
        selectFromDropdown(find(selectCuisine), cuisine);
    }

    public void selectCategory(String category) {
        selectFromDropdown(find(selectCategory), category);
    }

    public void selectMarkers(String markers) {
        List<WebElement> Markers = getDriver().findElements(checkBoxesMarkers);
        for (WebElement el : Markers) {
            if(el.getAttribute("value").equals(markers))
                el.click();
        }
    }

    public void enterIngredientName(String ingredientName) {
        typeIntoField(fieldIngredientName, ingredientName);
    }

    public void enterIngredientCount(String ingredientCount) {
        evaluateJavascript("document.getElementById('ingredientsCountList[0]').focus()");
        if(!find(fieldIngredientCount).isEnabled())
            find(fieldIngredientCount).waitUntilEnabled();
        typeIntoField(fieldIngredientCount, ingredientCount);
    }

    public void selectIngredientType(String ingredientType) {
        selectFromDropdown(find(selectIngredientType), ingredientType);
    }

    public void selectComplexity(String complexity) {
        selectFromDropdown(find(selectComplexity), complexity);
    }

    public void enterStepDescription(String stepDescription) {
        typeIntoField(textAreaStepDescription, stepDescription);
    }

    public void clickCreate() {
        find(btnCreate).click();
    }
}
