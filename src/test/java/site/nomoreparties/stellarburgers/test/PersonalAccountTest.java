package site.nomoreparties.stellarburgers.test;

import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.page_object.AccountProfilePage;
import site.nomoreparties.stellarburgers.servinguser.ServingUser;
import site.nomoreparties.stellarburgers.page_object.MainPage;
import webDriver.BrowserParameters;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class PersonalAccountTest extends BaseTest{

    private webDriver.Browser browser;
    private ServingUser servingUser;

    public PersonalAccountTest(webDriver.Browser browser) {
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

    }

    @Test
    @Step("Тест проверки перехода по клику на'Личный кабинет'")
    public void GoPersonalAccountTest() {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getUserLoginUI(),
                servingUser.getUserLoginUI(), currentUrl);
    }

    @Test
    @Step("Тест проверки перехода по клику из личного кабинета на'Конструктор'")
    public void ConstructorTransitionTest () {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        accountProfilePage.clickButtonConstructor();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getBaseUrl(),
                servingUser.getBaseUrl(), currentUrl);
    }

    @Test
    @Step("Тест проверки перехода по клику из личного кабинета на логотип 'Stellar Burgers'")
    public void LogoTransitionTest () {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        accountProfilePage.clickButtonLogoStellarBurgers();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL должен быть " + servingUser.getBaseUrl(),
                servingUser.getBaseUrl(), currentUrl);
    }
}
