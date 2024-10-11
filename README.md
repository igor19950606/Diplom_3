

# Задание 3: веб-приложение

Технологии:

| Технология               | Версия  |
|--------------------------|---------|
| Java                     | 11      |
| Maven                    | 4.0.0   |
| Selenium                 | 4.25.0  |
| Allure                   | 2.18.1  |
| Rest-Assured             | 5.5.0   |
| Lombok                   | 1.18.34 |
| Jackson Databind         | 2.14.0  |
| JUnit                    | 4.13.2  |
| Annotations (JetBrains)  | 24.0.0  |

В последнем задании тебе нужно протестировать веб-приложение Stellar Burgers.
# Что нужно сделать
Опиши элементы, которые будешь использовать в тестах, с помощью Page Object.

Протестируй функциональность в Google Chrome и Яндекс.Браузере. Про кроссбраузерные тесты рассказывали на вебинаре. Чтобы вспомнить основное, загляни в шпаргалку.

Подключи Allure-отчёт.

# Регистрация
Проверь:
- Успешную регистрацию. 
- Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
# Вход
Проверь:
- вход по кнопке «Войти в аккаунт» на главной, 
- вход через кнопку «Личный кабинет», 
- вход через кнопку в форме регистрации, 
- вход через кнопку в форме восстановления пароля.
# Переход в личный кабинет
Проверь переход по клику на «Личный кабинет».
# Переход из личного кабинета в конструктор
Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
# Выход из аккаунта
Проверь выход по кнопке «Выйти» в личном кабинете.
# Раздел «Конструктор»
Проверь, что работают переходы к разделам:
- «Булки», 
- «Соусы», 
- «Начинки».
# Как выполнить и сдать работу
Напиши код в IDEA и запушь ветку develop3 на GitHub. Сделай пул-реквест. Подробная инструкция.
# Как будут оценивать твою работу
1. Тесты в test/java.
2. Для Page Object создан отдельный пакет. 
3. Для каждой страницы создан отдельный класс с Page Object. 
4. Тесты разделены по тематике или функциональности. Для тестов созданы отдельные классы. 
5. В файле pom.xml нет ничего лишнего. 
6. Все элементы страниц, которые ты используешь в тестах, описаны в Page Object. 
7. Название класса Page Object отражает его содержимое. 
8. Названия локаторов понятны. 
9. Тесты запускаются и не падают. 
10. Автотесты запускаются в обоих браузерах. 
11. Для всех шагов автотестов должна быть использована аннотация @Step. 
12. Названия тестов понятные и неизбыточные. 
13. Тест — прежде всего проверка, а не набор действий. Каждый тест что-то проверяет. 
14. Нужные тестовые данные создаются перед тестом и удаляются после того, как он выполнится. 
15. Если для теста нужен тестовый юзер, он создаётся с помощью API. 
16. Есть все тесты, которые описаны в задании. 
17. Сделан Allure-отчёт. Отчёт добавлен в пул-реквест. 
18. В проекте используется Java 11.