package com.profiterole.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.yecht.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 */
@DefaultUrl("http://gioia-profiterole.rhcloud.com/menu")
@At("http://gioia-profiterole.rhcloud.com/menu")
public class MenuPage extends PageObject {

    HashMap<String, Integer> dishCount = new HashMap();

    private final By selectMeal = By.xpath("//div[@class='btn-group no-outline']/button");
    private final By selectCuisine = By.xpath("//div[@id='cuisine']/div[@class='btn']");
    private final By selectDishInTheList = By.xpath("//div[@id='rec']//div[@class='recipe_title']/label");
    private final By selectDishInTheMenu = By.xpath("//div[@id='dinner']//input[@class='rec_count']");
    private final By btnDishCardAdd = By.xpath("//button[@class='btn btn-success']");
    private final By lblModalDishName = By.id("myModalLabel");

    private final String dishTitlePath = "../div[@class='recipe_title']/label";
    private final String dishesTypePanelPath = "//ul[@id='myTab']";
    String parentWindowHandler;


    public void selectMeal(String meal) {
        findAndClick(selectMeal, "value", meal);
    }

    public void selectCuisine(String cuisine){
        findAndClick(selectCuisine, "href", cuisine);
    }

    public void selectDishesType(String dishesType) {
        waitForPresenceOf(dishesTypePanelPath);
        find(By.id(dishesType)).click();
    }

    public void openDishCard (String dish) {
        parentWindowHandler = getDriver().getWindowHandle();
        List<WebElement> cuisineButtons = getDriver().findElements(selectDishInTheList);
        for (WebElement el : cuisineButtons) {
            if (el.getText().contains(dish)) {
                el.click();
                break;
            }
        }
    }

    public void addDishFromCard () {
        dishCounter(dishCount, find(lblModalDishName).getText());
        find(btnDishCardAdd).click();
        getDriver().switchTo().window(parentWindowHandler);
    }

    public void modalWindowClose() {
        find(By.id("close")).click();
    }

    public void moveDishToMenu(String dish) {
        WebElement selectedDish = null;
        WebElement myMenu = find(By.id("dinner"));

        List<WebElement> cuisineButtons = getDriver().findElements(selectDishInTheList);
        for (WebElement el : cuisineButtons) {
            if (el.getText().contains(dish)) {
                selectedDish = el;
                break;
            }
        }

        Actions builder = new Actions(getDriver());
        builder.dragAndDrop(selectedDish, myMenu).perform();
        dishCounter(dishCount, dish);
    }

    public void checkDishInMenu(String dish) {
        getDriver().findElement(By.xpath(
                "//div[@id='dinner']//div[@class='recipe_title']/label[contains(text(), '" + dish + "')]"));
    }

    public boolean checkDishesCount() {
        HashMap<String, Integer> dishCountInMenu = new HashMap<>();
        List<WebElement> cuisineButtons = getDriver().findElements(selectDishInTheMenu);
        for (WebElement el : cuisineButtons) {
            String title = el.findElement(By.xpath(dishTitlePath)).getText();
            int innerCount = Integer.parseInt(el.getAttribute("value"));
            dishCountInMenu.put(title, innerCount);
        }

        return (dishCountInMenu.equals(dishCount));
    }

    private void dishCounter(HashMap<String, Integer> count, String key) {
        if(count.containsKey(key)) {
            count.put(key, count.get(key) + 1);
        }else {
            count.put(key, 1);
        }
    }

    private void findAndClick(By locator, String attribute, String parameter) {
        List<WebElement> cuisineButtons = getDriver().findElements(locator);
        for (WebElement el : cuisineButtons) {
            if (el.getAttribute(attribute).contains(parameter)) {
                el.click();
                break;
            }
        }
    }

    public void swithToModalWindow() {
        String modalWindowHandle = "";
        Set<String> handles = getDriver().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentWindowHandler))
                modalWindowHandle = handle;
        }
        getDriver().switchTo().window(modalWindowHandle);
    }
}
