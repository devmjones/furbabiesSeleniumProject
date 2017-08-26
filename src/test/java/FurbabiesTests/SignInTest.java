package FurbabiesTests;

import Furbabies.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by devonjones on 8/26/17.
 */
public class SignInTest {
    WebDriver driver ;
    SignInPage signInPage;

    private static final String navigationURL= "https://furbabies2017.herokuapp.com/";

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        signInPage = new SignInPage();
        PageFactory.initElements(driver, signInPage);
        signInPage.driver = driver;
        driver.get(navigationURL);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        this.driver.quit();
        signInPage = null;
    }
}
