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
        <#include "../styles/user_page.css">
    </style>
    <script>
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
    <div id="left">
        <div id="name">
            <div class="topic">ФИО:
                </br>
                <text class="content">${user.surname} ${user.name} ${user.patronymic}</text>
            </div>
        </div>
        <div id="role">
            <div class="topic">Роль:
                <#if user.role == 'USER'>
                    <text id="role-block" class="content">Пользователь</text>
                <#else>
                    <text id="role-block" class="content">Админ</text>
                </#if>
            </div>
        </div>
        <div id="user_id">
            <div class="topic">ID:
                <text class="content">${user.userId}</text>
            </div>
        </div>
        <button onclick=goTo('user/edit/${user.userId}')>Редактировать профиль</button>
    </div>
    <div id="right">
        <ul>
            <div id="scroll-table">
                <table>
                    <caption>Последняя активность:</caption>
                    <thead>
                    <tr>
                        <th>№ считывателя</th>
                        <th>Дата и время</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="scroll-table-body">
                <table>
                    <tbody>
                    <#list activities as activity>
                        <tr>
                            <td>${activity.scanner.hardwareNumber}</td>
                            <td>${activity.enterActivity}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </ul>
    </div>
</main>
</body>
</html>