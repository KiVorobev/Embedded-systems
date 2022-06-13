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
        <#include "../styles/scanners.css">
    </style>
    <script>
        <#include "../scripts/navigator.js">
    </script>

</head>
<body>
<header>
    <nav style="width: 100%">
        <p style="margin-left: 2.3%"><a onclick=goTo('start')><span>Главная страница</span></a></p>
        <p><a href="add_user.ftl"><span>Добавить пользователя</span></a></p>
        <p><a onclick=goTo('scanners')><span>Считыватели</span></a></p>
        <p><a href="search.ftl"><span>Поиск</span></a></p>
    </nav>
</header>
<main>
    <ul>
        <div id="main_activity_table">
            <div id="scroll-table">
                <table>
                    <caption>Считыватели:</caption>
                    <thead>
                    <tr>
                        <th>№ считывателя</th>
                        <th>ID</th>
                        <th>Требуемая роль</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="scroll-table-body">
                <table>
                    <tbody>
                    <#list scanners as scanner>
                        <tr>
                            <td>${scanner.id}</td>
                            <td>${scanner.hardwareNumber}</td>
                            <td>${scanner.role}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="scanner_buttons">
            <button id="add_scanner" onclick="goTo('scanner/put')">Добавить считыватель</button>
            <button id="delete_scanner" onclick="goTo('scanner/remove')">Удалить считыватель</button>
        </div>
    </ul>
</main>
</body>
</html>