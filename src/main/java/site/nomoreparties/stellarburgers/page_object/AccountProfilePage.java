package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    private WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "Войти"
    private final By buttonEnter = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");
    // кнопка "Конструктор"
    private final By buttonConstructor = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    // логотип "Stellar Burgers"
    private final By logoStellarBurgers = By.xpath(".//*[@class = 'AppHeader_header__X9aJA pb-4 pt-4']//*[@class = 'AppHeader_header__logo__2D0X2']");
    // кнопка "Выход" в личном кабинете
    private final By buttonLogout = By.xpath(".//main[@class = 'App_componentContainer__2JC2W']//button[text() = 'Выход']");

    public AccountProfilePage clickButtonEnter() {
        driver.findElement(buttonEnter).click();
        return this;
    }

    public AccountProfilePage clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
        return this;
    }

    public AccountProfilePage clickButtonLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
        return this;
    }

    public AccountProfilePage clickButtonLogout() {
        driver.findElement(buttonLogout).click();
        return this;
    }
}
