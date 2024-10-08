package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {

    // Сделаем метод getWebDriver публичным, чтобы его можно было вызывать из других пакетов
    public WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\IAPonomarev\\WebDriver\\bin\\chromedriver.exe");
                return new ChromeDriver();
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\IAPonomarev\\WebDriver\\bin\\yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Неверно задан браузер: " + browser);
        }
    }
}
