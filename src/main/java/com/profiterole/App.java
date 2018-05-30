package com.profiterole;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        WebDriver driver = new FirefoxDriver();
        By selectCuisine = By.xpath("//div[@id=\"cuisine\"]/div[@class=\"btn\"]");

        driver.get("http://gioia-profiterole.rhcloud.com/menu");
        driver.findElement(By.xpath("//div[@class=\"btn-group no-outline\"]/button[2]")).click();

        List<WebElement> cuisineButtons = driver.findElements(selectCuisine);
        for (WebElement el : cuisineButtons) {
            if (el.getAttribute("href").equals("4")) {
                System.out.println(el);
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
                el.click();
                break;
            }
        }
        driver.findElement(By.id("2")).click();
    }
}
