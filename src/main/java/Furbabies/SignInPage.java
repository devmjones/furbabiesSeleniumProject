package Furbabies;

import HelperClasses.CommonUsefulMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by devonjones on 8/26/17.
 */
public class SignInPage {

    // Instantiate driver
    public WebDriver driver;

    // Web Elements
    @FindBy(css= SignInUIMap.userNameField)
    public WebElement userNameField;
    @FindBy(css= SignInUIMap.passwordField)
    public WebElement passwordField;
    @FindBy(css= SignInUIMap.sendBtn)
    public WebElement sendBtn;

    public void waitUntilSignInDropDownToLoad(){
        CommonUsefulMethods.waitUntilElementVisable(driver, userNameField);
        CommonUsefulMethods.waitUntilElementVisable(driver, passwordField);
        CommonUsefulMethods.waitUntilElementVisable(driver, sendBtn);
    }
}
