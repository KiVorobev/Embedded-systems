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
    <nav style="width: 100%">
        <p style="margin-left: 2.3%"><a onclick=goTo('start')><span>Главная страница</span></a></p>
        <p><a href="add_user.ftl"><span>Добавить пользователя</span></a></p>
        <p><a onclick=goTo('scanners')><span>Считыватели</span></a></p>
        <p><a href="search.ftl"><span>Поиск</span></a></p>
    </nav>
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
        <label id="id_label" for="user_id">ID:</label>
        <input id="user_id" type="text" placeholder="Введите ID"/>
        <br/>
        <label id="surname_label" for="surname">Фамилия:</label>
        <input id="surname" type="text" placeholder="Введите фамилию" value="${user.surname}"/>
        <br/>
        <label id="name_label" for="name">Имя:</label>
        <input id="name" type="text" placeholder="Введите имя" value="${user.name}"/>
        <br/>
        <label id="patronymic_label" for="patronymic">Отчество:</label>
        <input id="patronymic" type="text" placeholder="Введите отчество" value="${user.patronymic}"/>
        <div id="add_user_buttons">
            <button onclick="goTo('start')">Отмена</button>
            <button id="add_user_button" onclick="addUser()">Сохранить</button>
        </div>
    </div>
</main>
</body>
</html>