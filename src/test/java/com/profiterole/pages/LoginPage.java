package com.profiterole.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 */

@DefaultUrl("http://gioia-profiterole.rhcloud.com/login")
@At("http://gioia-profiterole.rhcloud.com/login")
public class LoginPage extends PageObject{

    //WebDriver driver = getDriver();
    private final By fieldLogin = By.id("j_username");
    private final By fieldPassword = By.id("j_password");
    private final By btnEnter = By.xpath("//button[@type=\"submit\"]");
    private final By lblPasswordOrLoginError = By.id("passwordOrLoginError");

//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }


    public void enterLogin(String login) {
        clearLogin();
        find(fieldLogin).sendKeys(login);
    }

    public void clearLogin() {
        find(fieldLogin).clear();
    }

    public void enterPassword(String password) {
        clearPassword();
        find(fieldPassword).sendKeys(password);
    }

    public void clearPassword() {
        find(fieldPassword).clear();
    }

    public void clickEnter() {
        element(btnEnter).click();
    }

    public boolean checkPasswordOrLoginErrorPresent() {
        try {
            getDriver().findElement(lblPasswordOrLoginError);
            return true;
        }
        catch (ElementNotFoundAfterTimeoutError e)
        {
            return false;
        }
    }
}
