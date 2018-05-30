package com.profiterole.stories;

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
 * Created by sokd on 3/9/2016.
 */
@RunWith(SerenityRunner.class)
public class LoginStory {
    private String propertyFilePath = "src/test/resources/login.properties";
    private String login = PropertyLoader.getProperty(propertyFilePath, "login");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String wrongLogin = PropertyLoader.getProperty(propertyFilePath, "wrongLogin");
    private String wrongPassword = PropertyLoader.getProperty(propertyFilePath, "wrongPassword");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setup() {
        loginSteps.openLoginPage();
    }

    @Test
    public void login() {
        loginSteps.enterLogin(login);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter();
        loginSteps.checkIfLoginSucceed();
    }

    @Test
    public void checkingLoginErrors() {
        loginSteps.clickEnter();
        loginSteps.checkPasswordOrLoginErrorPresent();
        loginSteps.enterLogin(login);
        loginSteps.clickEnter();
        loginSteps.checkPasswordOrLoginErrorPresent();
        loginSteps.clearLogin();
        loginSteps.enterPassword(password);
        loginSteps.clickEnter();
        loginSteps.checkPasswordOrLoginErrorPresent();
        loginSteps.enterLogin(wrongLogin);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter();
        loginSteps.checkPasswordOrLoginErrorPresent();
        loginSteps.enterLogin(login);
        loginSteps.enterPassword(wrongPassword);
        loginSteps.clickEnter();
        loginSteps.checkPasswordOrLoginErrorPresent();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
