package com.profiterole.steps;

import com.profiterole.pages.RegistrationPage;
import com.profiterole.pages.RegistrationSuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;

/**
 *
 */
public class RegistrationSteps extends ScenarioSteps {

    RegistrationPage registrationPage;

    @Step
    public void openRegistrationPage() {
        registrationPage.open();
    }

    @Step
    public void enterLogin(String login) {
        registrationPage.enterLigin(login);
    }

    @Step
    public void enterPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @Step
    public void confirmPassword(String confirmPassword) {
        registrationPage.confirmPassword(confirmPassword);
    }

    @Step
    public void enterEMail(String eMail) {
        registrationPage.enterEMail(eMail);
    }

    @Step
    public void enterDateOfBirth(String dateOfBirth) {
        registrationPage.enterDateOfBirt(dateOfBirth);
    }

    @Step
    public void selectGender(String gender) {
        registrationPage.selectGender(gender);
    }

    @Step
    public void selectCountry(String country) {
        registrationPage.selectCountry(country);
    }

    @Step
    public void markIAmAgree() {
        registrationPage.markIAmAgree();
    }

    @Step
    public void clickSubmit() {
        registrationPage.clickSubmit();
    }

    @Step
    public void clearLoginField() {

    }

    @Step
    public void checkLoginErrorMessagePresent() {
        assertTrue(registrationPage.checkLoginErrorMessagePresent());
    }

    @Step
    public void checkPasswordErrorMessagePresent() {
        assertTrue(registrationPage.checkPasswordErrorMessagePresent());
    }

    @Step
    public void checkEMailErrorMessagePresent() {
        assertTrue(registrationPage.checkEMailErrorMessagePresent());
    }

    @Step
    public void checkIAmAgreeErrorMessagePresent() {
        assertTrue(registrationPage.checkIAmAgreeErrorMessagePresent());
    }

    @Step
    public void checkRegistrationIsSuccessful() {
        assertTrue(getPages().isCurrentPageAt(RegistrationSuccessPage.class));
    }
}
