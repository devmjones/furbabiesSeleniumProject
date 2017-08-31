package FurbabiesTests;

import Furbabies.HomePage;
import Furbabies.OptionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by devonjones on 8/26/17.
 */
public class HomePageSignInTest {
    WebDriver driver ;
   static HomePage homePage;
   static OptionsPage optionsPage;

    private static final String navigationURL= "https://furbabies2017.herokuapp.com/";

    /**
     * @author djones
     * Sets driver, instantiates pages, navigates to home page
     * @throws Exception
     */
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        homePage.driver = driver;
        driver.get(navigationURL);
        homePage.waitForSignUpPageToLoad();
    }

    /**
     * @author djones
     * Closes driver and browser
     * @throws Exception
     */
    @AfterMethod
    public void tearDown() throws Exception {
        this.driver.quit();
        homePage = null;
        optionsPage = null;
    }

    /**
     * @author djones
     *
     * Asserts that signing in as a valid user leads to the home page
     */
    @Test(groups = {"all", "signIn"})
    public static void testSignInLeadsToHomePage() throws InterruptedException {
        homePage.clickSignInBtn();
        homePage.waitForSignInPanelToLoad();
        homePage.fillOutSignInFields("devmjones@gmail.com", "password");
        homePage.submitSignInBtnClick();
        optionsPage.waitForOptionsPageToLoad();
        Assert.assertTrue(optionsPage.optionsPageLoaded(), "Options page should display a dog and a cat button");
    }

    /**
     * @author djones
     *
     * Asserts that attempting to log in with an incorrect password triggers an error message
     */
    @Test(groups = {"all", "signIn"})
    public static void testIncorrectPasswordTriggersError(){
        homePage.clickSignInBtn();
        homePage.waitForSignInPanelToLoad();
        homePage.fillOutSignInFields("devmjones@gmail.com", "wrong");
        homePage.submitSignInBtnClick();
        Assert.assertTrue(homePage.wrongPassword(), "Should see an error when attempting to log in with the wrong password");
    }
}
