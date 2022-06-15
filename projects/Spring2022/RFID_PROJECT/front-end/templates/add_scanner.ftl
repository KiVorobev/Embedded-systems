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
        <#include "../styles/add_scanner.css">
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        <#include "../scripts/navigator.js">
        <#include "../scripts/role_converter.js">
        <#include "../scripts/validator.js">
        <#include "../scripts/sender.js">
        <#include "../scripts/data_collector.js">
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
    <div id="id-block">
        <label id="id_label" for="add_scanner_input">ID:</label>
        <input id="add_scanner_input" type="text"/>
    </div>

    <div id="role-block">
        <label id="role_label" for="scanner_role_select">Роль:</label>
        <select id="scanner_role_select">
            <option selected disabled>Выберите роль</option>
            <option>Пользователь</option>
            <option>Админ</option>
        </select>
    </div>

    <div id="add_scanner_buttons">
        <button onclick=goTo('scanners')>Отмена</button>
        <button id="add_scanner_button" onclick="addScanner()">Добавить</button>
    </div>
</main>
</body>
</html>