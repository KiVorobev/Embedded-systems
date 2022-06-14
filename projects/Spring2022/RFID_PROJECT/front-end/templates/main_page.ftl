<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RFID System</title>
    <style type="text/css">
        <#include "../styles/index.css">
        <#include "../styles/header.css">
        <#include "../styles/main_page.css">
    </style>
    <script>
        <#include "../scripts/jquery-3.6.0.js">
        <#include "../scripts/navigator.js">
    </script>
</head>
<body>
<header>
    <div onclick=goTo('start')>Главная страница</div>
    <div onclick=goTo('user/put')>Добавить пользователя</div>
    <div onclick=goTo('scanners')>Считыватели</div>
    <div onclick=goTo('user/search')>Поиск</div>
</header>
<main>
    <ul>
        <div id="main_activity_table">
            <div id="scroll-table">
                <table>
                    <caption>Последняя активность:</caption>
                    <thead>
                    <tr>
                        <th>№ считывателя</th>
                        <th>Дата и время</th>
                        <th>ФИО</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="scroll-table-body">
                <table>
                    <tbody>
                    <#list activities as activity>
                        <tr>
                            <td>${activity.scannerHardwareNum}</td>
                            <td>${activity.enterActivity}</td>
                            <td onclick="goTo('user/get/${activity.user.id}')">${activity.user.surname} ${activity.user.name} ${activity.user.patronymic}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </ul>
</main>
</body>
</html>