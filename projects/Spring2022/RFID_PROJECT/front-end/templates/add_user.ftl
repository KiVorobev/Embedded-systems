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
        <#include "../styles/add_user.css">
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
    <button onclick=goTo('start')>Главная страница</button>
    <button onclick=goTo('user/put')>Добавить пользователя</button>
    <button onclick=goTo('scanners')>Считыватели</button>
    <button onclick=goTo('user/search')>Поиск</button>
</header>
<main>
    <div id="left">
        <label id="role_label" for="role_select">Роль:</label>
        <select id="role_select">
            <option selected disabled>Выберите роль</option>
            <option>USER</option>
            <option>ADMIN</option>
        </select>
    </div>

    <div id="right">
        <label id="id_label" for="card_id">ID карты:</label>
        <input id="card_id" type="text" placeholder="Введите ID карты"/>
        <br/>
        <label id="surname_label" for="surname">Фамилия:</label>
        <input id="surname" type="text" placeholder="Введите фамилию"/>
        <br/>
        <label id="name_label" for="name">Имя:</label>
        <input id="name" type="text" placeholder="Введите имя"/>
        <br/>
        <label id="patronymic_label" for="patronymic">Отчество:</label>
        <input id="patronymic" type="text" placeholder="Введите отчество"/>
        <div id="add_user_buttons">
            <button onclick="goTo('start')">Отмена</button>
            <button id="add_user_button" onclick="addUser()">Сохранить</button>
        </div>
    </div>
</main>
</body>
</html>