package site.nomoreparties.stellarburgers.test;

import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.page_object.MainPage;
import site.nomoreparties.stellarburgers.servinguser.ServingUser;
import webDriver.BrowserParameters;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {

    private webDriver.Browser browser;
    private ServingUser servingUser;

    public ConstructorTest(webDriver.Browser browser) {
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
    @Step("Тест перехода к разделу:'Начинки'")
    public void refuelingSectionTest() {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fillingsElement = wait.until(ExpectedConditions.visibilityOf(mainPage.getFillingsElement()));
        assertTrue(fillingsElement.isDisplayed());
    }
    @Test
    @Step("Тест перехода к разделу:'Соусы'")
    public void saucesSectionTest() {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SaucesElement = wait.until(ExpectedConditions.visibilityOf(mainPage.getSaucesElement()));
        assertTrue(SaucesElement.isDisplayed());
    }
    @Test
    @Step("Тест перехода к разделу:'Булки'")
    public void breadSectionTest() {
        driver.get(servingUser.getBaseUrl());
        MainPage mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement BreadElement = wait.until(ExpectedConditions.visibilityOf(mainPage.getBreadElement()));
        assertTrue(BreadElement.isDisplayed());
    }
}
