package site.nomoreparties.stellarburgers.test;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.servinguser.LoginUser;
import site.nomoreparties.stellarburgers.servinguser.ServingUser;
import webDriver.BrowserParameters;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {

    private webDriver.Browser browser;
    private ServingUser servingUser;
    private String testUserEmail;
    private String testUserPassword = "1234567";
    private String testUserName;
    private String accessToken;

    public RegistrationTest(webDriver.Browser browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{index}: Тест браузера {0}")
    public static Object[][] data() {
        return BrowserParameters.data().toArray(new Object[0][]);
    }

    @Before
    public void setup() {
        setupDriver(browser);
        servingUser = new ServingUser();
        testUserEmail = UserGeneratorTest.generateUniqueEmail();
        testUserName = UserGeneratorTest.generateUniqueName();
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            servingUser.deleteUser(accessToken);
        }
    }

    @Test
    @Step("Тест успешной регистрации")
    public void successfulRegistrationTest() {
        driver.get(servingUser.getUserRegister());
        registerPage.enterName(testUserName);
        registerPage.enterEmail(testUserEmail);
        registerPage.enterPassword(testUserPassword);
        registerPage.clickRegisterButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(driver -> driver.getCurrentUrl().equals(servingUser.getUserLoginUI()));
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getUserLoginUI(),
                servingUser.getUserLoginUI(), currentUrl);
        LoginUser loginUser = new LoginUser(testUserEmail, testUserPassword);
        accessToken = servingUser.loginUser(loginUser).getHeader("Authorization");
    }

    @Test
    @Step("Тест регистрации с некорректным паролем")
    public void registrationWithInvalidPasswordTest() {
        driver.get(servingUser.getUserRegister());
        registerPage.enterName(testUserName);
        registerPage.enterEmail(testUserEmail);
        registerPage.enterPassword("123");
        registerPage.clickRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        assertTrue(errorMessage.contains("Некорректный пароль"));
    }
}
