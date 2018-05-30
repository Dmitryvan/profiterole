package com.profiterole.stories;

import com.profiterole.steps.RegistrationSteps;
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
public class RegistrationStory {
    private final String propertyFilePath = "src/test/resources/registration.properties";
    private final String login = PropertyLoader.getProperty(propertyFilePath, "login");
    private final String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private final String confirmPassword = PropertyLoader.getProperty(propertyFilePath, "confirmPassword");
    private final String eMail = PropertyLoader.getProperty(propertyFilePath, "eMail");
    private final String dateOfBirth = PropertyLoader.getProperty(propertyFilePath, "DOB");
    private final String gender = PropertyLoader.getProperty(propertyFilePath, "gender");
    private final String country = PropertyLoader.getProperty(propertyFilePath, "country");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    RegistrationSteps registrationSteps;

    @Before
    public void setup() {
        registrationSteps.openRegistrationPage();
    }

    @Test
    public void registrationTest() {
        registrationSteps.enterLogin(login);
        registrationSteps.enterPassword(password);
        registrationSteps.confirmPassword(confirmPassword);
        registrationSteps.enterEMail(eMail);
        registrationSteps.enterDateOfBirth(dateOfBirth);
        registrationSteps.selectGender(gender);
        registrationSteps.selectCountry(country);
        registrationSteps.markIAmAgree();
        registrationSteps.clickSubmit();
        registrationSteps.checkRegistrationIsSuccessful();
    }

    @Test
    public void checkEmptyFormSubmit() {
        registrationSteps.clickSubmit();
        registrationSteps.checkLoginErrorMessagePresent();
        registrationSteps.checkPasswordErrorMessagePresent();
        registrationSteps.checkEMailErrorMessagePresent();
        registrationSteps.checkIAmAgreeErrorMessagePresent();
    }

    @Test
    public void checkIAmAgreeCheckboxRequired() {
        registrationSteps.enterLogin(login);
        registrationSteps.enterPassword(password);
        registrationSteps.confirmPassword(confirmPassword);
        registrationSteps.enterEMail(eMail);
        registrationSteps.enterDateOfBirth(dateOfBirth);
        registrationSteps.selectGender(gender);
        registrationSteps.selectCountry(country);
        registrationSteps.clickSubmit();
        registrationSteps.checkIAmAgreeErrorMessagePresent();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
