# Тестирование REST-сервисов 
- В этом проекте используются тесты API с использованием JUnit 5, Rest-Assured, Jackson.
- Также в отдельном файле (sql.txt/sql.docx) содержатся SQL-запросы из песочницы https://sql-academy.org/ru/sandbox 'Расписания'.

## Функциональность

### Класс AllTests служит точкой входа для набора тестов.
- testTrain тестирует контроллер response-train-controller
  - testEasyNumsOk — проверяет ответ на правильность ввода чисел.
  - testBadRequest — гарантирует, что API правильно обрабатывает неверные запросы.
  - testNotFound — проверяет реакцию API на ненайденные ресурсы. 
- testFile тестирует контроллер files-controller
  - UnloadTestFile — проверяет функциональность загрузки файлов.
  - DownloadTestFile — оценивает возможность загрузки файлов.
- testUserGameJwt тестирует несколько контроллеров  jwt-authentication-controller,user-controller-new,game-controller-new
  - SuccessRegTest — обеспечивает успешную регистрацию пользователя.
  - getTestAToken — проверяет получение токена JWT.
  ### Следующие тесты, связанные с игрой:
  - getTestBAllGames — извлекает все игры.
  - getTestCAddGame — проверяет функциональность добавления игры.
  - getTestDAllGamesUp — проверяет функцию обновления во всех играх.
  - getTestEDeleteGame — тестирует процесс удаления игры.

  ### Завершается тестированием действий пользователя, включая:
  - getPutUser — изменяет данные пользователя.
  - getGetUser — получает информацию о пользователе.
  - getDeleteUser — подтверждает удаление пользователя.

## Используемые технологии

- Язык программирования: Java 17
- Тестовый фреймворк: JUnit Jupiter 5.10.1
- Библиотека для тестирования RESTful API: Rest-Assured 5.4.0
- Библиотеки для работы с JSON:
  - com.fasterxml.jackson.core:jackson-annotations:2.14.3
  - com.fasterxml.jackson.core:jackson-databind:2.14.3
  - com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.3
