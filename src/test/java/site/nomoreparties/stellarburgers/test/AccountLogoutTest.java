package site.nomoreparties.stellarburgers.test;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.page_object.AccountProfilePage;
import site.nomoreparties.stellarburgers.servinguser.CreateUser;
import site.nomoreparties.stellarburgers.servinguser.ServingUser;
import site.nomoreparties.stellarburgers.page_object.LoginPage;
import site.nomoreparties.stellarburgers.page_object.MainPage;
import webDriver.BrowserParameters;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)

public class AccountLogoutTest extends BaseTest{

    private webDriver.Browser browser;
    private CreateUser createUser;
    private ServingUser servingUser;
    private ServingUser user = new ServingUser();
    private String accessToken;

    public AccountLogoutTest(webDriver.Browser browser) {
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
    @Step("Тест выхода по кнопке «Выйти» в личном кабинете")
    public void loginPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get(servingUser.getBaseUrl());
        mainPage.clickLoginButtonMain();
        loginPage.enterEmail("test-users@yandex.ru");
        loginPage.enterPassword("1234567");
        loginPage.clickLoginButton();
        mainPage.clickPersonalAccountButton();
        accountProfilePage.clickButtonLogout();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getAccountProfile(),
                servingUser.getAccountProfile(), currentUrl);
    }
}
