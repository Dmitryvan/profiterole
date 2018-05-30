package com.profiterole.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 */
@DefaultUrl("http://gioia-profiterole.rhcloud.com/registration")
@At("http://gioia-profiterole.rhcloud.com/registration")
public class RegistrationPage extends PageObject {

    private final By fieldLogin = By.id("login");
    private final By fieldPassword = By.id("password");
    private final By fieldConfirmPassword = By.id("confirmPassword");
    private final By fieldEMail = By.id("email");
    private final By fieldDateOfBirth = By.id("datepicker");
    private final By checkBoxGender = By.name("maleOrFemale");
    private final By listCountries = By.id("country");
    private final By checkBoxIAmAgree = By.id("iAmAgree");
    private final By btnSubmit = By.xpath("//button[@type=\"submit\"]");
    private final By lblLoginErrorMessage = By.id("loginError");
    private final By lblPasswordErrorMessage = By.id("passwordError");
    private final By lblEMailErrorMessage = By.id("emailError");
    private final By lblIAmAgreeErrorMessage = By.id("iAmAgreeError");


    public void enterLigin(String login) {
        clearLoginField();
        find(fieldLogin).sendKeys(login);
    }

    public void clearLoginField() {
        find(fieldConfirmPassword).clear();
    }

    public void enterPassword(String password) {
        clearPasswordField();
        find(fieldPassword).sendKeys(password);
    }

    public void clearPasswordField() {
        find(fieldPassword).clear();
    }

    public void confirmPassword(String confirmPassword) {
        find(fieldConfirmPassword).sendKeys(confirmPassword);
    }

    public void enterEMail(String eMail) {
        clearEMailField();
        find(fieldEMail).sendKeys(eMail);
    }

    public void clearEMailField() {
        find(fieldEMail).clear();
    }

    public void enterDateOfBirt(String dateOfBirth) {
        find(fieldDateOfBirth).sendKeys(dateOfBirth);
    }

    public void selectGender(String gender) {
        List<WebElement> elements = getDriver().findElements(checkBoxGender);
        for (WebElement el : elements) {
            if(el.getAttribute("value").equals(gender))
                el.click();
        }
    }

    public void selectCountry(String country) {
        find(listCountries).selectByValue(country);
    }

    public void markIAmAgree() {
        find(checkBoxIAmAgree).click();
    }

    public void clickSubmit() {
        find(btnSubmit).click();
    }

    public boolean checkLoginErrorMessagePresent() {
        return checkElementPresentByID(lblLoginErrorMessage);
    }

    public boolean checkPasswordErrorMessagePresent() {
        return checkElementPresentByID(lblPasswordErrorMessage);
    }

    public boolean checkEMailErrorMessagePresent() {
        return checkElementPresentByID(lblEMailErrorMessage);
    }

    public boolean checkIAmAgreeErrorMessagePresent() {
        return checkElementPresentByID(lblIAmAgreeErrorMessage);
    }

    private boolean checkElementPresentByID(By id) {
        try {
            getDriver().findElement(id);
            return true;
        }catch (ElementNotFoundAfterTimeoutError e) {
            return false;
        }
    }
}
