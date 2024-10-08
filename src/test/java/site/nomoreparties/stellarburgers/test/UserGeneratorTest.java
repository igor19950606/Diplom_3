package site.nomoreparties.stellarburgers.test;

import java.util.UUID;

public class TestUserGenerator {

    public static String generateUniqueEmail() {
        String uniqueSuffix = UUID.randomUUID().toString();
        return "john" + uniqueSuffix + "@example.com"; // Генерация уникального email
    }

    public static String generateUniqueName() {
        String uniqueSuffix = UUID.randomUUID().toString();
        return "John Doe " + uniqueSuffix; // Генерация уникального имени
    }
}

