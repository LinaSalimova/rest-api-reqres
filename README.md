# Проект по автоматизации тестирования API
<p align="center">
<a href="https://reqres.in/"><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/reqres.jpg"/></a>
</p>

## :card_file_box: Содержание
- [Технологии и инструменты](#bookmark-технологии-и-инструменты)
- [Запуск из терминала](#bookmark-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#bookmark--jenkins--job-)
- [Allure отчет](#bookmark--отчет-в-allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)

## :bookmark: Технологии и инструменты
<p align="center">
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Github.svg" width="50" height="50"  alt="Github"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/JUnit5.svg" width="50" height="50"  alt="JUnit5"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Rest-Assured.svg" width="50" height="50"  alt="Rest-Assured"/></a>
</p>

## :heavy_check_mark: Реализованные проверки
- Получение списка пользователей
- Создание пользователя
- Удаление пользователя
- Получение данных о несуществующем пользователе
- Редактирование данных пользователя
- Получение данных о ресурсе

## :bookmark: Запуск тестов из терминала
Удаленный запуск:
```
./ gradlew clean test
```
## :bookmark: <img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/rest-api-reqres/"> job </a> 
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/screens/job.png"/></a>

## :bookmark: <img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/rest-api-reqres/allure/">Allure report</a>

### Обзор сборки
<p align="center">
<img title="Allure Overview Dashboard" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/screens/overview.jpg">
</p>

### Тесты
<p align="center">
<img title="Allure Suites" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/screens/tests.jpg">
</p>

### :bar_chart: Графики
<p align="center">
<img title="Allure Graphs" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/screens/graphs.jpg">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Allure_TO.svg"  width="25" height="25"> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/3421/dashboards)
На вкладке Dashboards отображается:
- Количество тест-кейсов и их статус
- Соотношение ручных/автоматизированных тестов
<p align="center">
<img title="Allure TestOps DashBoard" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/screens/testops.png">
</p>
## :bookmark: <img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/rest-api-reqres/"> job </a> 
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/screens/job.png"/></a>

## :bookmark: <img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/logo/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомления в Telegram <a target="_blank" >
</p>  После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.


