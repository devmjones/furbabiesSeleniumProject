package Furbabies;

import HelperClasses.CommonUsefulMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
/**
 * Created by devonjones on 8/30/17.
 */
public class OptionsPage {
    // Instantiate driver
    public WebDriver driver;

    // Instantiate Webelements
    @FindBy(css = OptionsPageUIMap.optionsPageHeader )
    public WebElement optionsPageHeader;
    @FindBy(css = OptionsPageUIMap.dogBtn )
    public WebElement dogBtn;
    @FindBy(css = OptionsPageUIMap.catBtn )
    public WebElement catBtn;

    /**
     * @author djones
     *
     * Waits up to 20 seconds for options page welcome div to load
     */
    public void waitForOptionsPageToLoad(){
        CommonUsefulMethods.waitUntilElementVisable(driver, optionsPageHeader);
    }

    /**
     * @author djones
     *
     * @return the string from the welcome message on the options page
     */
    public String getWelcomeMsgText(){
        System.out.println(optionsPageHeader.getText());
        return optionsPageHeader.getText();
    }

    /**
     * @author
     *
     * Returns true if the dog and cat buttons are present on the page
     * @return
     */
    public boolean optionsPageLoaded(){
        return optionsPageHeader.isDisplayed();
    }

}
