# Проект по автоматизации тестирования API
<p align="center">
<a href="https://reqres.in/"><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/reqres.jpg"/></a>
</p>

## :card_file_box: Содержание
- [Технологии и инструменты](#bookmark-технологии-и-инструменты)
- [Запуск из терминала](#bookmark-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#bookmark--jenkins--job-)
- [Allure отчет](#bookmark--отчет-в-allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)


## :bookmark: Технологии и инструменты
<p align="center">
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Github.svg" width="50" height="50"  alt="Github"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/JUnit5.svg" width="50" height="50"  alt="JUnit5"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Rest-Assured.svg" width="50" height="50"  alt="Rest-Assured"/></a>
</p>

## :bookmark: Запуск тестов из терминала
Удаленный запуск:
```
./ gradlew clean test
```
## :bookmark: <img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/rest-api-reqres/"> job </a> 
<a><img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/screens/job.png"/></a>

## :bookmark: <img src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/rest-api-reqres/allure/">Allure report</a>

### Обзор сборки
<p align="center">
<img title="Allure Overview Dashboard" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/screens/overview.jpg">
</p>

### Тесты
<p align="center">
<img title="Allure Suites" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/screens/tests.jpg">
</p>

### :bar_chart: Графики
<p align="center">
<img title="Allure Graphs" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/screens/graphs.jpg">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="https://plugins.jetbrains.com/files/12513/281379/icon/pluginIcon.svg"  width="25" height="25"> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/3421/dashboards)
На вкладке Dashboards отображается:
- Количество тест-кейсов и их статус
- Соотношение ручных/автоматизированных тестов
<p align="center">
<img title="Allure TestOps DashBoard" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/screens/testops.png">
</p>
<p align="center">
<img title="Allure TestOps test-cases" src="https://github.com/LinaAlekseeva/rest-api-reqres/blob/main/src/test/resources/screens/suites.png">
</p>
