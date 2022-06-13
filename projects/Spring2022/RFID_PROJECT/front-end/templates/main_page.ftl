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
    <nav style="width: 100%">
        <p style="margin-left: 2.3%"><a onclick=goTo('start')><span>Главная страница</span></a></p>
        <p><a onclick=goTo('add')><span>Добавить пользователя</span></a></p>
        <p><a onclick=goTo('scanners')><span>Считыватели</span></a></p>
        <p><a onclick=goTo('search')><span>Поиск</span></a></p>
    </nav>
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
                            <td>${activity.user.surname} ${activity.user.name} ${activity.user.patronymic}</td>
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