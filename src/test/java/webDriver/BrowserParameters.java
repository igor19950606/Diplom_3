package webDriver;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class BrowserParameters {

    @Parameterized.Parameters(name = "{index}: Тест браузера {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {webDriver.Browser.CHROME}, // Первый тест с Chrome
                {webDriver.Browser.YANDEX}  // Второй тест с Яндексом
        });
    }
}

