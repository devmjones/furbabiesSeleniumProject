package Furbabies;

import HelperClasses.CommonUsefulMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by devonjones on 8/26/17.
 */
public class SignUpPage {

    // Instantiate driver
    public WebDriver driver;

    // Web Elements
    @FindBy(css = SignUpUiMap.firstNameField)
    private WebElement firstNameField;
    @FindBy(css = SignUpUiMap.lastNameField)
    private WebElement lastNameField;
    @FindBy(css = SignUpUiMap.emailField)
    private WebElement emailField;
    @FindBy(css = SignUpUiMap.passwordField)
    private WebElement passwordField;
    @FindBy(css = SignUpUiMap.signInLink)
    private WebElement signInLink;
    @FindBy(xpath = SignUpUiMap.submitBtn)
    private WebElement submitBtn;

    private Integer testUserNumber = 0;

    /**
     * @author djones
     *
     * Asserts that all required elements are present on the sign up page
     */
    public void waitForSignUpPageToLoad(){
        CommonUsefulMethods.waitUntilElementVisable(driver, firstNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, lastNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, emailField);
        CommonUsefulMethods.waitUntilElementVisable(driver,passwordField );
        CommonUsefulMethods.waitUntilElementVisable(driver, signInLink);
        CommonUsefulMethods.waitUntilElementVisable(driver, submitBtn);
    }

    /**
     * @author djones
     *
     * Asserts that a new account signup will be accepted and a user will be redirected to the pet choice page
     */
    public void createNewAcct(){
        String newEmail = CommonUsefulMethods.getCurrentDateTimeInMills().toString() + "@test.com";

        firstNameField.sendKeys("TestFirst" + testUserNumber.toString());
        lastNameField.sendKeys("TestLast" + testUserNumber.toString());
        emailField.sendKeys(newEmail);
        passwordField.sendKeys("password");

        // need confirm password here
        submitBtn.click();

        // Need to assert either success message or redirect
        Assert.assertTrue(true);
    }

    /**
     * @author djones
     *
     * Asserts that an error message appears when the two password fiels don't match
     */
    public void passwordsDontMatch(){}

    /**
     * @author djones
     *
     * Asserts that an error message appears when a user attempts to sign up with an email that is already taken
     */
    public void emailAlreadyTaken(){}

    /**
     * @author djones
     *
     * Asserts that error messages appear on all fields when submit button is clicked with no values
     */
    public void emptyFields(){}

}
