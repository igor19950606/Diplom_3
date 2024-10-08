package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Поле ввода "Имя"
    private final By fieldName = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//fieldset[1]//input[@name = 'name']");
    // Поле ввода "Email"
    private final By fieldEmail = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//fieldset[2]//input[@name = 'name']");
    // Поле ввода "Пароль"
    private final By fieldPassword = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//fieldset[3]//input[@name = 'Пароль']");
    // Кнопка "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//button[text() = 'Зарегистрироваться']");
    // Надпись "Некорректный пароль"
    private final By messageIncorrectPassword = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']//fieldset[3]//*[text() = 'Некорректный пароль']");

    public void enterName(String name) {
        WebElement nameField = driver.findElement(fieldName);
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(fieldEmail);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(fieldPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(buttonRegister).click();
    }

    public String getErrorMessage() {
        return driver.findElement(messageIncorrectPassword).getText();
    }
}


