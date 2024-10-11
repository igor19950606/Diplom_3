package site.nomoreparties.stellarburgers.test;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.page_object.AccountProfilePage;
import site.nomoreparties.stellarburgers.servinguser.CreateUser;
import site.nomoreparties.stellarburgers.servinguser.ServingUser;
import site.nomoreparties.stellarburgers.page_object.LoginPage;
import site.nomoreparties.stellarburgers.page_object.MainPage;
import webDriver.BrowserParameters;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    private webDriver.Browser browser;
    private CreateUser createUser;
    private ServingUser servingUser;
    private ServingUser user = new ServingUser();
    private String accessToken;

    public LoginTest(webDriver.Browser browser) {
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

        createUser = new CreateUser("test-users@yandex.ru", "1234567", "TestUser");
        Response createResponse = user.CreateUser(createUser);
        accessToken = createResponse.jsonPath().getString("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            servingUser.deleteUser(accessToken);
        }
    }

    @Test
    @Step("Тест входа по кнопке 'Войти в аккаунт'")
    public void loginByMainPageButtonTest() {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMain();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-users@yandex.ru");
        loginPage.enterPassword("1234567");
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(servingUser.getBaseUrl()));
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть",
                servingUser.getBaseUrl(), currentUrl);
    }

    @Test
    @Step("Тест входа через 'Личный кабинет'")
    public void loginPersonalAccountTest() {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-users@yandex.ru");
        loginPage.enterPassword("1234567");
        loginPage.clickLoginButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getUserLoginUI(),
                servingUser.getUserLoginUI(), currentUrl);
    }

    @Test
    @Step("Тест входа через кнопку в форме регистрации")
    public void LoginButtonRegistrationFormTest() {
        driver.get(servingUser.getUserRegister());
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickButtonEnter();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-users@yandex.ru");
        loginPage.enterPassword("1234567");
        loginPage.clickLoginButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getUserLoginUI(),
                servingUser.getUserLoginUI(), currentUrl);
    }

    @Test
    @Step("Тест входа через кнопку в форме восстановления пароля.")
    public void loginButtonPasswordRecoveryFormTest() {
        driver.get(servingUser.getRecovery());
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickButtonEnter();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-users@yandex.ru");
        loginPage.enterPassword("1234567");
        loginPage.clickLoginButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getUserLoginUI(),
                servingUser.getUserLoginUI(), currentUrl);

    }
}


