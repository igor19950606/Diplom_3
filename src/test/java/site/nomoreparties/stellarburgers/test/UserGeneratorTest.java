package site.nomoreparties.stellarburgers.test;

import java.util.UUID;

public class UserGeneratorTest {

    public static String generateUniqueEmail() {
        String uniqueSuffix = UUID.randomUUID().toString();
        return "Test" + uniqueSuffix + "@yandex.ru";
    }

    public static String generateUniqueName() {
        String uniqueSuffix = UUID.randomUUID().toString();
        return "Testov" + uniqueSuffix;
    }
}

