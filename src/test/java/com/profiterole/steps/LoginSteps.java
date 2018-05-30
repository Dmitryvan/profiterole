package com.profiterole.steps;

import com.profiterole.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.junit.Assert.*;

/**
 *
 */
public class LoginSteps extends ScenarioSteps{


    LoginPage loginPage;

    @Step
    public void openLoginPage() {
        loginPage.open();
    }

    @Step
    public void enterLogin(String login) {
        loginPage.enterLogin(login);
    }

    @Step
    public void clearLogin() {
        loginPage.clearLogin();
    }

    @Step
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step
    public void clearPassword() {
        loginPage.clearPassword();
    }

    @Step
    public void clickEnter() {
        loginPage.clickEnter();
    }

    @Step
    public void checkIfLoginSucceed() {
        assertFalse(getPages().isCurrentPageAt(LoginPage.class));
    }

    @Step
    public void checkPasswordOrLoginErrorPresent() {
        assertTrue(loginPage.checkPasswordOrLoginErrorPresent());
    }
}
