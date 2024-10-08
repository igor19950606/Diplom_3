package site.nomoreparties.stellarburgers.test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.page_object.RegisterPage;
import webDriver.WebTest;
import webDriver.Browser;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebTest webTest = new WebTest();
    protected RegisterPage registerPage;

    public void setupDriver(Browser browser) {
        driver = webTest.getWebDriver(browser);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        registerPage = new RegisterPage(driver);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
