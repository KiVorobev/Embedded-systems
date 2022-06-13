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
        <#include "../styles/delete_scanner.css">
    </style>
    <script>
        <#include "../scripts/jquery-3.6.0.js">
        <#include "../scripts/navigator.js">
        <#include "../scripts/sender.js">
        <#include "../scripts/data_collector.js">
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
    <label for="delete_scanner_input">ID:</label><input id="delete_scanner_input" type="text"/>
    <div id="delete_scanner_buttons">
        <button onclick=goTo('scanners')>Отмена</button>
        <button id="delete_scanner_button" onclick=deleteScanner()>Удалить</button>
    </div>
</main>
</body>
</html>