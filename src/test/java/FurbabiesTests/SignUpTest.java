package FurbabiesTests;


import Furbabies.SignInPage;
import Furbabies.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by devonjones on 8/26/17.
 */
public class SignUpTest {
    WebDriver driver ;
    SignUpPage signUpPage;

    private static final String navigationURL= "https://furbabies2017.herokuapp.com/";

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        signUpPage = new SignUpPage();
        PageFactory.initElements(driver, signUpPage);
        signUpPage.driver = driver;
        driver.get(navigationURL);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        this.driver.quit();
        signUpPage = null;
    }


}
