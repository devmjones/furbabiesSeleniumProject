package Furbabies;

import HelperClasses.CommonUsefulMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by devonjones on 8/26/17.
 */
public class HomePage {

    // Instantiate driver
    public WebDriver driver;

    // Sign Up Web Elements
    @FindBy(css = HomePageUIMap.firstNameField)
    private WebElement firstNameField;
    @FindBy(css = HomePageUIMap.lastNameField)
    private WebElement lastNameField;
    @FindBy(css = HomePageUIMap.emailField)
    private WebElement emailField;
    @FindBy(css = HomePageUIMap.passwordField)
    private WebElement passwordField;
    @FindBy(css = HomePageUIMap.signInBtn)
    private WebElement signInBtn;
    @FindBy(css = HomePageUIMap.createBtn)
    private WebElement createBtn;
    @FindBy(css = HomePageUIMap.unmaskBtn)
    private WebElement unmaskBtn;
    @FindBy(xpath = HomePageUIMap.cancelBtn)
    private WebElement cancelBtn;

    // Sign In Web Elements
    @FindBy(css = HomePageUIMap.signInPanel)
    private WebElement signInPanel;
    @FindBy(css = HomePageUIMap.emailFieldSignIn)
    private WebElement emailFieldSignIn;
    @FindBy(css = HomePageUIMap.passwordFieldSignIn)
    private WebElement passwordFieldSignIn;
    @FindBy(css = HomePageUIMap.signInSubmitBtn)
    private WebElement signInSubmitBtn;

    // Error message
    @FindBy(xpath = HomePageUIMap.errorMsgTakenEmail)
    private WebElement errorMsgTakenEmail;
    @FindBy(xpath = HomePageUIMap.erroMsgWrongPass)
    private WebElement erroMsgWrongPass;


    /**
     * @author djones
     * <p>
     * Waits up to 20 seconds for the elements on the sign up page to load
     */
    public void waitForSignUpPageToLoad() {
        CommonUsefulMethods.waitUntilElementVisable(driver, firstNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, lastNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, emailField);
        CommonUsefulMethods.waitUntilElementVisable(driver, passwordField);
        CommonUsefulMethods.waitUntilElementVisable(driver, signInBtn);
        CommonUsefulMethods.waitUntilElementVisable(driver, createBtn);
    }

    /**
     * @author djones
     * <p>
     * Clicks Sign in button
     */
    public void clickSignInBtn() {
        signInBtn.click();
    }

    public void waitForSignInPanelToLoad() {
        CommonUsefulMethods.waitUntilElementVisable(driver, signInPanel);
    }

    public void fillOutSignInFields(String email, String password) {
        emailFieldSignIn.sendKeys(email);
        passwordFieldSignIn.sendKeys(password);
    }

    public void submitSignInBtnClick() {
        signInSubmitBtn.click();
    }

    public boolean wrongPassword() {
        return erroMsgWrongPass.isDisplayed();
    }

    /**
     * @author djones
     * <p>
     * Asserts that a new account signup will be accepted and a user will be redirected to the pet choice page
     */
    public void fillOutAllSignUpFields(String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    /**
     * @return true if all fields in sign up are empty
     * @author djones
     */
    public boolean signUpFieldsCleared() {
        return firstNameField.getText().equalsIgnoreCase("") &&
                lastNameField.getText().equalsIgnoreCase("") &&
                emailField.getText().equalsIgnoreCase("") &&
                passwordField.getText().equalsIgnoreCase("");
    }

    /**
     * @author djones
     * <p>
     * Clicks the cancel sign up button
     */
    public void cancelSignUp() {
        cancelBtn.click();
    }

    /**
     * @author djones
     * <p>
     * Clicks the Create Account Btn
     */
    public void clickCreateAccount() {
        createBtn.click();
    }

    /**
     * @author djones
     * <p>
     * Asserts that an error message appears when a user attempts to sign up with an email that is already taken
     */
    public boolean emailAlreadyTaken() {
        return errorMsgTakenEmail.isDisplayed();
    }

}
