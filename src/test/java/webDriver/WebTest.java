package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebTest {

    private Properties properties;

    public WebTest() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Не удалось найти конфиг");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
                return new ChromeDriver();
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("yandex.driver.path"));
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Неверный браузер: " + browser);
        }
    }
}
