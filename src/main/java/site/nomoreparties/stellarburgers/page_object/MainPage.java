package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Войти в аккаунт" на главной
    private final By buttonLoginMain = By.xpath(".//div[@class = 'BurgerConstructor_basket__container__2fUl3 mt-10']//button[text()='Войти в аккаунт']");
    // Кнопка "Личный Кабинет"
    private final By buttonPersonalAccount = By.xpath(".//header[@class = 'AppHeader_header__X9aJA pb-4 pt-4']//*[text() = 'Личный Кабинет']");
    // Раздел начинки
    private final By fillingsSectionTab = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']//div/div[3]");
    // Изображение "Мясо бессмертных моллюсков Protostomia"
    private final By fillingsImage = By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    // Раздел соусы
    private final By saucesSectionTab = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[2]");
    // Изображение "Соус традиционный галактический"
    private final By saucesImage = By.xpath(".//img[@alt='Соус традиционный галактический']");
    // Раздел Булки
    private final By breadSectionTab = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[1]");
    // Изображение "Краторная булка N-200i"
    private final By breadImage = By.xpath(".//img[@alt='Краторная булка N-200i']");


    public MainPage clickLoginButtonMain() {
        driver.findElement(buttonLoginMain).click();
        return this;
    }

    public MainPage clickPersonalAccountButton() {
        driver.findElement(buttonPersonalAccount).click();
        return this;
    }

    public MainPage clickFillingsSection() {
        WebElement fillingsTab = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fillingsSectionTab));
        fillingsTab.click();
        return this;
    }

    public WebElement getFillingsElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsImage));
    }

    public MainPage clickSaucesSection() {
        WebElement fillingsTab = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saucesSectionTab));
        fillingsTab.click();
        return this;
    }

    public WebElement getSaucesElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesImage));
    }

    public WebElement getBreadElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(breadImage));
    }

}
