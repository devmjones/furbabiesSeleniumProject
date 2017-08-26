package Furbabies;

import HelperClasses.CommonUsefulMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void waitForSignUpPageToLoad(){
        CommonUsefulMethods.waitUntilElementVisable(driver, firstNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, lastNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, emailField);
        CommonUsefulMethods.waitUntilElementVisable(driver,passwordField );
        CommonUsefulMethods.waitUntilElementVisable(driver, signInLink);
        CommonUsefulMethods.waitUntilElementVisable(driver, submitBtn);
    }



}
