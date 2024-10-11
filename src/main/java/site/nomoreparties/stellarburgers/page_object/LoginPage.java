package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле ввода "Email"
    private final By fieldEmail = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//fieldset[1]//input[@name = 'name']");
    // Поле ввода "Пароль"
    private final By fieldPassword = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//fieldset[2]//input[@name = 'Пароль']");
    // Кнопка "Войти"
    private final By buttonLogin = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//button[text() = 'Войти']");

    public LoginPage enterEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(buttonLogin).click();
        return this;
    }

}
