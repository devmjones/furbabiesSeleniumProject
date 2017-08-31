package FurbabiesTests;


import Furbabies.HomePage;
import Furbabies.OptionsPage;
import HelperClasses.CommonUsefulMethods;
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
public class HomePageSignUpTest {
   public static  WebDriver driver ;
   public static HomePage homePage;
   public static OptionsPage optionsPage;

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
        optionsPage = new OptionsPage();
        optionsPage.driver = driver;
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
     * Asserts that signing up leads to the options page
     *
     * WIP: Needs debugging
     */
    @Test(groups = {"all", "signUp"}, enabled = false)
    public static void testSignUpLeadsToOptionsPage() throws InterruptedException {
        String email = CommonUsefulMethods.getCurrentDateTimeInMills().toString() + "@test.com";
        homePage.fillOutAllSignUpFields("test", "testLast", email, "password");
        homePage.clickCreateAccount();
        optionsPage.waitForOptionsPageToLoad();
        Thread.sleep(5000);
       Assert.assertTrue(optionsPage.getWelcomeMsgText().contains("Welcome test"), "Options page should display a dog and a cat button");
    }

    /**
     * @author djones
     *
     * Aserts that clicking the cancel button after filling out all fields clears all fields
     */
    @Test(groups = {"all", "signUp"})
    public static void testCancelSignUpClearsAllFields(){
        String email = CommonUsefulMethods.getCurrentDateTimeInMills().toString() + "@test.com";
        homePage.fillOutAllSignUpFields("test", "testLast", email, "password");
        homePage.cancelSignUp();
        Assert.assertTrue(homePage.signUpFieldsCleared(), "Sign up fields should contain no text after hitting cancel button");
    }

    /**
     * @author djones
     *
     * Asserts that attempting to sign up with an existing user's email triggers an error message
     */
    @Test(groups = {"all", "signUp"})
    public static void testDuplicateEmailTriggersError() throws InterruptedException {
        homePage.fillOutAllSignUpFields("test", "testLast", "devmjones@gmail.com", "password");
        homePage.clickCreateAccount();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.emailAlreadyTaken(), "Attempting to sign up with an existing user's password should trigger an error");
    }

}
